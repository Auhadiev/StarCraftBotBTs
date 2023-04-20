package starcraft.bot.Nodes.LeafNode.Action.impl;

import bwapi.Unit;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Action.Action;
import starcraft.bot.Utility.UnitUtility;

import java.util.ArrayList;

public class CheckEnemiesBuildingsAction extends Action {
    @Override
    public void start() {
        run();
        BlackBoard blackBoard = BlackBoard.getInstance();
        Unit scoutUnit = blackBoard.getScoutUnit().get();
        if (scoutUnit != null) {
            ArrayList<Unit> closestUnits = (ArrayList<Unit>) UnitUtility.getClosestUnits(scoutUnit);
            closestUnits.forEach(unit -> {
                if (UnitUtility.isEnemy(unit) && UnitUtility.isBuilding(unit)) {
                    if (blackBoard.getEnemiesBuildings().get(unit.getPlayer()) != null){
                        if (!blackBoard.getEnemiesBuildings().get(unit.getPlayer()).contains(unit)) {
                            blackBoard.getEnemiesBuildings().get(unit.getPlayer()).add(unit);
                            blackBoard.getEnemiesBuildingsPositions().put(unit, unit.getPosition());
                        }
                    } else {
                        blackBoard.getEnemiesBuildings().put(unit.getPlayer(), new ArrayList<>());
                        blackBoard.getEnemiesBuildings().get(unit.getPlayer()).add(unit);
                        blackBoard.getEnemiesBuildingsPositions().put(unit, unit.getPosition());
                    }
                }
            });
        }
        succeed();
    }
}
