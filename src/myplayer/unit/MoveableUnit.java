package myplayer.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitType;
import myplayer.symmetry.HorizontalSymmetry;
import myplayer.symmetry.RotationalSymmetry;
import myplayer.symmetry.VerticalSymmetry;

import java.util.ArrayList;
import java.util.List;

public abstract class MoveableUnit extends Unit {
    private Location currentTarget;
    private boolean isWallFollowing;
    private int distanceBeforeWallFollowing;
    private boolean wallOnRight;
    private Location lastFollowedWall;

    private Direction previousDirection = Direction.ZERO;

    private Location explorationTarget;

    private boolean[] canMove;
    private int canMoveLength = Direction.values().length;

    public MoveableUnit(UnitController uc, UnitType type) {
        super(uc, type);
    }

    @Override
    public void run() {
        super.run();

        sharedArray.registerUnit();
    }

    protected void explore() {
        if (!sharedArray.hasMapSize()) {
            findBoundaries();
            return;
        } else if (!sharedArray.hasOpponentHQ() && tryFindOpponentHQ()) {
            return;
        }

        int minX = sharedArray.getMinX();
        int maxX = sharedArray.getMaxX();
        int minY = sharedArray.getMinY();
        int maxY = sharedArray.getMaxY();

        if (explorationTarget == null
            || exploredTiles.isExplored(explorationTarget)
            || uc.canSenseLocation(explorationTarget)) {
            int attempts = 10;

            for (int i = 0; i < attempts; i++) {
                int x = random.nextInt(minX, maxX + 1);
                int y = random.nextInt(minY, maxY + 1);
                Location location = new Location(x, y);

                if (i != attempts - 1 && exploredTiles.isExplored(location)) {
                    continue;
                }

                explorationTarget = new Location(x, y);
                break;
            }
        }

        moveTo(explorationTarget);
    }

    private void findBoundaries() {
        boolean hasMinX = sharedArray.hasMinX();
        boolean hasMaxX = sharedArray.hasMaxX();
        boolean hasMinY = sharedArray.hasMinY();
        boolean hasMaxY = sharedArray.hasMaxY();

        List<Direction> directions = new ArrayList<>();

        if (!hasMinX) directions.add(Direction.WEST);
        if (!hasMaxX) directions.add(Direction.EAST);
        if (!hasMinY) directions.add(Direction.SOUTH);
        if (!hasMaxY) directions.add(Direction.NORTH);
        if (!hasMinX && !hasMinY) directions.add(Direction.SOUTHWEST);
        if (!hasMinX && !hasMaxY) directions.add(Direction.NORTHWEST);
        if (!hasMaxX && !hasMaxY) directions.add(Direction.NORTHEAST);
        if (!hasMaxX && !hasMinY) directions.add(Direction.SOUTHEAST);

        Direction direction = directions.get(uc.getInfo().getID() % directions.size());
        moveTo(myHQ.add(direction.dx * 100, direction.dy * 100));
    }

    private boolean tryFindOpponentHQ() {
        List<Location> options = new ArrayList<>();

        Location option = new RotationalSymmetry(sharedArray).reflect(myHQ);
        if (!exploredTiles.isExplored(option)) options.add(option);

        option = new HorizontalSymmetry(sharedArray).reflect(myHQ);
        if (!exploredTiles.isExplored(option)) options.add(option);

        option = new VerticalSymmetry(sharedArray).reflect(myHQ);
        if (!exploredTiles.isExplored(option)) options.add(option);

        if (options.size() == 1) {
            sharedArray.setOpponentHQ(options.get(0));
            return false;
        }

        moveTo(options.get(uc.getInfo().getID() % options.size()));
        return true;
    }

    protected void moveTo(Location target) {
        Location myLocation = uc.getLocation();

        uc.drawLineDebug(myLocation, target, 255, 0, 0);
        sharedArray.setMoveTarget(target);

        if (!uc.canMove() || myLocation.isEqual(target) || uc.getRound() % 2 == 1) {
            return;
        }

        if (!target.isEqual(currentTarget)) {
            currentTarget = target;
            isWallFollowing = false;
        }

        updateCanMove();

        int currentDistance = myLocation.distanceSquared(target);
        if (isWallFollowing && currentDistance <= distanceBeforeWallFollowing) {
            isWallFollowing = false;
        }

        if (!isWallFollowing) {
            Direction forward = myLocation.directionTo(target);
            if (canMove[forward.ordinal()]) {
                tryMove(forward);
                return;
            } else {
                isWallFollowing = true;
                distanceBeforeWallFollowing = currentDistance;
                setInitialWallFollowingDirection();
            }
        }

        followWall(true);
    }

    private void setInitialWallFollowingDirection() {
        Location myLocation = uc.getLocation();

        Direction forward = myLocation.directionTo(currentTarget);

        Direction left = forward.rotateLeft();
        int leftDistance = Integer.MAX_VALUE;

        Direction right = forward.rotateRight();
        int rightDistance = Integer.MAX_VALUE;

        for (int i = 0; i < 8; i++) {
            Location location = myLocation.add(left);
            if (uc.isOutOfMap(location)) {
                break;
            }

            if (canMove[left.ordinal()]) {
                leftDistance = location.distanceSquared(currentTarget);
                break;
            }

            left = left.rotateLeft();
        }

        for (int i = 0; i < 8; i++) {
            Location location = myLocation.add(right);
            if (uc.isOutOfMap(location)) {
                break;
            }

            if (canMove[right.ordinal()]) {
                rightDistance = location.distanceSquared(currentTarget);
                break;
            }

            right = right.rotateRight();
        }

        if (leftDistance < rightDistance) {
            wallOnRight = true;
            lastFollowedWall = myLocation.add(left.rotateRight());
        } else {
            wallOnRight = false;
            lastFollowedWall = myLocation.add(right.rotateLeft());
        }
    }

    private void followWall(boolean canRotate) {
        Location myLocation = uc.getLocation();

        Direction direction = myLocation.directionTo(lastFollowedWall);

        for (int i = 0; i < 8; i++) {
            direction = wallOnRight ? direction.rotateLeft() : direction.rotateRight();
            Location location = myLocation.add(direction);

            if (canRotate && uc.isOutOfMap(location)) {
                wallOnRight = !wallOnRight;
                followWall(false);
                return;
            }

            if (canMove[direction.ordinal()]) {
                previousDirection = direction;
                uc.move(direction);
                return;
            }

            lastFollowedWall = location;
        }

        previousDirection = Direction.ZERO;
    }

    private void updateCanMove() {
        canMove = new boolean[canMoveLength];

        Location myLocation = uc.getLocation();
        UnitInfo[] opponentUnits = uc.senseUnits(18, opponentTeam);

        outer:
        for (Direction direction : adjacentDirections) {
            if (direction == previousDirection.opposite() || !uc.canMove(direction)) {
                continue;
            }

            Location moveLocation = myLocation.add(direction);

            for (UnitInfo unit : opponentUnits) {
                if (unit.getType() != UnitType.BATTER) {
                    continue;
                }

                int distance = moveLocation.distanceSquared(unit.getLocation());
                if (distance <= 2) {
                    continue outer;
                }

                if (distance <= 8) {
                    for (Direction inBetweenDirection : adjacentDirections) {
                        Location inBetweenLocation = moveLocation.add(inBetweenDirection);
                        if (uc.isOutOfMap(inBetweenLocation)
                            || inBetweenLocation.distanceSquared(unit.getLocation()) > 2) {
                            continue;
                        }

                        MapObject inBetweenMapObject = uc.senseObjectAtLocation(inBetweenLocation, true);
                        if (inBetweenMapObject == MapObject.WATER || inBetweenMapObject == MapObject.BALL) {
                            continue;
                        }

                        UnitInfo inBetweenUnit = uc.senseUnitAtLocation(inBetweenLocation);
                        if (inBetweenUnit != null) {
                            continue;
                        }

                        continue outer;
                    }
                }
            }

            canMove[direction.ordinal()] = true;
        }
    }

    protected boolean tryMoveRandom() {
        if (!uc.canMove()) {
            return false;
        }

        for (Direction direction : random.shuffle(adjacentDirections.clone())) {
            if (tryMove(direction)) {
                return true;
            }
        }

        return false;
    }

    protected boolean tryMove(Direction direction) {
        if (uc.canMove(direction)) {
            previousDirection = direction;
            uc.drawLineDebug(uc.getLocation(), uc.getLocation().add(direction), 0, 255, 0);
            uc.move(direction);
            return true;
        }

        return false;
    }
}
