package myplayer_v02.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer_v02.util.ExploredTiles;
import myplayer_v02.util.RandomUtils;

public abstract class MoveableUnit extends Unit {
    protected Location myHQ;

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

        if (myHQ == null) {
            for (UnitInfo unit : uc.senseUnits(me.getStat(UnitStat.VISION_RANGE), myTeam)) {
                if (unit.getType() == UnitType.HQ) {
                    myHQ = unit.getLocation();
                    break;
                }
            }
        }
    }

    protected void explore() {
        boolean hasMinX = sharedArray.hasMinX();
        boolean hasMaxX = sharedArray.hasMaxX();
        boolean hasMinY = sharedArray.hasMinY();
        boolean hasMaxY = sharedArray.hasMaxY();

        if (!hasMinX || !hasMaxX || !hasMinY || !hasMaxY) {
            exploreBoundaries();
            return;
        }

        int minX = sharedArray.getMinX();
        int maxX = sharedArray.getMaxX();
        int minY = sharedArray.getMinY();
        int maxY = sharedArray.getMaxY();

        ExploredTiles exploredTiles = sharedArray.getExploredTiles();

        if (explorationTarget == null
            || exploredTiles.isExplored(explorationTarget.x, explorationTarget.y)
            || uc.canSenseLocation(explorationTarget)) {
            int attempts = 10;

            for (int i = 0; i < attempts; i++) {
                int x = RandomUtils.nextInt(minX, maxX + 1);
                int y = RandomUtils.nextInt(minY, maxY + 1);

                if (i != attempts - 1 && exploredTiles.isExplored(x, y)) {
                    continue;
                }

                explorationTarget = new Location(x, y);
            }
        }

        tryMoveTo(explorationTarget);
    }

    private void exploreBoundaries() {
        boolean hasMinX = sharedArray.hasMinX();
        boolean hasMaxX = sharedArray.hasMaxX();
        boolean hasMinY = sharedArray.hasMinY();
        boolean hasMaxY = sharedArray.hasMaxY();

        Direction exploreDirection = null;
        if (!hasMinX) {
            exploreDirection = Direction.WEST;
        } else if (!hasMaxX) {
            exploreDirection = Direction.EAST;
        } else if (!hasMinY) {
            exploreDirection = Direction.SOUTH;
        } else if (!hasMaxY) {
            exploreDirection = Direction.NORTH;
        }

        if (uc.getInfo().getID() % 2 == 0) {
            if (!hasMinX && !hasMinY) {
                exploreDirection = Direction.SOUTHWEST;
            } else if (!hasMinX && !hasMaxY) {
                exploreDirection = Direction.NORTHWEST;
            } else if (!hasMaxX && !hasMaxY) {
                exploreDirection = Direction.NORTHEAST;
            } else if (!hasMaxX && !hasMinY) {
                exploreDirection = Direction.SOUTHEAST;
            }
        }

        tryMoveTo(uc.getLocation().add(exploreDirection.dx * 100, exploreDirection.dy * 100));
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
