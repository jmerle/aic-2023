package myplayer.util;

import aic2023.user.GameConstants;
import aic2023.user.Location;
import aic2023.user.MapObject;
import aic2023.user.UnitController;

public class SharedArray {
    private int nextIndex = 0;

    private int INDEX_OPPONENT_HQ = allocate(1);
    private int INDEX_HAS_MIN_X = allocate(1);
    private int INDEX_MIN_X = allocate(1);
    private int INDEX_HAS_MAX_X = allocate(1);
    private int INDEX_MAX_X = allocate(1);
    private int INDEX_HAS_MIN_Y = allocate(1);
    private int INDEX_MIN_Y = allocate(1);
    private int INDEX_HAS_MAX_Y = allocate(1);
    private int INDEX_MAX_Y = allocate(1);
    private int INDEX_EXPLORED_OBJECTS_COUNT = allocate(1);
    private int INDEX_EXPLORED_OBJECTS_OFFSET = allocate(GameConstants.MAX_MAP_SIZE * GameConstants.MAX_MAP_SIZE * 4);
    private int INDEX_UNEXPLORED_USE_MIN_X = allocate(1);
    private int INDEX_UNEXPLORED_USE_MIN_Y = allocate(1);
    public int INDEX_UNEXPLORED_OFFSET = allocate(GameConstants.MAX_MAP_SIZE * GameConstants.MAX_MAP_SIZE);
    private int INDEX_MOVE_TARGET_OFFSET = allocate(GameConstants.MAX_ID);
    private int INDEX_LAST_ROUND_OFFSET = allocate(GameConstants.MAX_ID);

    private MapObject[] MAP_OBJECTS = MapObject.values();

    public int OCCUPATION_EMPTY = 0;
    public int OCCUPATION_ME = 1;
    public int OCCUPATION_OPPONENT = 2;

    private UnitController uc;

    public SharedArray(UnitController uc) {
        this.uc = uc;
    }

    public Location getOpponentHQ() {
        return intToLocation(uc.read(INDEX_OPPONENT_HQ));
    }

    public void setOpponentHQ(Location location) {
        uc.write(INDEX_OPPONENT_HQ, locationToInt(location));
    }

    public boolean hasOpponentHQ() {
        return uc.read(INDEX_OPPONENT_HQ) != 0;
    }

    public boolean hasMinX() {
        return uc.read(INDEX_HAS_MIN_X) == 1;
    }

    public int getMinX() {
        return uc.read(INDEX_MIN_X);
    }

    public void setMinX(int value) {
        uc.write(INDEX_MIN_X, value);
        uc.write(INDEX_HAS_MIN_X, 1);
    }

    public boolean hasMaxX() {
        return uc.read(INDEX_HAS_MAX_X) == 1;
    }

    public int getMaxX() {
        return uc.read(INDEX_MAX_X);
    }

    public void setMaxX(int value) {
        uc.write(INDEX_MAX_X, value);
        uc.write(INDEX_HAS_MAX_X, 1);
    }

    public boolean hasMapWidth() {
        return hasMinX() && hasMaxX();
    }

    public int getMapWidth() {
        return getMaxX() - getMinX() + 1;
    }

    public boolean hasMinY() {
        return uc.read(INDEX_HAS_MIN_Y) == 1;
    }

    public int getMinY() {
        return uc.read(INDEX_MIN_Y);
    }

    public void setMinY(int value) {
        uc.write(INDEX_MIN_Y, value);
        uc.write(INDEX_HAS_MIN_Y, 1);
    }

    public boolean hasMaxY() {
        return uc.read(INDEX_HAS_MAX_Y) == 1;
    }

    public int getMaxY() {
        return uc.read(INDEX_MAX_Y);
    }

    public void setMaxY(int value) {
        uc.write(INDEX_MAX_Y, value);
        uc.write(INDEX_HAS_MAX_Y, 1);
    }

    public boolean hasMapHeight() {
        return hasMinY() && hasMaxY();
    }

    public int getMapHeight() {
        return getMaxY() - getMinY() + 1;
    }

    public boolean hasMapSize() {
        return hasMapWidth() && hasMapHeight();
    }

    public ExploredObject[] getExploredObjects() {
        int count = uc.read(INDEX_EXPLORED_OBJECTS_COUNT);

        ExploredObject[] objects = new ExploredObject[count];
        for (int i = 0; i < count; i++) {
            int baseIndex = INDEX_EXPLORED_OBJECTS_OFFSET + i * 4;
            Location location = intToLocation(uc.read(baseIndex));
            MapObject type = MAP_OBJECTS[uc.read(baseIndex + 1)];
            int occupation = uc.read(baseIndex + 2);
            int lastUpdate = uc.read(baseIndex + 3);

            objects[i] = new ExploredObject(location, type, occupation, lastUpdate);
        }

        return objects;
    }

    public void setExploredObject(Location location, MapObject type, int occupation) {
        int count = uc.read(INDEX_EXPLORED_OBJECTS_COUNT);

        for (int i = 0; i < count; i++) {
            int baseIndex = INDEX_EXPLORED_OBJECTS_OFFSET + i * 4;
            if (location.isEqual(intToLocation(uc.read(baseIndex)))) {
                uc.write(baseIndex + 1, type.ordinal());
                uc.write(baseIndex + 2, occupation);
                uc.write(baseIndex + 3, uc.getRound());
                return;
            }
        }

        int baseIndex = INDEX_EXPLORED_OBJECTS_OFFSET + count * 4;
        uc.write(baseIndex, locationToInt(location));
        uc.write(baseIndex + 1, type.ordinal());
        uc.write(baseIndex + 2, occupation);
        uc.write(baseIndex + 3, uc.getRound());
        uc.write(INDEX_EXPLORED_OBJECTS_COUNT, count + 1);
    }

    public void updateExpiredExploredObjectOccupation() {
        int currentRound = uc.getRound();
        int thresholdRound = currentRound - 3;

        int count = uc.read(INDEX_EXPLORED_OBJECTS_COUNT);
        for (int i = 0; i < count; i++) {
            int baseIndex = INDEX_EXPLORED_OBJECTS_OFFSET + i * 4;
            int occupation = uc.read(baseIndex + 2);
            int lastUpdate = uc.read(baseIndex + 3);
            if (occupation == OCCUPATION_ME && lastUpdate < thresholdRound) {
                uc.write(baseIndex + 2, OCCUPATION_EMPTY);
            }
        }
    }

    public boolean hasExploredTiles() {
        return (hasMinX() || hasMaxX()) && (hasMinY() || hasMaxY());
    }

    public ExploredTiles getExploredTiles() {
        int useMinXValue = uc.read(INDEX_UNEXPLORED_USE_MIN_X);
        boolean useMinX;
        if (useMinXValue == 0) {
            useMinX = hasMinX();
            uc.write(INDEX_UNEXPLORED_USE_MIN_X, useMinX ? 1 : 2);
        } else {
            useMinX = useMinXValue == 1;
        }

        int useMinYValue = uc.read(INDEX_UNEXPLORED_USE_MIN_Y);
        boolean useMinY;
        if (useMinYValue == 0) {
            useMinY = hasMinY();
            uc.write(INDEX_UNEXPLORED_USE_MIN_Y, useMinY ? 1 : 2);
        } else {
            useMinY = useMinYValue == 1;
        }

        int xOffset = useMinX ? getMinX() : getMaxX();
        boolean xOffsetSubtract = !useMinX;

        int yOffset = useMinY ? getMinY() : getMaxY();
        boolean yOffsetSubtract = !useMinY;

        return new ExploredTiles(uc, this, xOffset, xOffsetSubtract, yOffset, yOffsetSubtract);
    }

    public Location getMoveTarget(int id) {
        return intToLocation(uc.read(INDEX_MOVE_TARGET_OFFSET + id - 1));
    }

    public void setMoveTarget(Location location) {
        uc.write(INDEX_MOVE_TARGET_OFFSET + uc.getInfo().getID() - 1, locationToInt(location));
    }

    public boolean hasActed(int id) {
        return uc.read(INDEX_LAST_ROUND_OFFSET + id - 1) == uc.getRound();
    }

    public void updateLastRound() {
        uc.write(INDEX_LAST_ROUND_OFFSET + uc.getInfo().getID() - 1, uc.getRound());
    }

    private int locationToInt(Location location) {
        return (location.y * 1060 + location.x) + 1;
    }

    private Location intToLocation(int value) {
        return value > 0
            ? new Location((value - 1) % 1060, (value - 1) / 1060)
            : null;
    }

    private int allocate(int size) {
        int index = nextIndex;
        nextIndex += size;
        return index;
    }
}
