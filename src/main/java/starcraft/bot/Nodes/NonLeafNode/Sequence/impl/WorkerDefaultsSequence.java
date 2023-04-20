package starcraft.bot.Nodes.NonLeafNode.Sequence.impl;

import starcraft.bot.Nodes.LeafNode.Action.impl.GatherMineralsAction;
import starcraft.bot.Nodes.LeafNode.Action.impl.SetRequiredWorkersCountAction;
import starcraft.bot.Nodes.LeafNode.Action.impl.TrainWorkerAction;
import starcraft.bot.Nodes.LeafNode.Condition.impl.IsNotWorkersEnoughCondition;
import starcraft.bot.Nodes.NonLeafNode.Sequence.Sequence;

public class WorkerDefaultsSequence extends Sequence {

    public WorkerDefaultsSequence() {
        nodes.add(new SetRequiredWorkersCountAction());
        nodes.add(new GatherMineralsAction());
        nodes.add(new IsNotWorkersEnoughCondition());
        nodes.add(new TrainWorkerAction());
    }

}
