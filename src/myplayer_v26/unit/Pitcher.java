package myplayer_v26.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitType;
import myplayer_v26.util.BatScore;
import myplayer_v26.util.BatScorer;
import myplayer_v26.util.ExploredObject;

public class Pitcher extends MoveableUnit {
    private BatScorer batScorer;

    public Pitcher(UnitController uc) {
        super(uc, UnitType.PITCHER);

        batScorer = new BatScorer(uc, sharedArray);
    }

    @Override
    public void run() {
        super.run();

        if (uc.canAct()) {
            if (uc.getInfo().isCarryingBall()) {
                placeBall();
            } else {
                grabBall();
            }
        }

        if (!uc.canMove()) {
            return;
        }

        MapObject currentObject = uc.senseObjectAtLocation(uc.getLocation(), true);
        if (currentObject == MapObject.BASE || currentObject == MapObject.STADIUM) {
            if (uc.getLocation().distanceSquared(myHQ) <= 2 && isHQBlocked()) {
                moveTo(myHQ);
            }

            return;
        }

        Location target = getClosestUnoccupiedObject();
        if (target != null) {
            moveTo(target);
        } else {
            explore();
        }
    }

    private boolean isHQBlocked() {
        for (Direction direction : adjacentDirections) {
            Location location = myHQ.add(direction);
            if (!uc.canSenseLocation(location) || uc.senseUnitAtLocation(location) != null) {
                continue;
            }

            MapObject mapObject = uc.senseObjectAtLocation(location, true);
            if (mapObject != MapObject.WATER && mapObject != MapObject.BALL) {
                return false;
            }
        }

        return true;
    }

    private Location getClosestUnoccupiedObject() {
        Location bestLocation = null;
        int minDistance = Integer.MAX_VALUE;

        Location myLocation = uc.getLocation();

        for (ExploredObject object : sharedArray.getExploredObjects()) {
            if (object.occupation != sharedArray.OCCUPATION_EMPTY) {
                continue;
            }

            int distance = myLocation.distanceSquared(object.location);
            if (distance < minDistance || (distance == minDistance && object.type == MapObject.STADIUM)) {
                bestLocation = object.location;
                minDistance = distance;
            }
        }

        return bestLocation;
    }

    private void grabBall() {
        Location myLocation = uc.getLocation();

        for (Direction ballDirection : adjacentDirections) {
            if (uc.canMoveBall(ballDirection) && !isGoodBallLocation(myLocation.add(ballDirection))) {
                uc.moveBall(ballDirection);
                return;
            }
        }
    }

    private void placeBall() {
        Direction bestBallDirection = null;
        int maxScore = 0;

        Location myLocation = uc.getLocation();

        for (UnitInfo unit : uc.senseUnits(18, myTeam)) {
            if (unit.getType() != UnitType.BATTER
                || sharedArray.hasActed(unit.getID())
                || unit.getCurrentActionCooldown() >= 1) {
                continue;
            }

            Location unitLocation = unit.getLocation();

            if (unitLocation.distanceSquared(myLocation) <= 8) {
                for (Direction batDirection : adjacentDirections) {
                    Location ballLocation = unitLocation.add(batDirection);
                    if (ballLocation.distanceSquared(myLocation) > 2) {
                        continue;
                    }

                    Direction ballDirection = myLocation.directionTo(ballLocation);
                    if (!uc.canMoveBall(ballDirection)) {
                        continue;
                    }

                    BatScore score = batScorer.getBatScoreBall(ballLocation, batDirection);
                    if (score != null && score.score > maxScore) {
                        bestBallDirection = ballDirection;
                        maxScore = score.score;
                    }
                }
            } else {
                if (unit.getCurrentMovementCooldown() >= 1) {
                    continue;
                }

                for (Direction moveDirection : adjacentDirections) {
                    Location moveLocation = unitLocation.add(moveDirection);
                    if (moveLocation.distanceSquared(myLocation) > 8 || !uc.canSenseLocation(moveLocation)) {
                        continue;
                    }

                    MapObject moveObject = uc.senseObjectAtLocation(moveLocation, true);
                    if (moveObject == MapObject.WATER || moveObject == MapObject.BALL) {
                        continue;
                    }

                    for (Direction batDirection : adjacentDirections) {
                        Location ballLocation = moveLocation.add(batDirection);
                        if (ballLocation.distanceSquared(myLocation) > 2) {
                            continue;
                        }

                        Direction ballDirection = myLocation.directionTo(ballLocation);
                        if (!uc.canMoveBall(ballDirection)) {
                            continue;
                        }

                        BatScore score = batScorer.getBatScoreBall(ballLocation, batDirection);
                        if (score != null && score.score > maxScore) {
                            bestBallDirection = ballDirection;
                            maxScore = score.score;
                        }
                    }
                }
            }
        }

        if (bestBallDirection != null) {
            uc.moveBall(bestBallDirection);
        }
    }

    /*private void placeBall() {
        Location myLocation = uc.getLocation();

        for (Direction ballDirection : adjacentDirections) {
            if (uc.canMoveBall(ballDirection) && isGoodBallLocation(myLocation.add(ballDirection))) {
                uc.moveBall(ballDirection);
                return;
            }
        }
    }*/

    private boolean isGoodBallLocation(Location ballLocation) {
        for (Direction unitDirection : adjacentDirections) {
            Location unitLocation = ballLocation.add(unitDirection);
            if (!isAttackLocation(unitLocation)) {
                continue;
            }

            Direction batDirection = unitDirection.opposite();
            if (batScorer.getBatScoreBall(ballLocation, batDirection) != null) {
                return true;
            }
        }

        return false;
    }

    private boolean isAttackLocation(Location location) {
        if (!uc.canSenseLocation(location)) {
            return false;
        }

        UnitInfo unit = uc.senseUnitAtLocation(location);
        if (unit != null) {
            return unit.getTeam() == myTeam
                && unit.getType() == UnitType.BATTER
                && !sharedArray.hasActed(unit.getID())
                && unit.getCurrentActionCooldown() < 1;
        }

        MapObject mapObject = uc.senseObjectAtLocation(location, true);
        if (mapObject == MapObject.WATER || mapObject == MapObject.BALL) {
            return false;
        }

        for (Direction direction : adjacentDirections) {
            Location adjacentLocation = location.add(direction);
            if (!uc.canSenseLocation(adjacentLocation)) {
                continue;
            }

            UnitInfo adjacentUnit = uc.senseUnitAtLocation(location);
            if (adjacentUnit != null
                && adjacentUnit.getTeam() == myTeam
                && adjacentUnit.getType() == UnitType.BATTER
                && !sharedArray.hasActed(adjacentUnit.getID())
                && adjacentUnit.getCurrentActionCooldown() < 1
                && adjacentUnit.getCurrentMovementCooldown() < 1) {
                return true;
            }
        }

        return false;
    }
}
