package myplayer_v12.util;

import aic2023.user.Location;

public class ExploredObject {
    public Location location;
    public int occupation;

    public ExploredObject(Location location, int occupation) {
        this.location = location;
        this.occupation = occupation;
    }
}