package starcraft.bot.Nodes.LeafNode.Action.impl;

import bwapi.Unit;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Bot.BwemWrapper;
import starcraft.bot.Nodes.LeafNode.Action.Action;

public class SetBaseEntryPositionAction extends Action {

    @Override
    public void start() {
        run();
        if (BlackBoard.getInstance().getEntryBasePosition().get() == null && BlackBoard.getInstance().getScoutUnit().get() != null) {
            Unit scoutUnit = BlackBoard.getInstance().getScoutUnit().get();
            if (!BwemWrapper.getInstance().getBwem().getMap().getData().getTile(scoutUnit.getTilePosition()).isBuildable()) {
                BlackBoard.getInstance().getEntryBasePosition().set(scoutUnit.getTilePosition());
            }
        }
        succeed();
    }
}
