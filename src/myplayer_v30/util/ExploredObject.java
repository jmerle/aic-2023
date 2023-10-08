package myplayer_v30.util;

import aic2023.user.Location;
import aic2023.user.MapObject;

public class ExploredObject {
    public Location location;
    public MapObject type;
    public int occupation;
    public int lastUpdate;

    public ExploredObject(Location location, MapObject type, int occupation, int lastUpdate) {
        this.location = location;
        this.type = type;
        this.occupation = occupation;
        this.lastUpdate = lastUpdate;
    }
}
