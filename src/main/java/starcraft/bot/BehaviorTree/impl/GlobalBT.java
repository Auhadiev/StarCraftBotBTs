package starcraft.bot.BehaviorTree.impl;

import starcraft.bot.BehaviorTree.BehaviorTree;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.impl.GlobalRoot;

public class GlobalBT extends BehaviorTree {

    private GlobalBT() {
        this.root = new GlobalRoot();
    }

    private static class SingletonHolder {
        private final static GlobalBT instance = new GlobalBT();
    }

    public static GlobalBT getInstance() {
        return SingletonHolder.instance;
    }
}
