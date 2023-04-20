package starcraft.bot.Nodes.NonLeafNode.Sequence.impl;

import starcraft.bot.Nodes.LeafNode.Action.impl.BuildSupplyDepotAction;
import starcraft.bot.Nodes.LeafNode.Condition.impl.IsNotSupplyEnoughCondition;
import starcraft.bot.Nodes.NonLeafNode.Sequence.Sequence;

public class CheckSupplySequence extends Sequence {

    public CheckSupplySequence() {
        nodes.add(new IsNotSupplyEnoughCondition());
        nodes.add(new BuildSupplyDepotAction());
    }

}
