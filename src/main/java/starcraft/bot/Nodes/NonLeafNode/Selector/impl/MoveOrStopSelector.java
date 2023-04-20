package starcraft.bot.Nodes.NonLeafNode.Selector.impl;

import starcraft.bot.Nodes.LeafNode.Action.impl.AttackEnemyBaseAction;
import starcraft.bot.Nodes.LeafNode.Action.impl.AttackEnemyUnitAction;
import starcraft.bot.Nodes.NonLeafNode.Selector.Selector;

public class MoveOrStopSelector extends Selector {

    public MoveOrStopSelector() {
        nodes.add(new AttackEnemyUnitAction());
        nodes.add(new AttackEnemyBaseAction());
    }
}
