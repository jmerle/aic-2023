package myplayer.util;

import aic2023.user.Location;

public class RegisteredUnit {
    public int id;
    public Location location;
    public int value = 0;

    public RegisteredUnit(int id, Location location) {
        this.id = id;
        this.location = location;
    }
}
