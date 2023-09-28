package myplayer_v19.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer_v19.util.ExploredObject;

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

                if (moveDirection != Direction.ZERO) {
                    uc.move(moveDirection);
                }

                uc.bat(batDirection, batDistance);
                return moveDirection != Direction.ZERO;
            }
        }

        return false;
    }

    private boolean shouldBatFriendly(Location batLocation, Direction batDirection, int batDistance, UnitInfo batUnit) {
        for (int i = 1; i <= batDistance; i++) {
            Location hitLocation = batLocation.add(batDirection.dx * i, batDirection.dy * i);
            if (!uc.canSenseLocation(hitLocation)) {
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

        if (batUnit.getType() != UnitType.BATTER) {
            return false;
        }

        if (sharedArray.getSpawnRound(batUnit.getID()) > spawnRound) {
            return false;
        }

        if (batUnit.getCurrentMovementCooldown() >= 1 && batUnit.getCurrentActionCooldown() >= 1) {
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

        for (ExploredObject object : sharedArray.getExploredStadiums()) {
            if (object.occupation != sharedArray.OCCUPATION_OPPONENT) {
                continue;
            }

            int distance = myLocation.distanceSquared(object.location);
            if (distance < minDistance) {
                bestLocation = object.location;
                minDistance = distance;
            }
        }

        for (ExploredObject object : sharedArray.getExploredBases()) {
            if (object.occupation != sharedArray.OCCUPATION_OPPONENT) {
                continue;
            }

            int distance = myLocation.distanceSquared(object.location);
            if (distance < minDistance) {
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
