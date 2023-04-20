package starcraft.bot.Nodes.LeafNode.Action.impl;

import bwapi.Unit;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Action.Action;
import starcraft.bot.Utility.MilitaryUtility;

public class ProtectBaseAction extends Action {

    @Override
    public void start() {
        run();
        Unit enemy = BlackBoard.getInstance().getEnemyInBase().get();
        if (enemy != null) {
            BlackBoard.getInstance().getProtectMarines().forEach(unit -> {
                MilitaryUtility.attack(unit, enemy);
            });
        }
        succeed();
    }
}
