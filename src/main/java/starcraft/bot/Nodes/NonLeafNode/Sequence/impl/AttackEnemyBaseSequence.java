package starcraft.bot.Nodes.NonLeafNode.Sequence.impl;

import starcraft.bot.Nodes.LeafNode.Action.impl.SetAttackMarinesAction;
import starcraft.bot.Nodes.LeafNode.Condition.impl.IsReadyToAttackCondition;
import starcraft.bot.Nodes.NonLeafNode.Selector.impl.MoveOrStopSelector;
import starcraft.bot.Nodes.NonLeafNode.Sequence.Sequence;

public class AttackEnemyBaseSequence extends Sequence {

    public AttackEnemyBaseSequence() {
        nodes.add(new IsReadyToAttackCondition());
        nodes.add(new SetAttackMarinesAction());
        nodes.add(new MoveOrStopSelector());
    }
}
