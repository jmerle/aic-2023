package myplayer_v21;

import aic2023.user.Location;
import aic2023.user.UnitController;
import aic2023.user.UnitType;
import myplayer_v21.unit.Batter;
import myplayer_v21.unit.Catcher;
import myplayer_v21.unit.HQ;
import myplayer_v21.unit.Pitcher;
import myplayer_v21.unit.Unit;

public class UnitPlayer {
    public void run(UnitController uc) {
        Unit unit = createUnit(uc);

        if (unit == null) {
            return;
        }

        while (true) {
            if (performTurn(uc, unit)) {
                uc.yield();
            }
        }
    }

    private boolean performTurn(UnitController uc, Unit unit) {
        int startRound = uc.getRound();
        int startBytecodes = uc.getEnergyUsed();

        try {
            unit.run();
        } catch (Exception e) {
            uc.println(getLogPrefix(uc) + "Exception: " + e.getMessage());
            e.printStackTrace();
        }

        int endRound = uc.getRound();
        int endBytecodes = uc.getEnergyUsed();
        int maxBytecodes = 15000;

        int usedBytecodes = startRound == endRound
            ? endBytecodes - startBytecodes
            : (maxBytecodes - startBytecodes) + Math.max(0, endRound - startRound - 1) * maxBytecodes + endBytecodes;

        double bytecodePercentage = (double) usedBytecodes / (double) maxBytecodes * 100.0;
        if (bytecodePercentage > 95) {
            uc.println(getLogPrefix(uc) + "High bytecode usage: " + usedBytecodes + " (" + bytecodePercentage + "%)");
        }

        return bytecodePercentage < 100;
    }

    private String getLogPrefix(UnitController uc) {
        Location location = uc.getLocation();
        return "[" + uc.getTeam() + "|" + uc.getRound() + "|" + uc.getInfo().getID() + "|" + uc.getType() + "|" + location.x + "," + location.y + "] ";
    }

    private Unit createUnit(UnitController uc) {
        UnitType type = uc.getType();

        if (type == UnitType.HQ) {
            return new HQ(uc);
        } else if (type == UnitType.PITCHER) {
            return new Pitcher(uc);
        } else if (type == UnitType.BATTER) {
            return new Batter(uc);
        } else if (type == UnitType.CATCHER) {
            return new Catcher(uc);
        }

        uc.println("Unknown unit type: " + type);
        return null;
    }
}
