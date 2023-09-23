package myplayer.util;

public class ExploredTiles {
    public long[] rows;

    public int xOffset;
    public boolean xOffsetSubtract;

    public int yOffset;
    public boolean yOffsetSubtract;

    public ExploredTiles(long[] rows, int xOffset, boolean xOffsetSubtract, int yOffset, boolean yOffsetSubtract) {
        this.rows = rows;
        this.xOffset = xOffset;
        this.xOffsetSubtract = xOffsetSubtract;
        this.yOffset = yOffset;
        this.yOffsetSubtract = yOffsetSubtract;
    }

    public boolean isExplored(int x, int y) {
        x = xOffsetSubtract ? xOffset - x : x - xOffset;
        y = yOffsetSubtract ? yOffset - y : y - yOffset;
        return (rows[y] & (1L << x)) != 0;
    }

    public void setExplored(int x, int y) {
        x = xOffsetSubtract ? xOffset - x : x - xOffset;
        y = yOffsetSubtract ? yOffset - y : y - yOffset;
        rows[y] |= 1L << x;
    }

    public int countUnexplored() {
        int count = 0;

        for (long row : rows) {
            count += Long.bitCount(row);
        }

        return count;
    }
}
