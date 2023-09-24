package myplayer_v11.util;

import aic2023.user.Location;
import aic2023.user.UnitController;
import aic2023.user.UnitStat;

public class ExploredTiles {
    private UnitController uc;

    public long[] rows;

    private int xOffset;
    private boolean xOffsetSubtract;

    private int yOffset;
    private boolean yOffsetSubtract;

    public ExploredTiles(UnitController uc, long[] rows, int xOffset, boolean xOffsetSubtract, int yOffset, boolean yOffsetSubtract) {
        this.uc = uc;
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

    public int countExplored() {
        int count = 0;

        for (long row : rows) {
            count += Long.bitCount(row);
        }

        return count;
    }

    public void markExplored(boolean full) {
        int visionRange = (int) uc.getType().getStat(UnitStat.VISION_RANGE);

        if (visionRange == 20) {
            if (full) {
                markExploredFull20();
            } else {
                markExploredPartial20();
            }
        } else if (visionRange == 32) {
            if (full) {
                markExploredFull32();
            } else {
                markExploredPartial32();
            }
        } else if (visionRange == 64) {
            if (full) {
                markExploredFull64();
            } else {
                markExploredPartial64();
            }
        } else {
            uc.println("markExplored invalid vision range: " + visionRange);
        }
    }

    private void markExploredFull20() {
        Location myLocation = uc.getLocation();
        Location location;

        if (xOffsetSubtract && yOffsetSubtract) {
            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }
        } else if (xOffsetSubtract) {

            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }
        } else if (yOffsetSubtract) {
            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }
        } else {
            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }
        }
    }

    private void markExploredPartial20() {
        Location myLocation = uc.getLocation();
        Location location;

        if (xOffsetSubtract && yOffsetSubtract) {
            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }
        } else if (xOffsetSubtract) {

            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }
        } else if (yOffsetSubtract) {
            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }
        } else {
            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }
        }
    }

    private void markExploredFull32() {
        Location myLocation = uc.getLocation();
        Location location;

        if (xOffsetSubtract && yOffsetSubtract) {
            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }
        } else if (xOffsetSubtract) {

            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }
        } else if (yOffsetSubtract) {
            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }
        } else {
            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }
        }
    }

    private void markExploredPartial32() {
        Location myLocation = uc.getLocation();
        Location location;

        if (xOffsetSubtract && yOffsetSubtract) {
            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }
        } else if (xOffsetSubtract) {

            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }
        } else if (yOffsetSubtract) {
            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }
        } else {
            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }
        }
    }

    private void markExploredFull64() {
        Location myLocation = uc.getLocation();
        Location location;

        if (xOffsetSubtract && yOffsetSubtract) {
            location = myLocation.add(0, -8);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 8);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }
        } else if (xOffsetSubtract) {

            location = myLocation.add(0, -8);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 8);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }
        } else if (yOffsetSubtract) {
            location = myLocation.add(0, -8);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 8);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }
        } else {
            location = myLocation.add(0, -8);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 8);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }
        }
    }

    private void markExploredPartial64() {
        Location myLocation = uc.getLocation();
        Location location;

        if (xOffsetSubtract && yOffsetSubtract) {
            location = myLocation.add(0, -8);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(-1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }

            location = myLocation.add(0, 8);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (xOffset - location.x);
            }
        } else if (xOffsetSubtract) {

            location = myLocation.add(0, -8);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(-1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }


            location = myLocation.add(0, 8);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (xOffset - location.x);
            }
        } else if (yOffsetSubtract) {
            location = myLocation.add(0, -8);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 8);
            if (!uc.isOutOfMap(location)) {
                rows[yOffset - location.y] |= 1L << (location.x - xOffset);
            }
        } else {
            location = myLocation.add(0, -8);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, -1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(8, 0);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 1);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 2);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(7, 3);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 4);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(6, 5);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(4, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(5, 6);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(-1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(1, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(2, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(3, 7);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }

            location = myLocation.add(0, 8);
            if (!uc.isOutOfMap(location)) {
                rows[location.y - yOffset] |= 1L << (location.x - xOffset);
            }
        }
    }
}
