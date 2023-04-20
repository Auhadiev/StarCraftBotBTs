package starcraft.bot.Nodes.LeafNode.Condition.impl;

import bwapi.UnitType;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Condition.Condition;
import starcraft.bot.Utility.GameUtility;

public class IsNotBarracksBuiltCondition extends Condition {

    @Override
    public void start() {
        run();
        if(!GameUtility.isBuildingBuilt(UnitType.Terran_Barracks) &&
                !BlackBoard.getInstance().getBuildingsUnderConstruction().contains(UnitType.Terran_Barracks)) {
            succeed();
            return;
        }
        fail();
    }
}
