package myplayer_v02.unit;

import aic2023.user.UnitController;
import aic2023.user.UnitType;

public class Catcher extends MoveableUnit {
    public Catcher(UnitController uc) {
        super(uc, UnitType.CATCHER);
    }

    @Override
    public void run() {
        super.run();

        explore();
    }
}
