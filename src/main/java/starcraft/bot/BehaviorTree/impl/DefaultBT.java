package starcraft.bot.BehaviorTree.impl;

import starcraft.bot.BehaviorTree.BehaviorTree;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.impl.DefaultRoot;

public class DefaultBT extends BehaviorTree {

    private DefaultBT() {
        this.root = new DefaultRoot();
    }

    private static class SingletonHolder {
        private final static DefaultBT instance = new DefaultBT();
    }

    public static DefaultBT getInstance() {
        return DefaultBT.SingletonHolder.instance;
    }

}
