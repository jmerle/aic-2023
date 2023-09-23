package myplayer_v06.unit;

import aic2023.user.Direction;
import aic2023.user.GameConstants;
import aic2023.user.UnitController;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;

public class HQ extends Unit {
    private boolean recruitBatter = true;

    public HQ(UnitController uc) {
        super(uc, UnitType.HQ);
    }

    @Override
    public void run() {
        super.run();

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

        for (Direction direction : adjacentDirections) {
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

        for (Direction direction : adjacentDirections) {
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
