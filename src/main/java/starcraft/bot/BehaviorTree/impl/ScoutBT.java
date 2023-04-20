package starcraft.bot.BehaviorTree.impl;

import starcraft.bot.BehaviorTree.BehaviorTree;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.impl.ScoutRoot;

public class ScoutBT extends BehaviorTree {

    private ScoutBT() {
        this.root = new ScoutRoot();
    }

    private static class SingletonHolder {
        private final static ScoutBT instance = new ScoutBT();
    }

    public static ScoutBT getInstance() {
        return ScoutBT.SingletonHolder.instance;
    }

}
