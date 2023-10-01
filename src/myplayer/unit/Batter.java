package myplayer.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer.util.ExploredObject;

public class Batter extends MoveableUnit {
    public Batter(UnitController uc) {
        super(uc, UnitType.BATTER);
    }

    @Override
    public void run() {
        super.run();

        if (tryBat()) {
            return;
        }

        Location opponentHQ = sharedArray.getOpponentHQ();
        if (opponentHQ != null && uc.getLocation().distanceSquared(opponentHQ) <= 2) {
            return;
        }

        if (!tryMoveToTarget()) {
            explore();
        }
    }

    private boolean tryBat() {
        if (!uc.canAct()) {
            return false;
        }

        Direction bestMoveDirection = null;
        Direction bestBatDirection = null;
        int bestBatDistance = -1;
        int maxScore = Integer.MIN_VALUE;

        Location myLocation = uc.getLocation();

        for (Direction moveDirection : Direction.values()) {
            if (moveDirection != Direction.ZERO && !uc.canMove(moveDirection)) {
                continue;
            }

            Location moveLocation = myLocation.add(moveDirection);

            for (Direction batDirection : adjacentDirections) {
                Location batLocation = moveLocation.add(batDirection);
                if (batLocation.isEqual(myLocation) || !uc.canSenseLocation(batLocation)) {
                    continue;
                }

                UnitInfo batUnit = uc.senseUnitAtLocation(batLocation);
                if (batUnit == null || batUnit.getType() == UnitType.HQ) {
                    continue;
                }

                int batDistance = 3;
                if (batUnit.getTeam() == myTeam) {
                    for (int i = 3; i >= 1; i--) {
                        Location finalLocation = batLocation.add(batDirection.dx * i, batDirection.dy * i);
                        if (myLocation.distanceSquared(finalLocation) <= me.getStat(UnitStat.VISION_RANGE)) {
                            batDistance = i;
                            break;
                        }
                    }

                    if (!shouldBatFriendly(batLocation, batDirection, batDistance, batUnit)) {
                        continue;
                    }
                }

                int score = getBatScore(batLocation, batDirection, batDistance, batUnit);
                if (score > maxScore) {
                    bestMoveDirection = moveDirection;
                    bestBatDirection = batDirection;
                    bestBatDistance = batDistance;
                    maxScore = score;
                }
            }
        }

        if (bestMoveDirection == null && bestBatDirection == null) {
            return false;
        }

        if (bestMoveDirection != Direction.ZERO) {
            uc.move(bestMoveDirection);
        }

        uc.bat(bestBatDirection, bestBatDistance);
        return bestMoveDirection != Direction.ZERO;
    }

    private int getBatScore(Location batLocation, Direction batDirection, int batDistance, UnitInfo batUnit) {
        int killedFriendlies = 0;
        int killedOpponents = 0;

        for (int i = 1; i <= batDistance; i++) {
            Location hitLocation = batLocation.add(batDirection.dx * i, batDirection.dy * i);

            if (uc.getLocation().distanceSquared(hitLocation) > me.getStat(UnitStat.VISION_RANGE)) {
                break;
            }

            if (uc.isOutOfMap(hitLocation)) {
                if (batUnit.getTeam() == myTeam) {
                    killedFriendlies++;
                } else {
                    killedOpponents++;
                }

                break;
            }

            MapObject hitObject = uc.senseObjectAtLocation(hitLocation, true);
            if (hitObject == MapObject.WATER || hitObject == MapObject.BALL) {
                if (batUnit.getTeam() == myTeam) {
                    killedFriendlies++;
                } else {
                    killedOpponents++;
                }

                break;
            }

            UnitInfo hitUnit = uc.senseUnitAtLocation(hitLocation);
            if (hitUnit != null) {
                if (batUnit.getTeam() == myTeam) {
                    killedFriendlies++;
                } else {
                    killedOpponents++;
                }

                if (hitUnit.getType() != UnitType.HQ) {
                    if (hitUnit.getTeam() == myTeam) {
                        killedFriendlies++;
                    } else {
                        killedOpponents++;
                    }
                }

                break;
            }
        }

        return killedOpponents - killedFriendlies;
    }

    private boolean shouldBatFriendly(Location batLocation, Direction batDirection, int batDistance, UnitInfo batUnit) {
        for (int i = 1; i <= batDistance; i++) {
            Location hitLocation = batLocation.add(batDirection.dx * i, batDirection.dy * i);
            if (uc.isOutOfMap(hitLocation)) {
                return false;
            }

            MapObject hitObject = uc.senseObjectAtLocation(hitLocation, true);
            if (hitObject == MapObject.WATER || hitObject == MapObject.BALL) {
                return false;
            }

            UnitInfo hitUnit = uc.senseUnitAtLocation(hitLocation);
            if (hitUnit != null) {
                return hitUnit.getTeam() == opponentTeam && hitUnit.getType() != UnitType.HQ;
            }
        }

        if (batUnit.getType() != UnitType.BATTER
            || sharedArray.getLastRound(batUnit.getID()) == uc.getRound()
            || (batUnit.getCurrentMovementCooldown() >= 1 && batUnit.getCurrentActionCooldown() >= 1)) {
            return false;
        }

        Location finalLocation = batLocation.add(batDirection.dx * batDistance, batDirection.dy * batDistance);

        Location moveTarget = sharedArray.getMoveTarget(batUnit.getID());
        return moveTarget != null && finalLocation.distanceSquared(moveTarget) < batLocation.distanceSquared(moveTarget);
    }

    private boolean tryMoveToTarget() {
        Location bestLocation = null;
        int minDistance = Integer.MAX_VALUE;

        Location myLocation = uc.getLocation();

        for (ExploredObject object : sharedArray.getExploredObjects()) {
            if (object.occupation != sharedArray.OCCUPATION_OPPONENT) {
                continue;
            }

            int distance = myLocation.distanceSquared(object.location);
            if (distance < minDistance || (distance == minDistance && object.type == MapObject.STADIUM)) {
                bestLocation = object.location;
                minDistance = distance;
            }
        }

        if (bestLocation != null) {
            moveTo(bestLocation);
            return true;
        }

        for (UnitInfo unit : uc.senseUnits(me.getStat(UnitStat.VISION_RANGE), opponentTeam)) {
            if (unit.getType() == UnitType.HQ) {
                continue;
            }

            int distance = myLocation.distanceSquared(unit.getLocation());
            if (distance < minDistance) {
                bestLocation = unit.getLocation();
                minDistance = distance;
            }
        }

        if (bestLocation == null) {
            bestLocation = sharedArray.getOpponentHQ();
        }

        if (bestLocation != null) {
            moveTo(bestLocation);
            return true;
        }

        return false;
    }
}
