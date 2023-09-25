package myplayer_v13.symmetry;

import aic2023.user.Location;
import myplayer_v13.util.SharedArray;

public abstract class Symmetry {
    private boolean reflectX;
    private boolean reflectY;

    private int minX;
    private int minY;

    private int width;
    private int height;

    public Symmetry(SharedArray sharedArray, boolean reflectX, boolean reflectY) {
        this.reflectX = reflectX;
        this.reflectY = reflectY;

        minX = sharedArray.getMinX();
        int maxX = sharedArray.getMaxX();
        minY = sharedArray.getMinY();
        int maxY = sharedArray.getMaxY();
        width = maxX - minX + 1;
        height = maxY - minY + 1;
    }

    public Location reflect(Location location) {
        int x = reflectX ? width - 1 - (location.x - minX) + minX : location.x;
        int y = reflectY ? height - 1 - (location.y - minY) + minY : location.y;
        return new Location(x, y);
    }
}
