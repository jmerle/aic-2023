package myplayer_v31_final.util;

import aic2023.user.GameConstants;
import aic2023.user.Location;
import aic2023.user.UnitController;
import aic2023.user.UnitStat;

public class ExploredTiles {
    private UnitController uc;
    private SharedArray sharedArray;

    private int xOffset;
    private boolean xOffsetSubtract;

    private int yOffset;
    private boolean yOffsetSubtract;

    public ExploredTiles(UnitController uc, SharedArray sharedArray, int xOffset, boolean xOffsetSubtract, int yOffset, boolean yOffsetSubtract) {
        this.uc = uc;
        this.sharedArray = sharedArray;
        this.xOffset = xOffset;
        this.xOffsetSubtract = xOffsetSubtract;
        this.yOffset = yOffset;
        this.yOffsetSubtract = yOffsetSubtract;
    }

    public boolean isExplored(Location location) {
        int x = xOffsetSubtract ? xOffset - location.x : location.x - xOffset;
        int y = yOffsetSubtract ? yOffset - location.y : location.y - yOffset;
        return uc.read(sharedArray.INDEX_UNEXPLORED_OFFSET + y * GameConstants.MAX_MAP_SIZE + x) == 1;
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
        int myX = myLocation.x;
        int myY = myLocation.y;
        int height = GameConstants.MAX_MAP_SIZE;
        int maxIndex = GameConstants.MAX_MAP_SIZE * GameConstants.MAX_MAP_SIZE;
        int writeOffset = sharedArray.INDEX_UNEXPLORED_OFFSET;
        int index;

        if (xOffsetSubtract && yOffsetSubtract) {
            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (xOffsetSubtract) {
            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (yOffsetSubtract) {
            index = (yOffset - (myY - 4)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else {
            index = ((myY - 4) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        }
    }

    private void markExploredPartial20() {
        Location myLocation = uc.getLocation();
        int myX = myLocation.x;
        int myY = myLocation.y;
        int height = GameConstants.MAX_MAP_SIZE;
        int maxIndex = GameConstants.MAX_MAP_SIZE * GameConstants.MAX_MAP_SIZE;
        int writeOffset = sharedArray.INDEX_UNEXPLORED_OFFSET;
        int index;

        if (xOffsetSubtract && yOffsetSubtract) {
            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (xOffsetSubtract) {
            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (yOffsetSubtract) {
            index = (yOffset - (myY - 4)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else {
            index = ((myY - 4) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        }
    }

    private void markExploredFull32() {
        Location myLocation = uc.getLocation();
        int myX = myLocation.x;
        int myY = myLocation.y;
        int height = GameConstants.MAX_MAP_SIZE;
        int maxIndex = GameConstants.MAX_MAP_SIZE * GameConstants.MAX_MAP_SIZE;
        int writeOffset = sharedArray.INDEX_UNEXPLORED_OFFSET;
        int index;

        if (xOffsetSubtract && yOffsetSubtract) {
            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (xOffsetSubtract) {
            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (yOffsetSubtract) {
            index = (yOffset - (myY - 5)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else {
            index = ((myY - 5) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        }
    }

    private void markExploredPartial32() {
        Location myLocation = uc.getLocation();
        int myX = myLocation.x;
        int myY = myLocation.y;
        int height = GameConstants.MAX_MAP_SIZE;
        int maxIndex = GameConstants.MAX_MAP_SIZE * GameConstants.MAX_MAP_SIZE;
        int writeOffset = sharedArray.INDEX_UNEXPLORED_OFFSET;
        int index;

        if (xOffsetSubtract && yOffsetSubtract) {
            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (xOffsetSubtract) {
            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (yOffsetSubtract) {
            index = (yOffset - (myY - 5)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else {
            index = ((myY - 5) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        }
    }

    private void markExploredFull64() {
        Location myLocation = uc.getLocation();
        int myX = myLocation.x;
        int myY = myLocation.y;
        int height = GameConstants.MAX_MAP_SIZE;
        int maxIndex = GameConstants.MAX_MAP_SIZE * GameConstants.MAX_MAP_SIZE;
        int writeOffset = sharedArray.INDEX_UNEXPLORED_OFFSET;
        int index;

        if (xOffsetSubtract && yOffsetSubtract) {
            index = (yOffset - (myY - 8)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 8));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 8));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 8)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (xOffsetSubtract) {
            index = ((myY - 8) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 8));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 8));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 8) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (yOffsetSubtract) {
            index = (yOffset - (myY - 8)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 8) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 8) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 8)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else {
            index = ((myY - 8) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 8) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 8) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 8) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        }
    }

    private void markExploredPartial64() {
        Location myLocation = uc.getLocation();
        int myX = myLocation.x;
        int myY = myLocation.y;
        int height = GameConstants.MAX_MAP_SIZE;
        int maxIndex = GameConstants.MAX_MAP_SIZE * GameConstants.MAX_MAP_SIZE;
        int writeOffset = sharedArray.INDEX_UNEXPLORED_OFFSET;
        int index;

        if (xOffsetSubtract && yOffsetSubtract) {
            index = (yOffset - (myY - 8)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 8));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + (xOffset - (myX + 8));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 8)) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (xOffsetSubtract) {
            index = ((myY - 8) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 8));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + (xOffset - (myX + 8));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + (xOffset - (myX + 7));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + (xOffset - (myX + 6));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX - 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX - 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX + 4));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + (xOffset - (myX + 5));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX - 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX - 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX - 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX + 1));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX + 2));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (xOffset - (myX + 3));
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 8) - yOffset) * height + (xOffset - myX);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else if (yOffsetSubtract) {
            index = (yOffset - (myY - 8)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 7)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 6)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 5)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 4)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 3)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 2)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY - 1)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 8) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - myY) * height + ((myX + 8) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 1)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 2)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 3)) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 4)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 5)) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 6)) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 7)) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (yOffset - (myY + 8)) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        } else {
            index = ((myY - 8) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 7) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 6) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 5) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 4) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 3) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 2) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY - 1) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 8) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = (myY - yOffset) * height + ((myX + 8) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 1) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 2) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 3) - yOffset) * height + ((myX + 7) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 4) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 5) - yOffset) * height + ((myX + 6) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX - 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX - 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX + 4) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 6) - yOffset) * height + ((myX + 5) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX - 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX - 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX - 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX + 1) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX + 2) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 7) - yOffset) * height + ((myX + 3) - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);

            index = ((myY + 8) - yOffset) * height + (myX - xOffset);
            if (index >= 0 && index < maxIndex) uc.write(writeOffset + index, 1);
        }
    }
}
