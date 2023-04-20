package starcraft.bot.Nodes.OnlyOneChildNode.Root.impl;

import starcraft.bot.Nodes.NonLeafNode.Sequence.impl.GlobalSequence;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.Root;

public class GlobalRoot extends Root {

    public GlobalRoot() {
        this.childNode = new GlobalSequence();
    }

}
