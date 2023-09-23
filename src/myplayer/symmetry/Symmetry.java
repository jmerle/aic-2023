package myplayer.symmetry;

import aic2023.user.Location;
import myplayer.util.SharedArray;

public abstract class Symmetry {
    private int width;
    private int height;

    private boolean reflectX;
    private boolean reflectY;

    public Symmetry(SharedArray sharedArray, boolean reflectX, boolean reflectY) {
        width = sharedArray.getMaxX() - sharedArray.getMinX();
        height = sharedArray.getMaxY() - sharedArray.getMinY();
        this.reflectX = reflectX;
        this.reflectY = reflectY;
    }

    public Location reflect(Location location) {
        int x = reflectX ? width - 1 - location.x : location.x;
        int y = reflectY ? height - 1 - location.y : location.y;
        return new Location(x, y);
    }
}
