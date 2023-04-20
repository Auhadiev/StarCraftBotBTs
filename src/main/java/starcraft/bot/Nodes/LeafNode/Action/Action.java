package starcraft.bot.Nodes.LeafNode.Action;

import starcraft.bot.Nodes.Node;

public abstract class Action extends Node {

    @Override
    public void reset() {
        idle();
    }
}
