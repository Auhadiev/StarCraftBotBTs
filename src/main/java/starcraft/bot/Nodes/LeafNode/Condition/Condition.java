package starcraft.bot.Nodes.LeafNode.Condition;

import starcraft.bot.Nodes.Node;

public abstract class Condition extends Node {

    @Override
    public void reset() {
        idle();
    }
}
