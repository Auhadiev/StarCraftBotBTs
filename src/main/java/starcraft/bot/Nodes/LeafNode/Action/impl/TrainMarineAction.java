package starcraft.bot.Nodes.LeafNode.Action.impl;

import bwapi.UnitType;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Action.Action;
import starcraft.bot.Utility.BuildingUtility;
import starcraft.bot.Utility.GameUtility;

public class TrainMarineAction extends Action {

    @Override
    public void start() {
        run();
        if (UnitType.Terran_Marine.mineralPrice() <= GameUtility.getMineralsCount()) {
            if (BuildingUtility.trainUnit(UnitType.Terran_Marine))
                BlackBoard.getInstance().getTrainingUnits().add(UnitType.Terran_Marine);
        }
        succeed();
    }

}
