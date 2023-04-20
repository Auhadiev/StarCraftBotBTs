package starcraft.bot.Nodes.NonLeafNode.Selector.impl;

import starcraft.bot.Nodes.NonLeafNode.Selector.Selector;

public class GlobalSelector extends Selector {

    public GlobalSelector() {
        this.nodes.add(new BuildBaseSelector());
    }

}
