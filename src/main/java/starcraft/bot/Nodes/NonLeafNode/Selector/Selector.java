package starcraft.bot.Nodes.NonLeafNode.Selector;

import starcraft.bot.Nodes.Node;
import starcraft.bot.Nodes.NonLeafNode.NonLeafNode;

public abstract class Selector extends NonLeafNode {

    @Override
    public void start() {
        run();
        for(Node node : this.getNodes()){
            if(node.isRunning())
                continue;
            node.start();
            if(node.isSuccess()){
                this.succeed();
                return;
            }
        }
        this.fail();
    }

}
