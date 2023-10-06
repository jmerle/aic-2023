package myplayer.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitType;
import myplayer.util.ExploredObject;

public class Pitcher extends MoveableUnit {
    public Pitcher(UnitController uc) {
        super(uc, UnitType.PITCHER);
    }

    @Override
    public void run() {
        super.run();

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
}
