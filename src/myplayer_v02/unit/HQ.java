package myplayer_v02.unit;

import aic2023.user.Direction;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;

public class HQ extends Unit {
    private int requiredCatchers = 0;

    private boolean preferBatter = true;
    private int preferCooldown = 10;

    public HQ(UnitController uc) {
        super(uc, UnitType.HQ);
    }

    @Override
    public void run() {
        super.run();

        boolean didSomething = true;
        while (didSomething) {
            didSomething = false;

            if (uc.getRound() < 100 && tryRecruit(UnitType.PITCHER)) {
                didSomething = true;
                return;
            }

            if (requiredCatchers == 0 && isInDanger()) {
                requiredCatchers = uc.senseObjects(MapObject.GRASS, me.getStat(UnitStat.VISION_RANGE)).length / 4;
            }

            if (getCurrentCatchers() < requiredCatchers && tryRecruit(UnitType.CATCHER)) {
                didSomething = true;
                return;
            }

            if (preferCooldown == 0) {
                preferBatter = !preferBatter;
                preferCooldown = 10;
            }

            UnitType type = preferBatter ? UnitType.BATTER : UnitType.PITCHER;
            if (tryRecruit(type)) {
                didSomething = true;
                preferBatter = !preferBatter;
                preferCooldown = 10;
            }
        }
    }

    private boolean isInDanger() {
        if (uc.senseObjects(MapObject.BALL, me.getStat(UnitStat.VISION_RANGE)).length > 0) {
            return true;
        }

        for (UnitInfo unit : uc.senseUnits(me.getStat(UnitStat.VISION_RANGE), opponentTeam)) {
            if (unit.getType() == UnitType.BATTER) {
                return true;
            }
        }

        return false;
    }

    private int getCurrentCatchers() {
        int total = 0;

        for (UnitInfo unit : uc.senseUnits(me.getStat(UnitStat.VISION_RANGE), myTeam)) {
            if (unit.getType() == UnitType.CATCHER) {
                total++;
            }
        }

        return total;
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
}
