package myplayer_v24.util;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.Team;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;

public class BatScorer {
    private UnitController uc;
    private SharedArray sharedArray;

    private Team myTeam;
    private Team opponentTeam;

    public BatScorer(UnitController uc, SharedArray sharedArray) {
        this.uc = uc;
        this.sharedArray = sharedArray;

        myTeam = uc.getTeam();
        opponentTeam = myTeam.getOpponent();
    }

    public BatScore getBatScore(Location batLocation, Direction batDirection) {
        UnitInfo unit = uc.senseUnitAtLocation(batLocation);
        if (unit != null && unit.getType() != UnitType.HQ) {
            return getBatScoreUnit(batLocation, batDirection);
        }

        MapObject mapObject = uc.senseObjectAtLocation(batLocation, true);
        if (mapObject == MapObject.BALL) {
            return getBatScoreBall(batLocation, batDirection);
        }

        return null;
    }

    public BatScore getBatScoreUnit(Location batLocation, Direction batDirection) {
        int maxScore = 0;
        int bestDistance = 0;

        int currentScore = 0;

        UnitInfo batUnit = uc.senseUnitAtLocation(batLocation);
        if (batUnit.getTeam() == opponentTeam) {
            currentScore++;
        }

        Location myLocation = uc.getLocation();
        int visionRange = (int) uc.getType().getStat(UnitStat.VISION_RANGE);

        Location moveTarget = sharedArray.getMoveTarget(batUnit.getID());
        int initialMoveTargetDistance = moveTarget != null ? batUnit.getLocation().distanceSquared(moveTarget) : 0;
        boolean useMoveTarget = moveTarget != null
            && batUnit.getType() == UnitType.BATTER
            && batUnit.getTeam() == myTeam
            && !sharedArray.hasActed(batUnit.getID())
            && (batUnit.getCurrentMovementCooldown() < 1 || batUnit.getCurrentActionCooldown() < 1);

        for (int i = 1; i <= 3; i++) {
            Location hitLocation = batLocation.add(batDirection.dx * i, batDirection.dy * i);
            boolean unitDestroyed = false;

            if (myLocation.distanceSquared(hitLocation) <= visionRange) {
                if (uc.isOutOfMap(hitLocation)) {
                    currentScore += batUnit.getTeam() == myTeam ? -2 : 2;
                    unitDestroyed = true;
                } else {
                    MapObject mapObject = uc.senseObjectAtLocation(hitLocation, true);
                    if (mapObject == MapObject.WATER || mapObject == MapObject.BALL) {
                        currentScore += batUnit.getTeam() == myTeam ? -2 : 2;
                        unitDestroyed = true;
                    }

                    UnitInfo hitUnit = uc.senseUnitAtLocation(hitLocation);
                    if (hitUnit != null) {
                        if (hitUnit.getType() != UnitType.CATCHER) {
                            currentScore += batUnit.getTeam() == myTeam ? -2 : 2;
                            if (hitUnit.getType() != UnitType.HQ) {
                                currentScore += hitUnit.getTeam() == myTeam ? -2 : 2;
                            }
                        }

                        unitDestroyed = true;
                    }
                }
            } else if (batUnit.getTeam() == myTeam) {
                break;
            }

            int finalScore = currentScore;
            if (useMoveTarget && !unitDestroyed) {
                if (hitLocation.distanceSquared(moveTarget) < initialMoveTargetDistance) {
                    finalScore++;
                }
            }

            if (finalScore > maxScore || (finalScore == maxScore && finalScore > 0)) {
                maxScore = finalScore;
                bestDistance = i;
            }

            if (unitDestroyed) {
                break;
            }
        }

        if (maxScore == 0) {
            return null;
        }

        return new BatScore(maxScore, bestDistance);
    }

    public BatScore getBatScoreBall(Location batLocation, Direction batDirection) {
        int maxScore = 0;
        int bestDistance = 0;

        int currentScore = 0;

        for (int i = 1; i <= 3; i++) {
            Location hitLocation = batLocation.add(batDirection.dx * i, batDirection.dy * i);
            if (!uc.canSenseLocation(hitLocation)) {
                break;
            }

            boolean ballDestroyed = false;

            MapObject hitObject = uc.senseObjectAtLocation(hitLocation, true);
            if (hitObject == MapObject.BALL) {
                currentScore++;
                ballDestroyed = true;
            } else if (hitObject == MapObject.WATER) {
                break;
            }

            UnitInfo hitUnit = uc.senseUnitAtLocation(hitLocation);
            if (hitUnit != null) {
                int multiplier = hitUnit.getTeam() == opponentTeam ? 1 : -1;
                if (hitUnit.getType() == UnitType.HQ) {
                    currentScore += 10 * multiplier;
                    ballDestroyed = true;
                } else if (hitUnit.getType() == UnitType.CATCHER) {
                    ballDestroyed = true;
                } else {
                    currentScore += 2 * multiplier;
                }
            }

            if (currentScore > maxScore || (currentScore == maxScore && currentScore > 0)) {
                maxScore = currentScore;
                bestDistance = i;
            }

            if (ballDestroyed) {
                break;
            }
        }

        if (maxScore == 0) {
            return null;
        }

        return new BatScore(maxScore, bestDistance);
    }
}
