package starcraft.bot.Utility;

import bwapi.*;

import java.util.ArrayList;

public class WorkerUtility extends UnitUtility{

    public static boolean stop(Unit unit) {
        return false;
    }

    public static boolean build(UnitType buildingType) {
        for (Unit unit : game.self().getUnits()) {
            if (WorkerUtility.isWorker(unit)) {
                if (unit.isGatheringMinerals() || unit.isIdle()) {
                    return build(unit, buildingType);
                }
            }
        }
        return false;
    }

    public static TilePosition getPosition(Unit unit) {
        return unit.getTilePosition();
    }

    public static Unit getClosesEnemyUnit(Unit unit, UnitType enemyUnitType) {
        ArrayList<Unit> units = (ArrayList<Unit>) unit.getUnitsInRadius(10);
        for (Unit nearUnit : units) {

        }
        return unit.getUnitsInRadius(10).get(0);
    }

    public static void gatherMinerals(Unit worker) {
        worker.gather(getClosestMinerals(worker));
    }

    public static boolean gatherGas(Unit worker) {
        return false;
    }

    public static boolean build(Unit worker, UnitType buildingType) {
        if (buildingType.mineralPrice() > game.self().minerals() || buildingType.gasPrice() > game.self().gas()) {
            return false;
        }
        TilePosition desiredPos = game.self().getStartLocation();
        int maxBuildRange = 64;
        TilePosition position = game.getBuildLocation(game.self().getRace().getSupplyProvider(), desiredPos, maxBuildRange);
        return worker.build(buildingType, position);
    }

    public static boolean isWorker(Unit unit) {
        return unit.getType() == game.self().getRace().getWorker();
    }

    public static void gatherMineralsForAll() {
        for (Unit worker : getWorkers()) {
            if (worker.getLastCommand() != null)
                switch (worker.getLastCommand().getType()) {
                    case Build:
                        if (worker.isIdle())
                            gatherMinerals(worker);
                        else
                            continue;
                        break;
                }
            if (worker.isIdle())
                gatherMinerals(worker);
        }
    }

    private static ArrayList<Unit> getWorkers() {
        ArrayList<Unit> workers = new ArrayList<>();
        for (Unit unit : game.self().getUnits()) {
            if (unit.getType() == game.self().getRace().getWorker()) {
                workers.add(unit);
            }
        }
        return workers;
    }

    public static Unit getClosestMinerals(Unit myUnit){
        Unit mineral = null;
        int minDist = Integer.MAX_VALUE;
        for(Unit unit : game.getNeutralUnits()){
            if(unit.getType() != UnitType.Resource_Mineral_Field) continue;
            if(myUnit.getDistance(unit) < minDist){
                mineral = unit;
                minDist = myUnit.getDistance(unit);
            }
        }
        return mineral;
    }
}

