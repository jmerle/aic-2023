package myplayer_v02.unit;

import aic2023.user.UnitController;
import aic2023.user.UnitType;

public class Batter extends MoveableUnit {
    public Batter(UnitController uc) {
        super(uc, UnitType.BATTER);
    }

    @Override
    public void run() {
        super.run();

        explore();
    }
}
