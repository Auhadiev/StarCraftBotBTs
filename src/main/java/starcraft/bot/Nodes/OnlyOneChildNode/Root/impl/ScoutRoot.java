package starcraft.bot.Nodes.OnlyOneChildNode.Root.impl;

import starcraft.bot.Nodes.NonLeafNode.Sequence.impl.ScoutSequence;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.Root;

public class ScoutRoot extends Root {

    public ScoutRoot() {
        this.childNode = new ScoutSequence();
    }

}
