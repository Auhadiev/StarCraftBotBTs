package starcraft.bot.Nodes.NonLeafNode.Selector.impl;

import starcraft.bot.Nodes.NonLeafNode.Selector.Selector;
import starcraft.bot.Nodes.NonLeafNode.Sequence.impl.BuildBarracksSequence;
import starcraft.bot.Nodes.NonLeafNode.Sequence.impl.TrainMarinesSequence;

public class BuildBaseSelector extends Selector {

    public BuildBaseSelector() {
        nodes.add(new BuildBarracksSequence());
        nodes.add(new TrainMarinesSequence());
    }

}
