package starcraft.bot.Utility;

import starcraft.bot.Bot.GameWrapper;
import bwapi.*;

import java.util.ArrayList;

public class GameUtility {

    private static final Game game = GameWrapper.getInstance().getGame();

    public static ArrayList<TilePosition> getEnemyPositions() {
        ArrayList<TilePosition> enemyBasesPositions = (ArrayList<TilePosition>) game.getStartLocations();
        enemyBasesPositions.remove(game.self().getStartLocation());
        return enemyBasesPositions;
    }

    public static int getMineralsCount() {
        return game.self().minerals();
    }

    public static int getGasCount() {
        return game.self().gas();
    }

    public static int getSupplyTotal() {
        return game.self().supplyTotal();
    }

    public static int getSupplyUsed() {
        return game.self().supplyUsed();
    }

    public static boolean isBuildingBuilt(UnitType buildingType) {
        Player player = game.self();
        for (Unit unit : player.getUnits()) {
            if (unit.getType() == buildingType)
                return true;
        }
        return false;
    }

    public static int getUnitsCount(UnitType unitType) {
        int count = 0;
        for (Unit unit : game.self().getUnits()) {
            if (unit.getType() == unitType)
                count++;
        }
        return count;
    }

    public static ArrayList<Unit> getUnits(UnitType unitType) {
        ArrayList<Unit> units = new ArrayList<>();
        game.self().getUnits().forEach(unit -> {
            if (unit.getType() == unitType) {
                units.add(unit);
            }
        });
        return units;
    }

    public static ArrayList<Unit> getBuildings() {
        ArrayList<Unit> buildings = new ArrayList<>();
        game.self().getUnits().forEach(unit -> {
            if (unit.getType().isBuilding()) {
                buildings.add(unit);
            }
        });
        return buildings;
    }

    public static Unit getNearEnemy(Unit unit) {
        for (Unit nearUnit : unit.getUnitsInRadius(30)) {
            if (nearUnit.getPlayer().isEnemy(game.self())) {
                return nearUnit;
            }
        }
        return null;
    }

    public static Position getPlayerBasePosition() {
        return game.self().getStartLocation().toPosition();
    }

    public static boolean isValidPosition(TilePosition tilePosition) {
        return tilePosition.isValid(game);
    }

    public static Position getPosition(TilePosition tilePosition) {
        return tilePosition.toPosition();
    }

    public static Player getEnemy() {
        return game.enemy();
    }
}
