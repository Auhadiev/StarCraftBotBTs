package starcraft.bot.Nodes.NonLeafNode;

import starcraft.bot.Nodes.Node;

import java.util.ArrayList;

public abstract class NonLeafNode extends Node {

    protected ArrayList<Node> nodes;

    protected NonLeafNode() {
        this.nodes = new ArrayList<>();
    }

    @Override
    public void reset() {
        nodes.forEach(Node::reset);
        idle();
    }

    public void addNode(Node node){
        this.nodes.add(node);
    }

    public ArrayList<Node> getNodes(){
        return nodes;
    }
}
