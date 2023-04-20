package starcraft.bot.Nodes.LeafNode.Link.impl;

import starcraft.bot.BehaviorTree.impl.DefaultBT;
import starcraft.bot.Nodes.LeafNode.Link.Link;

public class DefaultBTLink extends Link {

    @Override
    public void start() {
        run();
        if (!DefaultBT.getInstance().isRunning()) {
            DefaultBT.getInstance().runTree();
        }
        succeed();
    }
}
