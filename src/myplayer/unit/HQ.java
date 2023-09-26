package myplayer.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer.symmetry.Symmetry;
import myplayer.util.ExploredObject;

import java.util.Arrays;
import java.util.Comparator;

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

            Arrays.sort(adjacentDirections, Comparator.comparingInt(direction -> myHQ.add(direction).distanceSquared(center)));
            sortedRecruitDirections = true;
        }

        if (hasSymmetry()) {
            Symmetry symmetry = getSymmetry();

            for (ExploredObject object : sharedArray.getExploredBases()) {
                Location reflected = symmetry.reflect(object.location);
                if (!exploredTiles.isExplored(reflected)) {
                    sharedArray.setExploredBase(reflected, sharedArray.OCCUPATION_EMPTY);
                }
            }

            for (ExploredObject object : sharedArray.getExploredStadiums()) {
                Location reflected = symmetry.reflect(object.location);
                if (!exploredTiles.isExplored(reflected)) {
                    sharedArray.setExploredStadium(reflected, sharedArray.OCCUPATION_EMPTY);
                }
            }
        }

        boolean danger = false;
        for (UnitInfo unit : uc.senseUnits(me.getStat(UnitStat.VISION_RANGE), opponentTeam)) {
            if (unit.getType() == UnitType.BATTER) {
                danger = true;
                break;
            }
        }

        boolean didSomething = true;
        while (didSomething) {
            didSomething = false;

            if (danger) {
                didSomething = tryRecruit(UnitType.BATTER);
                continue;
            }

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

        if (type == UnitType.BATTER) {
            return tryRecruitOffensive(type);
        } else {
            return tryRecruitDefensive(type);
        }
    }

    private boolean tryRecruitOffensive(UnitType type) {
        UnitInfo[] opponentUnits = uc.senseUnits(18, opponentTeam);

        for (Direction direction : recruitDirections) {
            if (!uc.canRecruitUnit(type, direction)) {
                continue;
            }

            Location recruitLocation = myHQ.add(direction);

            for (UnitInfo unit : opponentUnits) {
                if (unit.getType() == type && unit.getLocation().distanceSquared(recruitLocation) <= 2) {
                    uc.recruitUnit(type, direction);
                    return true;
                }
            }
        }

        for (Direction direction : recruitDirections) {
            if (!uc.canRecruitUnit(type, direction)) {
                continue;
            }

            Location recruitLocation = myHQ.add(direction);

            for (UnitInfo unit : opponentUnits) {
                if (unit.getType() == type && unit.getLocation().distanceSquared(recruitLocation) <= 8) {
                    uc.recruitUnit(type, direction);
                    return true;
                }
            }
        }

        for (Direction direction : recruitDirections) {
            if (tryRecruit(type, direction)) {
                return true;
            }
        }

        return false;
    }

    private boolean tryRecruitDefensive(UnitType type) {
        UnitInfo[] opponentUnits = uc.senseUnits(18, opponentTeam);

        outer:
        for (Direction direction : recruitDirections) {
            if (!uc.canRecruitUnit(type, direction)) {
                continue;
            }

            Location recruitLocation = myHQ.add(direction);

            for (UnitInfo unit : opponentUnits) {
                if (unit.getType() == UnitType.BATTER && unit.getLocation().distanceSquared(recruitLocation) <= 8) {
                    continue outer;
                }
            }

            uc.recruitUnit(type, direction);
            return true;
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
}
