package starcraft.bot.Nodes.LeafNode.Condition.impl;

import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Condition.Condition;
import starcraft.bot.Utility.GameUtility;

public class IsReadyToAttackCondition extends Condition {

    @Override
    public void start() {
        run();
        BlackBoard blackBoard = BlackBoard.getInstance();
        if ((blackBoard.getEnemiesBuildings().get(GameUtility.getEnemy()) != null && blackBoard.getProtectMarines().size() > 9)
            || blackBoard.getAttackMarines().size() > 0) {
            succeed();
        } else {
            fail();
        }
    }
}
