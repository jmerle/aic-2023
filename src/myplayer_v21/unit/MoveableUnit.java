package myplayer_v21.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer_v21.symmetry.HorizontalSymmetry;
import myplayer_v21.symmetry.RotationalSymmetry;
import myplayer_v21.symmetry.VerticalSymmetry;

import java.util.ArrayList;
import java.util.List;

public abstract class MoveableUnit extends Unit {
    private Location currentTarget;
    private boolean isWallFollowing;
    private int distanceBeforeWallFollowing;
    private boolean wallOnRight;
    private Location lastFollowedWall;

    private Location explorationTarget;

    private UnitInfo[] opponentUnits = null;
    private int opponentUnitsRound = -1;

    public MoveableUnit(UnitController uc, UnitType type) {
        super(uc, type);
    }

    @Override
    public void run() {
        super.run();
    }

    protected void explore() {
        if (!sharedArray.hasMapSize()) {
            findBoundaries();
            return;
        } else if (sharedArray.getOpponentHQ() == null && tryFindOpponentHQ()) {
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

        if (myLocation.isEqual(target)) {
            return;
        }

        if (!target.isEqual(currentTarget)) {
            currentTarget = target;
            isWallFollowing = false;
        }

        int currentDistance = myLocation.distanceSquared(target);
        if (isWallFollowing && currentDistance < distanceBeforeWallFollowing) {
            isWallFollowing = false;
        }

        if (isWallFollowing && lastFollowedWall != null && uc.canSenseLocation(lastFollowedWall) && isPassable(lastFollowedWall)) {
            isWallFollowing = false;
        }

        if (!isWallFollowing) {
            Direction forward = myLocation.directionTo(target);
            if (isPassable(myLocation.add(forward))) {
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

            if (isPassable(location)) {
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

            if (isPassable(location)) {
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

            if (isPassable(location) && tryMove(direction)) {
                return;
            }

            lastFollowedWall = location;
        }
    }

    private boolean isPassable(Location location) {
        if (uc.isOutOfMap(location) || uc.senseUnitAtLocation(location) != null) {
            return false;
        }

        MapObject mapObject = uc.senseObjectAtLocation(location, true);
        if (mapObject == MapObject.WATER || (mapObject == MapObject.BALL && me != UnitType.CATCHER)) {
            return false;
        }

        int round = uc.getRound();
        if (opponentUnitsRound != round) {
            opponentUnits = uc.senseUnits(me.getStat(UnitStat.VISION_RANGE), opponentTeam);
            opponentUnitsRound = round;
        }

        for (UnitInfo unit : opponentUnits) {
            if (unit.getType() == UnitType.BATTER && unit.getLocation().distanceSquared(location) <= 8) {
                return false;
            }
        }

        return true;
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
            uc.drawLineDebug(uc.getLocation(), uc.getLocation().add(direction), 0, 255, 0);
            uc.move(direction);
            return true;
        }

        return false;
    }
}
