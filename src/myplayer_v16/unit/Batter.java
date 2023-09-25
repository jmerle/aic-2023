package myplayer_v16.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer_v16.util.ExploredObject;

public class Batter extends MoveableUnit {
    public Batter(UnitController uc) {
        super(uc, UnitType.BATTER);
    }

    @Override
    public void run() {
        super.run();

        if (uc.canAct() && !tryBat()) {
            if (uc.canMove()) {
                moveAndBat();
            }
        }

        if (uc.canAct() && sharedArray.getOpponentHQ() != null) {
            batFriendly();
        }

        if (uc.canMove()) {
            moveToTarget();
        }

        if (uc.canMove()) {
            explore();
        }
    }

    private boolean tryBat() {
        Location myLocation = uc.getLocation();

        for (Direction direction : adjacentDirections) {
            Location target = myLocation.add(direction);
            if (uc.isOutOfMap(target)) {
                continue;
            }

            UnitInfo unit = uc.senseUnitAtLocation(target);
            if (unit == null || unit.getTeam() == myTeam || unit.getType() == UnitType.HQ) {
                continue;
            }

            if (tryBat(direction, 3)) {
                return true;
            }
        }

        return false;
    }

    private void moveAndBat() {
        boolean targetExists = false;
        for (UnitInfo unit : uc.senseUnits(8, opponentTeam)) {
            if (unit.getType() == UnitType.BATTER) {
                targetExists = true;
                break;
            }
        }

        if (!targetExists) {
            return;
        }

        Location myLocation = uc.getLocation();

        for (Direction moveDirection : adjacentDirections) {
            if (!uc.canMove(moveDirection)) {
                continue;
            }

            Location moveLocation = myLocation.add(moveDirection);

            for (Direction batDirection : adjacentDirections) {
                Location batLocation = moveLocation.add(batDirection);
                if (uc.isOutOfMap(batLocation)) {
                    continue;
                }

                UnitInfo unit = uc.senseUnitAtLocation(batLocation);
                if (unit != null && unit.getTeam() == opponentTeam && unit.getType() != UnitType.HQ) {
                    tryMove(moveDirection);
                    tryBat(batDirection, 3);
                    return;
                }
            }
        }
    }

    private void moveToTarget() {
        Location bestLocation = null;
        int minDistance = Integer.MAX_VALUE;

        Location myLocation = uc.getLocation();

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

        if (bestLocation != null) {
            tryMoveTo(bestLocation);
            return;
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
            tryMoveTo(bestLocation);
        }
    }

    private void batFriendly() {
        Location myLocation = uc.getLocation();
        Location opponentHQ = sharedArray.getOpponentHQ();

        outer:
        for (Direction batDirection : adjacentDirections) {
            int batDistance = batDirection.dx == 0 || batDirection.dy == 0 ? 3 : 2;

            Location batLocation = myLocation.add(batDirection);
            Location targetLocation = batLocation.add(batDirection.dx * batDistance, batDirection.dy * batDistance);
            if (uc.isOutOfMap(batLocation)
                || uc.isOutOfMap(targetLocation)
                || batLocation.distanceSquared(opponentHQ) < targetLocation.distanceSquared(opponentHQ)) {
                continue;
            }

            UnitInfo batUnit = uc.senseUnitAtLocation(batLocation);
            if (batUnit == null
                || batUnit.getTeam() != myTeam
                || batUnit.getType() != UnitType.BATTER
                || !uc.canSchedule(batUnit.getID())) {
                continue;
            }

            for (int i = 1; i <= batDistance; i++) {
                Location hitLocation = batLocation.add(batDirection.dx * i, batDirection.dy * i);

                MapObject hitObject = uc.senseObjectAtLocation(hitLocation, true);
                if (hitObject == MapObject.WATER || hitObject == MapObject.BALL) {
                    continue outer;
                }

                UnitInfo hitUnit = uc.senseUnitAtLocation(hitLocation);
                if (hitUnit != null && (hitUnit.getTeam() == myTeam || hitUnit.getType() == UnitType.HQ)) {
                    continue outer;
                }
            }

            if (tryBat(batDirection, batDistance)) {
                return;
            }
        }
    }

    private boolean tryBat(Direction direction, int distance) {
        if (uc.canBat(direction, distance)) {
            uc.bat(direction, distance);
            return true;
        }

        return false;
    }
}
