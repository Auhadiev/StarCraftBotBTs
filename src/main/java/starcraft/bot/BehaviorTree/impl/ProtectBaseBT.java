package starcraft.bot.BehaviorTree.impl;

import starcraft.bot.BehaviorTree.BehaviorTree;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.impl.ProtectBaseRoot;

public class ProtectBaseBT extends BehaviorTree {

    private ProtectBaseBT() {
        this.root = new ProtectBaseRoot();
    }

    private static class SingletonHolder {
        private static final ProtectBaseBT instance = new ProtectBaseBT();
    }

    public static ProtectBaseBT getInstance() {
        return ProtectBaseBT.SingletonHolder.instance;
    }

}
