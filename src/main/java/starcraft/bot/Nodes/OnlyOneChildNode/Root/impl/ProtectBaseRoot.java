package starcraft.bot.Nodes.OnlyOneChildNode.Root.impl;

import starcraft.bot.Nodes.NonLeafNode.Sequence.impl.ProtectBaseSequence;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.Root;

public class ProtectBaseRoot extends Root {

    public ProtectBaseRoot() {
        this.childNode = new ProtectBaseSequence();
    }
}
