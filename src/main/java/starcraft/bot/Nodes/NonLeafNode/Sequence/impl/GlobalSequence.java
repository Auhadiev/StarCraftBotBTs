package starcraft.bot.Nodes.NonLeafNode.Sequence.impl;

import starcraft.bot.Nodes.LeafNode.Link.impl.DefaultBTLink;
import starcraft.bot.Nodes.NonLeafNode.Sequence.Sequence;
import starcraft.bot.Nodes.NonLeafNode.Selector.impl.GlobalSelector;

public class GlobalSequence extends Sequence {

    public GlobalSequence() {
        nodes.add(new DefaultBTLink());
        nodes.add(new GlobalSelector());
    }

}
