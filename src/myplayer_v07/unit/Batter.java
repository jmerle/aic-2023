package myplayer_v07.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer_v07.util.ExploredObject;

public class Batter extends MoveableUnit {
    public Batter(UnitController uc) {
        super(uc, UnitType.BATTER);
    }

    @Override
    public void run() {
        super.run();

        if (uc.canMove()) {
            Location moveTarget = getMoveTarget();
            if (moveTarget == null) {
                moveTarget = sharedArray.getOpponentHQ();
            }

            if (moveTarget != null) {
                tryMoveTo(moveTarget);
            } else {
                explore();
            }
        }

        if (uc.canAct()) {
            Location myLocation = uc.getLocation();

            for (Direction direction : adjacentDirections) {
                boolean batted = false;

                for (int i = 1; i <= 3; i++) {
                    Location location = myLocation.add(direction.dx * i, direction.dy * i);
                    if (!uc.canSenseLocation(location)) {
                        break;
                    }

                    UnitInfo unit = uc.senseUnitAtLocation(location);
                    if (unit == null) {
                        continue;
                    }

                    if (unit.getTeam() == opponentTeam && unit.getType() != UnitType.HQ) {
                        batted = tryBat(direction, 3);
                    }

                    break;
                }

                if (batted) {
                    break;
                }
            }
        }
    }

    private Location getMoveTarget() {
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
            return bestLocation;
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

        return bestLocation;
    }

    private boolean tryBat(Direction direction, int distance) {
        if (uc.canBat(direction, distance)) {
            uc.bat(direction, distance);
            return true;
        }

        return false;
    }
}
