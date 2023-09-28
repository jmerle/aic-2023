package myplayer_v19.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.Team;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer_v19.symmetry.HorizontalSymmetry;
import myplayer_v19.symmetry.RotationalSymmetry;
import myplayer_v19.symmetry.Symmetry;
import myplayer_v19.symmetry.VerticalSymmetry;
import myplayer_v19.util.ExploredTiles;
import myplayer_v19.util.MyRandom;
import myplayer_v19.util.SharedArray;

public abstract class Unit {
    protected UnitController uc;

    protected UnitType me;

    protected Team myTeam;
    protected Team opponentTeam;

    protected MyRandom random;

    protected SharedArray sharedArray;
    protected ExploredTiles exploredTiles;

    protected Direction[] adjacentDirections = {
        Direction.NORTH,
        Direction.EAST,
        Direction.SOUTH,
        Direction.WEST,
        Direction.NORTHEAST,
        Direction.SOUTHEAST,
        Direction.SOUTHWEST,
        Direction.NORTHWEST
    };

    protected Location myHQ;
    protected int spawnRound = -1;

    private Symmetry symmetry;

    private boolean sharedFullExploredData;
    private Location previousExploreLocation;

    public Unit(UnitController uc, UnitType type) {
        this.uc = uc;

        me = type;

        myTeam = uc.getTeam();
        opponentTeam = myTeam.getOpponent();

        random = new MyRandom(uc);

        sharedArray = new SharedArray(uc);
    }

    public void run() {
        Location myLocation = uc.getLocation();
        float visionRange = me.getStat(UnitStat.VISION_RANGE);

        if (myHQ == null) {
            if (me == UnitType.HQ) {
                myHQ = myLocation;
            } else {
                for (UnitInfo unit : uc.senseUnits(me.getStat(UnitStat.VISION_RANGE), myTeam)) {
                    if (unit.getType() == UnitType.HQ) {
                        myHQ = unit.getLocation();
                        break;
                    }
                }
            }
        }

        if (spawnRound == -1) {
            spawnRound = uc.getRound();
            sharedArray.setSpawnRound(spawnRound);
        }

        if (sharedArray.getOpponentHQ() == null) {
            for (UnitInfo unit : uc.senseUnits(visionRange, opponentTeam)) {
                if (unit.getType() == UnitType.HQ) {
                    sharedArray.setOpponentHQ(unit.getLocation());
                    break;
                }
            }
        }

        if (!sharedArray.hasMinX()) {
            for (int dx = -1; dx >= -8; dx--) {
                Location location = myLocation.add(dx, 0);
                if (location.distanceSquared(myLocation) > visionRange) {
                    break;
                }

                if (uc.isOutOfMap(location)) {
                    sharedArray.setMinX(location.x + 1);
                    break;
                }
            }
        }

        if (!sharedArray.hasMaxX()) {
            for (int dx = 1; dx <= 8; dx++) {
                Location location = myLocation.add(dx, 0);
                if (location.distanceSquared(myLocation) > visionRange) {
                    break;
                }

                if (uc.isOutOfMap(location)) {
                    sharedArray.setMaxX(location.x - 1);
                    break;
                }
            }
        }

        if (!sharedArray.hasMinY()) {
            for (int dy = -1; dy >= -8; dy--) {
                Location location = myLocation.add(0, dy);
                if (location.distanceSquared(myLocation) > visionRange) {
                    break;
                }

                if (uc.isOutOfMap(location)) {
                    sharedArray.setMinY(location.y + 1);
                    break;
                }
            }
        }

        if (!sharedArray.hasMaxY()) {
            for (int dy = 1; dy <= 8; dy++) {
                Location location = myLocation.add(0, dy);
                if (location.distanceSquared(myLocation) > visionRange) {
                    break;
                }

                if (uc.isOutOfMap(location)) {
                    sharedArray.setMaxY(location.y - 1);
                    break;
                }
            }
        }

        for (Location location : uc.senseObjects(MapObject.BASE, visionRange)) {
            sharedArray.setExploredBase(location, getOccupation(location));
        }

        for (Location location : uc.senseObjects(MapObject.STADIUM, visionRange)) {
            sharedArray.setExploredStadium(location, getOccupation(location));
        }

        if (sharedArray.hasExploredTiles()) {
            exploredTiles = sharedArray.getExploredTiles();

            if (!uc.getLocation().isEqual(previousExploreLocation)) {
                exploredTiles.markExplored(!sharedFullExploredData);
                sharedFullExploredData = true;
                previousExploreLocation = uc.getLocation();
            }
        }
    }

    private int getOccupation(Location location) {
        UnitInfo unit = uc.senseUnitAtLocation(location);
        if (unit == null) {
            return sharedArray.OCCUPATION_EMPTY;
        } else if (unit.getTeam() == myTeam) {
            return sharedArray.OCCUPATION_ME;
        } else {
            return sharedArray.OCCUPATION_OPPONENT;
        }
    }

    protected boolean hasSymmetry() {
        return sharedArray.hasMapSize() && sharedArray.getOpponentHQ() != null;
    }

    protected Symmetry getSymmetry() {
        if (symmetry == null) {
            Location opponentHQ = sharedArray.getOpponentHQ();

            boolean differentX = myHQ.x != opponentHQ.x;
            boolean differentY = myHQ.y != opponentHQ.y;

            if (differentX && differentY) {
                symmetry = new RotationalSymmetry(sharedArray);
            } else if (differentX) {
                symmetry = new VerticalSymmetry(sharedArray);
            } else {
                symmetry = new HorizontalSymmetry(sharedArray);
            }
        }

        return symmetry;
    }
}
