package starcraft.bot.Nodes.LeafNode.Link;

import starcraft.bot.Nodes.Node;

public abstract class Link extends Node {
    @Override
    public void reset() {
        idle();
    }
}
