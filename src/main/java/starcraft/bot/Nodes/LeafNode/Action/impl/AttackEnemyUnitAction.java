package starcraft.bot.Nodes.LeafNode.Action.impl;

import bwapi.Unit;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Action.Action;
import starcraft.bot.Utility.MilitaryUtility;
import starcraft.bot.Utility.UnitUtility;

import java.util.ArrayList;

public class AttackEnemyUnitAction extends Action {
    @Override
    public void start() {
        run();
        BlackBoard blackBoard = BlackBoard.getInstance();
        ArrayList<Unit> marines = blackBoard.getAttackMarines();
        Unit enemyUnit = null;
        if (marines != null) {
            for (Unit marine : marines) {
                enemyUnit = UnitUtility.getClosestEnemyUnit(marine);
                if (enemyUnit != null) {
                    break;
                }
            }
        }
        if (enemyUnit != null) {
            for (Unit marine : marines) {
                MilitaryUtility.attack(marine, enemyUnit);
            }
            succeed();
        } else {
            fail();
        }
    }
}
