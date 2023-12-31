package myplayer_v05.unit;

import aic2023.user.Direction;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.Team;
import aic2023.user.UnitController;
import aic2023.user.UnitInfo;
import aic2023.user.UnitStat;
import aic2023.user.UnitType;
import myplayer_v05.symmetry.HorizontalSymmetry;
import myplayer_v05.symmetry.RotationalSymmetry;
import myplayer_v05.symmetry.Symmetry;
import myplayer_v05.symmetry.VerticalSymmetry;
import myplayer_v05.util.ExploredObject;
import myplayer_v05.util.ExploredTiles;
import myplayer_v05.util.RangeData;
import myplayer_v05.util.SharedArray;

public abstract class Unit {
    protected UnitController uc;

    protected UnitType me;

    protected Team myTeam;
    protected Team opponentTeam;

    protected SharedArray sharedArray;
    protected RangeData rangeData;

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

    private Symmetry symmetry;
    private boolean sharedFullExploredData;

    public Unit(UnitController uc, UnitType type) {
        this.uc = uc;

        me = type;

        myTeam = uc.getTeam();
        opponentTeam = myTeam.getOpponent();

        sharedArray = new SharedArray(uc);
        rangeData = new RangeData();
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
            ExploredTiles exploredTiles = sharedArray.getExploredTiles();

            int width = sharedArray.hasMapWidth() ? sharedArray.getMapWidth() : -1;
            int height = sharedArray.hasMapHeight() ? sharedArray.getMapHeight() : -1;

            if (width == -1 || height == -1 || exploredTiles.countExplored() < width * height) {
                int[][] offsets = sharedFullExploredData
                    ? rangeData.getOuterRing((int) visionRange)
                    : rangeData.getRange((int) visionRange);

                for (int[] offset : offsets) {
                    Location location = myLocation.add(offset[0], offset[1]);
                    if (!uc.isOutOfMap(location)) {
                        exploredTiles.setExplored(location);
                    }
                }

                sharedArray.setExploredTiles(exploredTiles);
                sharedFullExploredData = true;
            }
        }

        Symmetry currentSymmetry = hasSymmetry() ? getSymmetry() : null;
        ExploredTiles exploredTiles = sharedArray.hasExploredTiles() ? sharedArray.getExploredTiles() : null;

        if (currentSymmetry != null && exploredTiles != null) {
            for (ExploredObject object : sharedArray.getExploredBases()) {
                Location reflected = currentSymmetry.reflect(object.location);
                if (!exploredTiles.isExplored(reflected)) {
                    sharedArray.setExploredBase(reflected, sharedArray.OCCUPATION_EMPTY);
                }
            }

            for (ExploredObject object : sharedArray.getExploredStadiums()) {
                Location reflected = currentSymmetry.reflect(object.location);
                if (!exploredTiles.isExplored(reflected)) {
                    sharedArray.setExploredStadium(reflected, sharedArray.OCCUPATION_EMPTY);
                }
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
