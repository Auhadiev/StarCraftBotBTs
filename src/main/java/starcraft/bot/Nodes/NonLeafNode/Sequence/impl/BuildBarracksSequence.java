package starcraft.bot.Nodes.NonLeafNode.Sequence.impl;

import starcraft.bot.Nodes.LeafNode.Action.impl.BuildBarracksAction;
import starcraft.bot.Nodes.LeafNode.Condition.impl.IsNotBarracksBuiltCondition;
import starcraft.bot.Nodes.NonLeafNode.Sequence.Sequence;

public class BuildBarracksSequence extends Sequence {

    public BuildBarracksSequence() {
        nodes.add(new IsNotBarracksBuiltCondition());
        nodes.add(new BuildBarracksAction());
    }

}
