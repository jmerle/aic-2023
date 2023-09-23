package myplayer_v06.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer_v06.symmetry.HorizontalSymmetry;
import myplayer_v06.symmetry.RotationalSymmetry;
import myplayer_v06.symmetry.Symmetry;
import myplayer_v06.symmetry.VerticalSymmetry;
import myplayer_v06.util.ExploredTiles;
import myplayer_v06.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class MoveableUnit extends Unit {
    private Location currentTarget;
    private boolean isWallFollowing;
    private int distanceBeforeWallFollowing;
    private boolean wallOnRight;
    private Location lastFollowedWall;

    private Location explorationTarget;

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
        } else if (sharedArray.getOpponentHQ() == null && findOpponentHQ()) {
            return;
        }

        int minX = sharedArray.getMinX();
        int maxX = sharedArray.getMaxX();
        int minY = sharedArray.getMinY();
        int maxY = sharedArray.getMaxY();

        ExploredTiles exploredTiles = sharedArray.getExploredTiles();

        if (explorationTarget == null
            || exploredTiles.isExplored(explorationTarget)
            || uc.canSenseLocation(explorationTarget)) {
            int attempts = 10;

            for (int i = 0; i < attempts; i++) {
                int x = RandomUtils.nextInt(minX, maxX + 1);
                int y = RandomUtils.nextInt(minY, maxY + 1);
                Location location = new Location(x, y);

                if (i != attempts - 1 && exploredTiles.isExplored(location)) {
                    continue;
                }

                explorationTarget = new Location(x, y);
            }
        }

        tryMoveTo(explorationTarget);
    }

    private void findBoundaries() {
        boolean hasMinX = sharedArray.hasMinX();
        boolean hasMaxX = sharedArray.hasMaxX();
        boolean hasMinY = sharedArray.hasMinY();
        boolean hasMaxY = sharedArray.hasMaxY();

        Direction direction = null;
        if (!hasMinX) {
            direction = Direction.WEST;
        } else if (!hasMaxX) {
            direction = Direction.EAST;
        } else if (!hasMinY) {
            direction = Direction.SOUTH;
        } else if (!hasMaxY) {
            direction = Direction.NORTH;
        }

        if (uc.getInfo().getID() % 2 == 0) {
            if (!hasMinX && !hasMinY) {
                direction = Direction.SOUTHWEST;
            } else if (!hasMinX && !hasMaxY) {
                direction = Direction.NORTHWEST;
            } else if (!hasMaxX && !hasMaxY) {
                direction = Direction.NORTHEAST;
            } else if (!hasMaxX && !hasMinY) {
                direction = Direction.SOUTHEAST;
            }
        }

        tryMoveTo(uc.getLocation().add(direction.dx * 100, direction.dy * 100));
    }

    private boolean findOpponentHQ() {
        ExploredTiles exploredTiles = sharedArray.getExploredTiles();

        List<Location> options = new ArrayList<>();

        for (Symmetry symmetry : new Symmetry[]{
            new RotationalSymmetry(sharedArray),
            new HorizontalSymmetry(sharedArray),
            new VerticalSymmetry(sharedArray)
        }) {
            Location option = symmetry.reflect(myHQ);
            if (!exploredTiles.isExplored(option)) {
                options.add(option);
            }
        }

        Location firstOption = options.get(0);

        if (options.size() == 1) {
            sharedArray.setOpponentHQ(firstOption);
            return false;
        }

        tryMoveTo(firstOption);
        return true;
    }

    protected boolean tryMoveTo(Location target) {
        if (!uc.canMove()) {
            return false;
        }

        Location myLocation = uc.getLocation();
        if (myLocation.isEqual(target)) {
            return false;
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
                return tryMove(forward);
            } else {
                isWallFollowing = true;
                distanceBeforeWallFollowing = currentDistance;
                setInitialWallFollowingDirection();
            }
        }

        return followWall(true);
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

    private boolean followWall(boolean canRotate) {
        Location myLocation = uc.getLocation();

        Direction direction = myLocation.directionTo(lastFollowedWall);

        for (int i = 0; i < 8; i++) {
            direction = wallOnRight ? direction.rotateLeft() : direction.rotateRight();
            Location location = myLocation.add(direction);

            if (canRotate && uc.isOutOfMap(location)) {
                wallOnRight = !wallOnRight;
                return followWall(false);
            }

            if (isPassable(location) && tryMove(direction)) {
                return true;
            }

            lastFollowedWall = location;
        }

        return false;
    }

    private boolean isPassable(Location location) {
        if (uc.isOutOfMap(location) || uc.senseUnitAtLocation(location) != null) {
            return false;
        }

        MapObject mapObject = uc.senseObjectAtLocation(location, true);
        if (mapObject == MapObject.BALL && me == UnitType.CATCHER) {
            return true;
        }

        return mapObject != MapObject.WATER && mapObject != MapObject.BALL;
    }

    protected boolean tryMoveRandom() {
        if (!uc.canMove()) {
            return false;
        }

        for (Direction direction : RandomUtils.shuffle(adjacentDirections.clone())) {
            if (tryMove(direction)) {
                return true;
            }
        }

        return false;
    }

    protected boolean tryMove(Direction direction) {
        if (uc.canMove(direction)) {
            uc.move(direction);
            return true;
        }

        return false;
    }
}
