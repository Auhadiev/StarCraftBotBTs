package starcraft.bot.Nodes.OnlyOneChildNode;

import starcraft.bot.Nodes.Node;

public abstract class OnlyOneChildNode extends Node {

    protected Node childNode;

    public void setChildNode(Node childNode) {
        this.childNode = childNode;
    }

    @Override
    public void reset() {
        childNode.reset();
        idle();
    }

    @Override
    public void start() {
        run();
        if (!childNode.isRunning())
            childNode.start();
        if (childNode.isSuccess())
            succeed();
        else
            fail();
    }
}
