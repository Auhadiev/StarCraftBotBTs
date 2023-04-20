package starcraft.bot.Nodes.LeafNode.Condition.impl;

import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Condition.Condition;

public class HasIdleMarines extends Condition {

    @Override
    public void start() {
        run();
        if (BlackBoard.getInstance().getIdleMarines().size() > 0)
            succeed();
        else
            fail();
    }

}
