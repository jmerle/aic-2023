package myplayer_v03.util;

import aic2023.user.GameConstants;
import aic2023.user.Location;
import aic2023.user.UnitController;

public class SharedArray {
    private int INDEX_OPPONENT_HQ = 0;
    private int INDEX_HAS_MIN_X = INDEX_OPPONENT_HQ + 1;
    private int INDEX_MIN_X = INDEX_HAS_MIN_X + 1;
    private int INDEX_HAS_MAX_X = INDEX_MIN_X + 1;
    private int INDEX_MAX_X = INDEX_HAS_MAX_X + 1;
    private int INDEX_HAS_MIN_Y = INDEX_MAX_X + 1;
    private int INDEX_MIN_Y = INDEX_HAS_MIN_Y + 1;
    private int INDEX_HAS_MAX_Y = INDEX_MIN_Y + 1;
    private int INDEX_MAX_Y = INDEX_HAS_MAX_Y + 1;
    private int INDEX_BASES_COUNT = INDEX_MAX_Y + 1;
    private int INDEX_BASES_OFFSET = INDEX_BASES_COUNT + 1;
    private int INDEX_STADIUMS_COUNT = INDEX_BASES_OFFSET + (GameConstants.MAX_MAP_SIZE * GameConstants.MAX_MAP_SIZE) * 2 + 1;
    private int INDEX_STADIUMS_OFFSET = INDEX_STADIUMS_COUNT + 1;
    private int INDEX_UNEXPLORED_USE_MIN_X = INDEX_STADIUMS_OFFSET + (GameConstants.MAX_MAP_SIZE * GameConstants.MAX_MAP_SIZE) * 2 + 1;
    private int INDEX_UNEXPLORED_USE_MIN_Y = INDEX_UNEXPLORED_USE_MIN_X + 1;
    private int INDEX_UNEXPLORED_OFFSET = INDEX_UNEXPLORED_USE_MIN_Y + 1;

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

    public ExploredObject[] getExploredBases() {
        return getExploredObjects(INDEX_BASES_COUNT, INDEX_BASES_OFFSET);
    }

    public void setExploredBase(Location location, int occupation) {
        setExploredObject(INDEX_BASES_COUNT, INDEX_BASES_OFFSET, location, occupation);
    }

    public ExploredObject[] getExploredStadiums() {
        return getExploredObjects(INDEX_STADIUMS_COUNT, INDEX_STADIUMS_OFFSET);
    }

    public void setExploredStadium(Location location, int occupation) {
        setExploredObject(INDEX_STADIUMS_COUNT, INDEX_STADIUMS_OFFSET, location, occupation);
    }

    public boolean hasExploredTiles() {
        return (hasMinX() || hasMaxX()) && (hasMinY() || hasMaxY());
    }

    public ExploredTiles getExploredTiles() {
        int rowCount = hasMapHeight() ? getMapHeight() : GameConstants.MAX_MAP_SIZE;

        long[] rows = new long[rowCount];
        for (int i = 0; i < rowCount; i++) {
            int part1 = uc.read(INDEX_UNEXPLORED_OFFSET + i * 2);
            int part2 = uc.read(INDEX_UNEXPLORED_OFFSET + i * 2 + 1);
            rows[i] = (((long) part1) << 32) | (part2 & 0xffffffffL);
        }

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

        return new ExploredTiles(rows, xOffset, xOffsetSubtract, yOffset, yOffsetSubtract);
    }

    public void setExploredTiles(ExploredTiles tiles) {
        for (int i = 0; i < tiles.rows.length; i++) {
            int part1 = (int) (tiles.rows[i] >> 32);
            int part2 = (int) tiles.rows[i];
            uc.write(INDEX_UNEXPLORED_OFFSET + i * 2, part1);
            uc.write(INDEX_UNEXPLORED_OFFSET + i * 2 + 1, part2);
        }
    }

    private ExploredObject[] getExploredObjects(int indexCount, int indexOffset) {
        int count = uc.read(indexCount);

        ExploredObject[] objects = new ExploredObject[count];
        for (int i = 0; i < count; i++) {
            Location location = intToLocation(uc.read(indexOffset + i * 2));
            int occupation = uc.read(indexOffset + i * 2 + 1);
            objects[i] = new ExploredObject(location, occupation);
        }

        return objects;
    }

    private void setExploredObject(int indexCount, int indexOffset, Location location, int occupation) {
        int count = uc.read(indexCount);

        for (int i = 0; i < count; i++) {
            Location currentLocation = intToLocation(uc.read(indexOffset + i * 2));
            if (location.isEqual(currentLocation)) {
                uc.write(indexOffset + i * 2 + 1, occupation);
                return;
            }
        }

        uc.write(indexOffset + count * 2, locationToInt(location));
        uc.write(indexOffset + count * 2 + 1, occupation);
        uc.write(indexCount, count + 1);
    }

    private int locationToInt(Location location) {
        return (location.y * 1060 + location.x) + 1;
    }

    private Location intToLocation(int value) {
        return value > 0
            ? new Location((value - 1) % 1060, (value - 1) / 1060)
            : null;
    }
}
