package myplayer_v22.unit;

import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;

public class Catcher extends MoveableUnit {
    public Catcher(UnitController uc) {
        super(uc, UnitType.CATCHER);
    }

    @Override
    public void run() {
        super.run();

        Location closestBall = getClosestBall();
        if (closestBall != null) {
            moveTo(closestBall);
        } else {
            explore();
        }
    }

    private Location getClosestBall() {
        Location closestBall = null;
        int minDistance = Integer.MAX_VALUE;

        Location myLocation = uc.getLocation();

        for (Location location : uc.senseObjects(MapObject.BALL, me.getStat(UnitStat.VISION_RANGE))) {
            int distance = myLocation.distanceSquared(location);
            if (distance < minDistance) {
                closestBall = location;
                minDistance = distance;
            }
        }

        return closestBall;
    }
}
