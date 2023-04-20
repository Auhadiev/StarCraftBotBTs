package starcraft.bot.Nodes.OnlyOneChildNode.Decorator.impl;

import starcraft.bot.Nodes.OnlyOneChildNode.Decorator.Decorator;

public class AlwaysSucceedDecorator extends Decorator {

    public AlwaysSucceedDecorator() {}

    @Override
    public void start() {
        super.start();
        succeed();
    }
}
