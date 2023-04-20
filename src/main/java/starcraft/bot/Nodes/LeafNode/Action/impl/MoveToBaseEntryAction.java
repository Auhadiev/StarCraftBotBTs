package starcraft.bot.Nodes.LeafNode.Action.impl;

import bwapi.Unit;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Action.Action;
import starcraft.bot.Utility.UnitUtility;

import java.util.ArrayList;

public class MoveToBaseEntryAction extends Action {

    @Override
    public void start() {
        run();
        ArrayList<Unit> marines = BlackBoard.getInstance().getIdleMarines();

        if (marines.size() > 0) {
            if (BlackBoard.getInstance().getEntryBasePosition().get() != null) {
                for (Unit marine : marines) {
                    UnitUtility.move(marine, BlackBoard.getInstance().getEntryBasePosition().get().toPosition());
                    BlackBoard.getInstance().getProtectMarines().add(marine);
                }
                marines.clear();
            }
        }
        succeed();
    }

}
