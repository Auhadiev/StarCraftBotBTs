package starcraft.bot.Nodes.OnlyOneChildNode.Root.impl;

import starcraft.bot.Nodes.NonLeafNode.Sequence.impl.DefaultSequence;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.Root;

public class DefaultRoot extends Root {

    public DefaultRoot() {
        this.childNode = new DefaultSequence();
    }

}
