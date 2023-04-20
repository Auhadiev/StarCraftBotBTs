package starcraft.bot.Nodes.LeafNode.Action.impl;

import bwapi.Unit;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Action.Action;

import java.util.ArrayList;

public class SetAttackMarinesAction extends Action {
    @Override
    public void start() {
        run();
        ArrayList<Unit> protectMarines = BlackBoard.getInstance().getProtectMarines();
        if (BlackBoard.getInstance().getAttackMarines().size() > 0){
            succeed();
            return;
        }
        if (protectMarines != null) {
            for (int i = 0; i < 9; i++) {
                if (protectMarines.size() > 0) {
                    BlackBoard.getInstance().getAttackMarines().add(protectMarines.get(0));
                    protectMarines.remove(0);
                } else
                    break;
            }
        }
        if (BlackBoard.getInstance().getAttackMarines().size() > 0){
            succeed();
        } else {
            fail();
        }
    }
}
