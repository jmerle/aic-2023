package myplayer_v20.unit;

import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitType;
import myplayer_v20.util.ExploredObject;

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
            return;
        }

        Location target = getClosestUnoccupiedObject();
        if (target != null) {
            moveTo(target);
        } else {
            explore();
        }
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
