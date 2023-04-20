package starcraft.bot.BehaviorTree.impl;

import starcraft.bot.BehaviorTree.BehaviorTree;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.impl.AttackEnemyBaseRoot;

public class AttackEnemyBaseBT extends BehaviorTree {

    private AttackEnemyBaseBT() {
        this.root = new AttackEnemyBaseRoot();
    }

    private static class SingletonHolder {
        private final static AttackEnemyBaseBT instance = new AttackEnemyBaseBT();
    }

    public static AttackEnemyBaseBT getInstance() {
        return AttackEnemyBaseBT.SingletonHolder.instance;
    }

}
