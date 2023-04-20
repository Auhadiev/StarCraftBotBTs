package starcraft.bot.BehaviorTree;

import starcraft.bot.Nodes.OnlyOneChildNode.Root.Root;

public abstract class BehaviorTree {

    protected Root root;

    public void runTree() {
        if (isRunning())
            return;
        root.start();
    }

    public void stop() {
        root.reset();
    }

    public boolean isRunning() {
        return root.isRunning();
    }
}
