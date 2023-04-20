package starcraft.bot.Nodes.LeafNode.Action.impl;

import bwapi.UnitType;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Action.Action;
import starcraft.bot.Utility.WorkerUtility;

public class BuildSupplyDepotAction extends Action {

    @Override
    public void start() {
        run();
        if (WorkerUtility.build(UnitType.Terran_Supply_Depot)) {
            BlackBoard.getInstance().getBuildingsUnderConstruction().add(UnitType.Terran_Supply_Depot);
            succeed();
        } else
            fail();
    }

}
