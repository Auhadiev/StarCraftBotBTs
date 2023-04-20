package starcraft.bot.Utility;

import bwapi.*;
import starcraft.bot.Bot.GameWrapper;

public class BuildingUtility {

    private static final Game game = GameWrapper.getInstance().getGame();

    public static boolean trainUnit(UnitType unitType) {
        switch (unitType) {
            case Terran_SCV:
                return trainWorker();
            case Terran_Marine:
                return trainMarine();
        }
        return false;
    }

    public static boolean research(Unit building, TechType upgrade) {
        return building.research(upgrade);
    }

    public static boolean moveBuild(Unit building, TilePosition tilePosition) {
        return building.move(tilePosition.toPosition());
    }

    private static boolean trainWorker(){
        Player player = game.self();
        Unit depot = null;
        for(Unit u : player.getUnits()){
            if(u.getType() == player.getRace().getResourceDepot()){
                depot = u;
                if(!depot.isTraining() && player.minerals() >= player.getRace().getWorker().mineralPrice()){
                    return depot.train(player.getRace().getWorker());
                }
                break;
            }
        }
        return false;
    }

    private static boolean trainMarine() {
        Player player = game.self();
        Unit barracks = null;
        for(Unit u : player.getUnits()){
            if(u.getType() == UnitType.Terran_Barracks){
                barracks = u;
                if(!barracks.isTraining() && player.minerals() >= player.getRace().getWorker().mineralPrice()){
                    return barracks.train(UnitType.Terran_Marine);
                }
                break;
            }
        }
        return false;
    }
}
