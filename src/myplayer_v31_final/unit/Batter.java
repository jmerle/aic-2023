package myplayer_v31_final.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer_v31_final.util.BatScore;
import myplayer_v31_final.util.ExploredObject;

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

        if (tryMoveToTarget()) {
            return;
        }

        explore();
    }

    private boolean tryBat() {
        if (!uc.canAct()) {
            return false;
        }

        Direction bestMoveDirection = null;
        Direction bestBatDirection = null;
        int bestBatDistance = -1;
        double maxScore = Double.MIN_VALUE;

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

                BatScore score = batScorer.getBatScore(batLocation, batDirection);
                if (score == null) {
                    continue;
                }

                if (score.score > maxScore) {
                    bestMoveDirection = moveDirection;
                    bestBatDirection = batDirection;
                    bestBatDistance = score.distance;
                    maxScore = score.score;
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

    private boolean tryMoveToTarget() {
        Location bestLocation = null;
        int minDistance = Integer.MAX_VALUE;

        Location myLocation = uc.getLocation();
        int currentRound = uc.getRound();

        for (ExploredObject object : sharedArray.getExploredObjects()) {
            if (object.occupation != sharedArray.OCCUPATION_OPPONENT && currentRound - object.lastUpdate < 100) {
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
