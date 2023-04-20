package starcraft.bot.Nodes.NonLeafNode.Sequence.impl;

import starcraft.bot.Nodes.NonLeafNode.Sequence.Sequence;
import starcraft.bot.Nodes.OnlyOneChildNode.Decorator.Decorator;
import starcraft.bot.Nodes.OnlyOneChildNode.Decorator.impl.AlwaysSucceedDecorator;

public class DefaultSequence extends Sequence {

    public DefaultSequence() {
        Decorator alwaysSucceedDecorator1 = new AlwaysSucceedDecorator();
        alwaysSucceedDecorator1.setChildNode(new WorkerDefaultsSequence());

        Decorator alwaysSucceedDecorator2 = new AlwaysSucceedDecorator();
        alwaysSucceedDecorator2.setChildNode(new CheckSupplySequence());

        nodes.add(alwaysSucceedDecorator1);
        nodes.add(alwaysSucceedDecorator2);
    }

}
