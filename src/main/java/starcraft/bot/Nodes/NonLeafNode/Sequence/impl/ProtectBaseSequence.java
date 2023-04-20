package starcraft.bot.Nodes.NonLeafNode.Sequence.impl;

import starcraft.bot.Nodes.LeafNode.Action.impl.ProtectBaseAction;
import starcraft.bot.Nodes.LeafNode.Action.impl.RunAwayAction;
import starcraft.bot.Nodes.LeafNode.Condition.impl.IsBaseUnderAttackCondition;
import starcraft.bot.Nodes.NonLeafNode.Sequence.Sequence;

public class ProtectBaseSequence extends Sequence {

    public ProtectBaseSequence() {
        nodes.add(new IsBaseUnderAttackCondition());
        nodes.add(new RunAwayAction());
        nodes.add(new ProtectBaseAction());
    }
}
