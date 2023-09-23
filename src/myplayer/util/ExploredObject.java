package myplayer.util;

import aic2023.user.Location;

public class ExploredObject {
    public Location location;
    public boolean occupied;

    public ExploredObject(Location location, boolean occupied) {
        this.location = location;
        this.occupied = occupied;
    }
}
