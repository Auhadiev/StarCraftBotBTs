package starcraft.bot.Nodes.NonLeafNode.Sequence;

import starcraft.bot.Nodes.Node;
import starcraft.bot.Nodes.NonLeafNode.NonLeafNode;

public abstract class Sequence extends NonLeafNode {

    @Override
    public void start() {
        run();
        for(Node node : this.nodes){
            if(node.isRunning())
                continue;
            node.start();
            if(node.isFailure()) {
                this.fail();
                return;
            }
        }
        this.succeed();
    }

}
