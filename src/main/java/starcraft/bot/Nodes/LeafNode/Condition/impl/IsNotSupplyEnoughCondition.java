package starcraft.bot.Nodes.LeafNode.Condition.impl;

import bwapi.UnitType;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Condition.Condition;
import starcraft.bot.Utility.GameUtility;

public class IsNotSupplyEnoughCondition extends Condition {

    @Override
    public void start() {
        run();
        if(GameUtility.getSupplyTotal() - GameUtility.getSupplyUsed() < 10 &&
                !BlackBoard.getInstance().getBuildingsUnderConstruction().contains(UnitType.Terran_Supply_Depot)) {
            succeed();
            return;
        }
        fail();
    }
}
