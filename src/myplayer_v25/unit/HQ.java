package myplayer_v25.unit;

import aic2023.user.Direction;
import aic2023.user.GameConstants;
import aic2023.user.Location;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer_v25.symmetry.Symmetry;
import myplayer_v25.util.BatScore;
import myplayer_v25.util.BatScorer;
import myplayer_v25.util.ExploredObject;

import java.util.Arrays;
import java.util.Comparator;

public class HQ extends Unit {
    private boolean recruitBatter = true;

    private Direction[] recruitDirections = adjacentDirections.clone();
    private boolean sortedRecruitDirections = false;

    private BatScorer batScorer;

    public HQ(UnitController uc) {
        super(uc, UnitType.HQ);

        batScorer = new BatScorer(uc, sharedArray);
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

            for (ExploredObject object : sharedArray.getExploredObjects()) {
                Location reflected = symmetry.reflect(object.location);
                if (!exploredTiles.isExplored(reflected)) {
                    sharedArray.setExploredObject(reflected, object.type, sharedArray.OCCUPATION_EMPTY);
                }
            }
        }

        sharedArray.updateExpiredExploredObjectOccupation();

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
            } else {
                UnitType type = recruitBatter ? UnitType.BATTER : UnitType.PITCHER;
                if (tryRecruit(type)) {
                    didSomething = true;
                    recruitBatter = !recruitBatter;
                }
            }

            if (tryConstructBall()) {
                didSomething = true;
            }
        }
    }

    private boolean tryRecruit(UnitType type) {
        if (uc.getReputation() < type.getStat(UnitStat.REP_COST)) {
            return false;
        }

        if (type == UnitType.BATTER) {
            return tryRecruitBatter();
        } else {
            return tryRecruitDefensive(type);
        }
    }

    private boolean tryRecruitBatter() {
        Direction bestDirection = null;
        int maxScore = Integer.MIN_VALUE;

        for (Direction batterDirection : recruitDirections) {
            if (!uc.canRecruitUnit(UnitType.BATTER, batterDirection)) {
                continue;
            }

            Location batterLocation = myHQ.add(batterDirection);

            for (Direction batDirection : adjacentDirections) {
                Location batLocation = batterLocation.add(batDirection);

                BatScore score = batScorer.getBatScore(batLocation, batDirection);
                if (score != null && score.score > maxScore) {
                    bestDirection = batterDirection;
                    maxScore = score.score;
                }
            }
        }

        if (bestDirection != null) {
            uc.recruitUnit(UnitType.BATTER, bestDirection);
            return true;
        }

        for (Direction direction : recruitDirections) {
            if (tryRecruit(UnitType.BATTER, direction)) {
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

    private boolean tryConstructBall() {
        if (uc.getReputation() < GameConstants.BALL_COST) {
            return false;
        }

        if (uc.senseUnits(me.getStat(UnitStat.VISION_RANGE), opponentTeam).length == 0) {
            return false;
        }

        UnitInfo[] myUnits = uc.senseUnits(8, myTeam);
        if (myUnits.length == 0) {
            return false;
        }

        Direction bestDirection = null;
        int maxScore = Integer.MIN_VALUE;

        for (Direction ballDirection : adjacentDirections) {
            if (!uc.canConstructBall(ballDirection)) {
                continue;
            }

            Location ballLocation = myHQ.add(ballDirection);

            for (UnitInfo unit : myUnits) {
                if (unit.getType() != UnitType.BATTER || unit.getLocation().distanceSquared(ballLocation) > 2) {
                    continue;
                }

                Direction batDirection = unit.getLocation().directionTo(ballLocation);

                BatScore score = batScorer.getBatScoreBall(ballLocation, batDirection);
                if (score != null && score.score > maxScore) {
                    bestDirection = ballDirection;
                    maxScore = score.score;
                }
            }
        }

        if (bestDirection == null) {
            return false;
        }

        uc.constructBall(bestDirection);
        return true;
    }

    private boolean tryRecruit(UnitType type, Direction direction) {
        if (uc.canRecruitUnit(type, direction)) {
            uc.recruitUnit(type, direction);
            return true;
        }

        return false;
    }
}
