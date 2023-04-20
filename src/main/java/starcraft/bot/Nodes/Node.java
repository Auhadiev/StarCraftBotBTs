package starcraft.bot.Nodes;

public abstract class Node {

    public enum NodeState{
        Success,
        Failure,
        Running,
        Error,
        Idle
    };

    protected NodeState state = NodeState.Idle;

    public abstract void reset();

    public abstract void start();

    protected void run(){
//        System.out.println(this + " run");
        this.state = NodeState.Running;
    }

    protected void succeed(){
        this.state = NodeState.Success;
    }

    protected void fail(){
        this.state = NodeState.Failure;
    }

    protected void error(){
        this.state = NodeState.Error;
    }

    protected void idle() {
        this.state = NodeState.Idle;
    }

    public boolean isSuccess(){
        return this.state.equals(NodeState.Success);
    }

    public boolean isFailure(){
        return this.state.equals(NodeState.Failure);
    }

    public boolean isRunning(){
        return this.state.equals(NodeState.Running);
    }

    public boolean isError(){
        return this.state.equals(NodeState.Error);
    }

    public boolean isIdle() {
        return this.state.equals(NodeState.Idle);
    }

    public NodeState getState(){
        return this.state;
    }

}
