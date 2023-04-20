package starcraft.bot.Nodes.OnlyOneChildNode.Root.impl;

import starcraft.bot.Nodes.NonLeafNode.Sequence.impl.AttackEnemyBaseSequence;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.Root;

public class AttackEnemyBaseRoot extends Root {

    public AttackEnemyBaseRoot() {
        this.childNode = new AttackEnemyBaseSequence();
    }
}
