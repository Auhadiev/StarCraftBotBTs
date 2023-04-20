package starcraft.bot.Nodes.LeafNode.Action.impl;

import starcraft.bot.Nodes.LeafNode.Action.Action;
import starcraft.bot.Utility.WorkerUtility;

public class GatherMineralsAction extends Action {

    @Override
    public void start(){
        run();
        WorkerUtility.gatherMineralsForAll();
        succeed();
    }
}
