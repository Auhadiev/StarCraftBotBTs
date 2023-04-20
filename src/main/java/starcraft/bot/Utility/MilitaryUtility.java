package starcraft.bot.Utility;

import bwapi.Unit;

public class MilitaryUtility extends UnitUtility {

    public static boolean attack(Unit myUnit, Unit enemyUnit) {
        return myUnit.attack(enemyUnit);
    }
}
