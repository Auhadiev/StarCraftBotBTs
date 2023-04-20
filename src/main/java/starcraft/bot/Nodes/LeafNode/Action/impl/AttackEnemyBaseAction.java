package starcraft.bot.Nodes.LeafNode.Action.impl;

import bwapi.Position;
import bwapi.Unit;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Action.Action;
import starcraft.bot.Utility.GameUtility;
import starcraft.bot.Utility.UnitUtility;

import java.util.ArrayList;

public class AttackEnemyBaseAction extends Action {
    @Override
    public void start() {
        run();
        BlackBoard blackBoard = BlackBoard.getInstance();
        ArrayList<Unit> marines = blackBoard.getAttackMarines();
        Unit enemyBuilding = blackBoard.getEnemiesBuildings().get(GameUtility.getEnemy()).get(0);
        Position target = blackBoard.getEnemiesBuildingsPositions().get(enemyBuilding);
        if (marines != null) {
            marines.forEach(marine -> {
                if (UnitUtility.getClosestEnemyUnit(marine) == null) {
                    UnitUtility.move(marine, target);
                }
            });
        }
        succeed();
    }
}
