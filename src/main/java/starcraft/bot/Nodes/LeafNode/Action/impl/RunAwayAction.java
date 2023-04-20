package starcraft.bot.Nodes.LeafNode.Action.impl;

import bwapi.Position;
import bwapi.Unit;
import bwapi.UnitType;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Nodes.LeafNode.Action.Action;
import starcraft.bot.Utility.GameUtility;

import java.util.ArrayList;

public class RunAwayAction extends Action {
    @Override
    public void start() {
        run();
        ArrayList<Unit> workers = GameUtility.getUnits(UnitType.Terran_SCV);
        System.out.println(BlackBoard.getInstance().getEnemyInBase());
        workers.forEach(worker -> {
            if (GameUtility.getNearEnemy(worker) != null) {
                if (BlackBoard.getInstance().getEntryBasePosition().get() != null)
                    worker.move(BlackBoard.getInstance().getEntryBasePosition().get().toPosition());
                else {
                    Position workerPosition = worker.getPosition();
                    if (GameUtility.isValidPosition(workerPosition.add(GameUtility.getPlayerBasePosition()).toTilePosition()))
                        worker.move(workerPosition.add(GameUtility.getPlayerBasePosition()));
                    else if (GameUtility.isValidPosition(workerPosition.divide(20).toTilePosition())) {
                        worker.move(workerPosition.divide(20));
                    }
                }
            }
        });
    }
}
