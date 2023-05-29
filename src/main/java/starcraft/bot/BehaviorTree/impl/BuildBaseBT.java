package starcraft.bot.BehaviorTree.impl;

import starcraft.bot.BehaviorTree.BehaviorTree;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.impl.BuildBaseRoot;

public class BuildBaseBT extends BehaviorTree {

    private BuildBaseBT() {
        this.root = new BuildBaseRoot();
    }

    private static class SingletonHolder {
        private final static BuildBaseBT instance = new BuildBaseBT();
    }

    public static BuildBaseBT getInstance() {
        return SingletonHolder.instance;
    }
}
