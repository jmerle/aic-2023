package myplayer.unit;

import aic2023.user.Direction;
import aic2023.user.GameConstants;
import aic2023.user.Location;
import aic2023.user.UnitController;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;

public class HQ extends Unit {
    private boolean recruitBatter = true;

    private Direction[] recruitDirections = adjacentDirections.clone();
    private boolean sortedRecruitDirections = false;

    public HQ(UnitController uc) {
        super(uc, UnitType.HQ);
    }

    @Override
    public void run() {
        super.run();

        if (!sortedRecruitDirections && sharedArray.hasMapSize()) {
            int centerX = sharedArray.getMinX() + sharedArray.getMapWidth() / 2;
            int centerY = sharedArray.getMinY() + sharedArray.getMapHeight() / 2;
            Location center = new Location(centerX, centerY);

            boolean swapped = true;
            while (swapped) {
                swapped = false;

                for (int i = 1; i < adjacentDirections.length; i++) {
                    if (myHQ.add(adjacentDirections[i - 1]).distanceSquared(center) > myHQ.add(adjacentDirections[i]).distanceSquared(center)) {
                        Direction temp = adjacentDirections[i - 1];
                        adjacentDirections[i - 1] = adjacentDirections[i];
                        adjacentDirections[i] = temp;
                        swapped = true;
                    }
                }
            }

            sortedRecruitDirections = true;
        }

        boolean didSomething = true;
        while (didSomething) {
            didSomething = false;

            UnitType type = recruitBatter ? UnitType.BATTER : UnitType.PITCHER;
            if (tryRecruit(type)) {
                didSomething = true;
                recruitBatter = !recruitBatter;
            }
        }
    }

    private boolean tryRecruit(UnitType type) {
        if (uc.getReputation() < type.getStat(UnitStat.REP_COST)) {
            return false;
        }

        for (Direction direction : recruitDirections) {
            if (tryRecruit(type, direction)) {
                return true;
            }
        }

        return false;
    }

    private boolean tryRecruit(UnitType type, Direction direction) {
        if (uc.canRecruitUnit(type, direction)) {
            uc.recruitUnit(type, direction);
            return true;
        }

        return false;
    }

    private boolean tryConstructBall() {
        if (uc.getReputation() < GameConstants.BALL_COST) {
            return false;
        }

        for (Direction direction : recruitDirections) {
            if (tryConstructBall(direction)) {
                return true;
            }
        }

        return false;
    }

    private boolean tryConstructBall(Direction direction) {
        if (uc.canConstructBall(direction)) {
            uc.constructBall(direction);
            return true;
        }

        return false;
    }
}
