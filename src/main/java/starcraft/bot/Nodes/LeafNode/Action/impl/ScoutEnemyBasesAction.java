package starcraft.bot.Nodes.LeafNode.Action.impl;

import bwapi.UnitType;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Action.Action;
import starcraft.bot.Utility.GameUtility;
import starcraft.bot.Utility.UnitUtility;

public class ScoutEnemyBasesAction extends Action {

    @Override
    public void start() {
        run();
        if(BlackBoard.getInstance().getEnemiesBuildings().get(GameUtility.getEnemy()) != null) {
            fail();
            return;
        }
        if (BlackBoard.getInstance().getScoutUnit().get() == null && GameUtility.getUnitsCount(UnitType.Terran_Marine) > 0) {
            BlackBoard.getInstance().getScoutUnit().set(GameUtility.getUnits(UnitType.Terran_Marine).get(0));
        }
        if (BlackBoard.getInstance().getScoutUnit().get() != null) {
            UnitUtility.scoutEnemyBases(BlackBoard.getInstance().getScoutUnit().get());
        }
        succeed();
    }
}
