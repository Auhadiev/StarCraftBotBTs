package starcraft.bot.Nodes.LeafNode.Condition.impl;

import bwapi.Unit;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Condition.Condition;
import starcraft.bot.Utility.GameUtility;

import java.util.ArrayList;

public class IsBaseUnderAttackCondition extends Condition {
    @Override
    public void start() {
        run();
        ArrayList<Unit> buildings = GameUtility.getBuildings();
        for (Unit building : buildings) {
            Unit enemy = GameUtility.getNearEnemy(building);
            if (enemy != null) {
                if (BlackBoard.getInstance().getEnemyInBase().get() == null) {
                    BlackBoard.getInstance().getEnemyInBase().set(enemy);
                }
                succeed();
                break;
            } else {
                BlackBoard.getInstance().getEnemyInBase().set(null);
            }
        }
        if (BlackBoard.getInstance().getEnemyInBase().get() != null) {
            succeed();
        } else {
            fail();
        }
    }
}
