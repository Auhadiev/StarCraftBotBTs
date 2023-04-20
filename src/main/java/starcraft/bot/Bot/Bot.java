package starcraft.bot.Bot;

import bwem.BWEM;
import starcraft.bot.BehaviorTree.BehaviorTree;
import starcraft.bot.BehaviorTree.impl.AttackEnemyBaseBT;
import starcraft.bot.BehaviorTree.impl.GlobalBT;
import bwapi.*;
import starcraft.bot.BehaviorTree.impl.ProtectBaseBT;
import starcraft.bot.BehaviorTree.impl.ScoutBT;

import java.util.ArrayList;
import java.util.List;

public class Bot extends DefaultBWListener {
    private BWClient bwClient;
    private Game game;
    private Player player;
    private BWEM bwem;
    private final List<BehaviorTree> behaviorTreeList = new ArrayList<>();
    private final BlackBoard blackBoard = BlackBoard.getInstance();

    @Override
    public void onStart() {
        game = bwClient.getGame();
        bwem = new BWEM(game);
        bwem.initialize();

        GameWrapper gameWrapper = GameWrapper.getInstance();
        gameWrapper.setGame(game);

        BwemWrapper bwemWrapper = BwemWrapper.getInstance();
        bwemWrapper.setBwem(bwem);

        behaviorTreeList.add(GlobalBT.getInstance());
        behaviorTreeList.add(ScoutBT.getInstance());
        behaviorTreeList.add(ProtectBaseBT.getInstance());
        behaviorTreeList.add(AttackEnemyBaseBT.getInstance());

        game.enableFlag(Flag.UserInput);
        game.setLocalSpeed(10);
        this.player = game.self();

        game.sendText(String.valueOf(player.completedUnitCount()));
    }

    @Override
    public void onFrame() {

        behaviorTreeList.forEach(behaviorTree -> {
            if (!behaviorTree.isRunning())
                behaviorTree.runTree();
        });

    }

    @Override
    public void onUnitDestroy(Unit unit){
        if (unit.getType() == UnitType.Terran_Marine) {
            blackBoard.getProtectMarines().remove(unit);
            blackBoard.getAttackMarines().remove(unit);
            if (blackBoard.getScoutUnit().get() == unit) {
                blackBoard.getScoutUnit().set(null);
            }
        }
    }

    @Override
    public void onUnitComplete(Unit unit) {
        switch (unit.getType()) {
            case Terran_Supply_Depot:
                blackBoard.getBuildingsUnderConstruction().remove(UnitType.Terran_Supply_Depot);
                break;
            case Terran_Barracks:
                blackBoard.getBuildingsUnderConstruction().remove(UnitType.Terran_Barracks);
                break;
            case Terran_SCV:
                blackBoard.getTrainingUnits().remove(UnitType.Terran_SCV);
                break;
            case Terran_Marine:
                blackBoard.getTrainingUnits().remove(UnitType.Terran_Marine);
                blackBoard.getIdleMarines().add(unit);
                break;
        }
    }

    public BWClient getBwClient() {
        return bwClient;
    }

    public void setBwClient(BWClient bwClient) {
        this.bwClient = bwClient;
    }
}
