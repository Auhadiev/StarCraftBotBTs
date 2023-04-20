package starcraft.bot.Nodes.NonLeafNode.Sequence.impl;

import starcraft.bot.Nodes.LeafNode.Action.impl.CheckEnemiesBuildingsAction;
import starcraft.bot.Nodes.LeafNode.Action.impl.ScoutEnemyBasesAction;
import starcraft.bot.Nodes.LeafNode.Action.impl.SetBaseEntryPositionAction;
import starcraft.bot.Nodes.NonLeafNode.Sequence.Sequence;

public class ScoutSequence extends Sequence {

    public ScoutSequence() {
        nodes.add(new ScoutEnemyBasesAction());
        nodes.add(new SetBaseEntryPositionAction());
        nodes.add(new CheckEnemiesBuildingsAction());
    }

}
