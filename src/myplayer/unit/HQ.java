package myplayer.unit;

import aic2023.user.Direction;
import aic2023.user.GameConstants;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer.symmetry.Symmetry;
import myplayer.util.BatScore;
import myplayer.util.ExploredObject;

import java.util.Arrays;
import java.util.Comparator;

public class HQ extends Unit {
    private UnitType[] defaultRecruitOrder = {
        UnitType.BATTER,
        UnitType.PITCHER
    };

    private UnitType[] dangerRecruitOrder = {
        UnitType.BATTER,
        UnitType.BATTER,
        UnitType.BATTER,
        UnitType.BATTER,
        UnitType.PITCHER
    };

    private int defaultRecruitIndex = 0;
    private int dangerRecruitIndex = 0;

    private Direction[] recruitDirections = null;

    public HQ(UnitController uc) {
        super(uc, UnitType.HQ);
    }

    @Override
    public void run() {
        super.run();

        if (recruitDirections == null) {
            int[] directionScores = new int[Direction.values().length];

            for (Direction direction : adjacentDirections) {
                for (int i = 1; i <= 8; i++) {
                    Location location = myHQ.add(direction.dx * i, direction.dy * i);
                    if (!uc.canSenseLocation(location)) {
                        break;
                    }

                    MapObject mapObject = uc.senseObjectAtLocation(location, false);
                    if (mapObject == MapObject.WATER) {
                        break;
                    }

                    UnitInfo unit = uc.senseUnitAtLocation(location);
                    if (unit != null && unit.getType() == UnitType.HQ) {
                        break;
                    }

                    directionScores[direction.ordinal()] = i;
                }
            }

            recruitDirections = adjacentDirections.clone();
            Arrays.sort(recruitDirections, Comparator.comparingInt(direction -> -directionScores[direction.ordinal()]));
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
                if (tryRecruit(dangerRecruitOrder[dangerRecruitIndex])) {
                    didSomething = true;
                    dangerRecruitIndex = (dangerRecruitIndex + 1) % dangerRecruitOrder.length;
                }
            } else {
                if (tryRecruit(defaultRecruitOrder[defaultRecruitIndex])) {
                    didSomething = true;
                    defaultRecruitIndex = (defaultRecruitIndex + 1) % defaultRecruitOrder.length;
                    dangerRecruitIndex = 0;
                }
            }

            if (tryConstructBallForBatter()) {
                didSomething = true;
            }

            if (tryConstructBallsForPitchers()) {
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

            for (Direction batDirection : recruitDirections) {
                Location batLocation = batterLocation.add(batDirection);
                if (!uc.canSenseLocation(batLocation)) {
                    continue;
                }

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
            if (uc.canRecruitUnit(UnitType.BATTER, direction)) {
                uc.recruitUnit(UnitType.BATTER, direction);
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
            if (uc.canRecruitUnit(type, direction)) {
                uc.recruitUnit(type, direction);
                return true;
            }
        }

        return false;
    }

    private boolean tryConstructBallForBatter() {
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

        for (Direction ballDirection : recruitDirections) {
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

    private boolean tryConstructBallsForPitchers() {
        int ballsLeft = (int) (uc.getReputation() / GameConstants.BALL_COST);
        if (ballsLeft == 0) {
            return false;
        }

        UnitInfo[] myUnits = uc.senseUnits(8, myTeam);
        boolean didSomething = false;

        outer:
        for (UnitInfo unit : myUnits) {
            if (unit.getType() != UnitType.PITCHER || unit.isCarryingBall()) {
                continue;
            }

            Location unitLocation = unit.getLocation();

            for (Direction direction : recruitDirections) {
                Location adjacentLocation = unitLocation.add(direction);

                MapObject adjacentObject = uc.senseObjectAtLocation(adjacentLocation, true);
                if (adjacentObject == MapObject.BALL) {
                    continue outer;
                }
            }

            for (Direction direction : recruitDirections) {
                Location adjacentLocation = unitLocation.add(direction);
                if (myHQ.distanceSquared(adjacentLocation) > 2) {
                    continue;
                }

                Direction constructDirection = myHQ.directionTo(adjacentLocation);
                if (uc.canConstructBall(constructDirection)) {
                    uc.constructBall(constructDirection);

                    ballsLeft--;
                    didSomething = true;

                    if (ballsLeft == 0) {
                        return didSomething;
                    }

                    continue outer;
                }
            }
        }

        return didSomething;
    }
}
