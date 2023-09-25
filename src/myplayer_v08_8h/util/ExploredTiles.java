package myplayer_v08_8h.util;

import aic2023.user.Location;

public class ExploredTiles {
    public long[] rows;

    private int xOffset;
    private boolean xOffsetSubtract;

    private int yOffset;
    private boolean yOffsetSubtract;

    public ExploredTiles(long[] rows, int xOffset, boolean xOffsetSubtract, int yOffset, boolean yOffsetSubtract) {
        this.rows = rows;
        this.xOffset = xOffset;
        this.xOffsetSubtract = xOffsetSubtract;
        this.yOffset = yOffset;
        this.yOffsetSubtract = yOffsetSubtract;
    }

    public boolean isExplored(Location location) {
        int x = xOffsetSubtract ? xOffset - location.x : location.x - xOffset;
        int y = yOffsetSubtract ? yOffset - location.y : location.y - yOffset;
        return (rows[y] & (1L << x)) != 0;
    }

    public void setExplored(Location location) {
        int x = xOffsetSubtract ? xOffset - location.x : location.x - xOffset;
        int y = yOffsetSubtract ? yOffset - location.y : location.y - yOffset;
        rows[y] |= 1L << x;
    }

    public int countExplored() {
        int count = 0;

        for (long row : rows) {
            count += Long.bitCount(row);
        }

        return count;
    }
}
