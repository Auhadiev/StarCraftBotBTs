package starcraft.bot.Nodes.LeafNode.Action.impl;

import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Action.Action;
import starcraft.bot.Utility.GameUtility;

public class SetRequiredWorkersCountAction extends Action {

    @Override
    public void start() {
        run();
        int requiredWorkersCount = 0;
        int movingUnitsCount = GameUtility.getSupplyTotal();
        if (movingUnitsCount < 40)
            requiredWorkersCount = 6;
        else if (movingUnitsCount < 55)
            requiredWorkersCount = 12;
        else if (movingUnitsCount < 65)
            requiredWorkersCount = 75;
        else
            requiredWorkersCount = 18;
        BlackBoard.getInstance().getRequiredWorkersCount().set(requiredWorkersCount);
        succeed();
    }

}
