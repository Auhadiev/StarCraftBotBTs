package starcraft.bot.Nodes.OnlyOneChildNode.Root.impl;

import starcraft.bot.Nodes.NonLeafNode.Selector.impl.BuildBaseSelector;
import starcraft.bot.Nodes.OnlyOneChildNode.Root.Root;

public class BuildBaseRoot extends Root {

    public BuildBaseRoot() {
        this.childNode = new BuildBaseSelector();
    }

}
