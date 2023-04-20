package starcraft.bot.Nodes.NonLeafNode.Sequence.impl;

import starcraft.bot.Nodes.LeafNode.Action.impl.MoveToBaseEntryAction;
import starcraft.bot.Nodes.LeafNode.Action.impl.TrainMarineAction;
import starcraft.bot.Nodes.LeafNode.Condition.impl.HasIdleMarines;
import starcraft.bot.Nodes.NonLeafNode.Sequence.Sequence;

public class TrainMarinesSequence extends Sequence {

    public TrainMarinesSequence() {
        nodes.add(new TrainMarineAction());
        nodes.add(new HasIdleMarines());
        nodes.add(new MoveToBaseEntryAction());
    }

}
