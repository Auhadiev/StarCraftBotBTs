package starcraft.bot.Utility;

import bwapi.*;
import bwem.BWEM;
import starcraft.bot.Bot.BlackBoard;
import starcraft.bot.Bot.BwemWrapper;
import starcraft.bot.Bot.GameWrapper;

import java.util.List;

public class UnitUtility {

    protected static final Game game = GameWrapper.getInstance().getGame();

    protected static final BWEM bwem = BwemWrapper.getInstance().getBwem();

    public static TilePosition getTilePosition(Unit unit) {
        return unit.getTilePosition();
    }

    public static boolean isBuildable(TilePosition tilePosition) {
        return bwem.getMap().getData().getTile(tilePosition).isBuildable();
    }

    public static void scoutEnemyBases(Unit unit){
        for(TilePosition tile : game.getStartLocations()){
            if(!game.isExplored(tile)){
                Position pos = tile.toPosition();
                UnitCommand command = unit.getLastCommand();
                if (command == null) {
                    unit.move(pos);
                    return;
                }
                if(command.getTargetPosition().equals(pos))
                    return;
                unit.move(pos);
                return;
            }
        }
        unit.move(BlackBoard.getInstance().getEntryBasePosition().get().toPosition());
    }

    public static boolean isIdle(Unit unit) {
        return unit.isIdle();
    }

    public static void move(Unit unit, Position position) {
        UnitCommand lastCommand = unit.getLastCommand();
        if (lastCommand != null)
            if (lastCommand.getType() == UnitCommandType.Move && lastCommand.getTargetPosition().equals(position)) {
                return;
            }
        unit.move(position);
    }

    public static List<Unit> getClosestUnits(Unit unit) {
        return unit.getUnitsInRadius(60);
    }

    public static boolean isEnemy(Unit unit) {
        return game.self().isEnemy(unit.getPlayer());
    }

    public static boolean isBuilding(Unit unit) {
        return unit.getType().isBuilding();
    }

    public static boolean isMoving(Unit unit) {
        return !unit.getType().isBuilding();
    }

    public static Unit getClosestEnemyUnit(Unit unit) {
        for (Unit nearUnit : unit.getUnitsInRadius(30)) {
            if (nearUnit.getPlayer().isEnemy(game.self())) {
                return nearUnit;
            }
        }
        return null;
    }
}
