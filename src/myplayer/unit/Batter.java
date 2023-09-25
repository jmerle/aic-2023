package myplayer.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
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

        if (uc.canAct() && !tryBat()) {
            if (uc.canMove()) {
                moveAndBat();
            }
        }

        if (uc.canMove()) {
            moveToTarget();
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
        Location myLocation = uc.getLocation();

        for (Direction moveDirection : adjacentDirections) {
            if (!uc.canMove(moveDirection)) {
                continue;
            }

            Location moveLocation = myLocation.add(moveDirection);

            for (Direction batDirection : adjacentDirections) {
                Location batLocation = moveLocation.add(batDirection);
                if (!uc.canSenseLocation(batLocation)) {
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

        if (bestLocation != null && tryMoveTo(bestLocation)) {
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

    private boolean tryBat(Direction direction, int distance) {
        if (uc.canBat(direction, distance)) {
            uc.bat(direction, distance);
            return true;
        }

        return false;
    }
}
