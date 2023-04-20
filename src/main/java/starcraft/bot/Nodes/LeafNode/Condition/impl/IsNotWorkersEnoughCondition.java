package starcraft.bot.Nodes.LeafNode.Condition.impl;

import bwapi.UnitType;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Condition.Condition;
import starcraft.bot.Utility.GameUtility;

public class IsNotWorkersEnoughCondition extends Condition {

    @Override
    public void start() {
        run();
        if (GameUtility.getUnitsCount(UnitType.Terran_SCV) < BlackBoard.getInstance().getRequiredWorkersCount().get()) {
            succeed();
        } else
            fail();
    }

}
