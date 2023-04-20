package starcraft.bot.Bot;

import bwapi.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class BlackBoard {

    private enum Key{
        BUILDING_UNDER_CONSTRUCTION,
        REQUIRED_WORKERS_COUNT,
        TRAINING_UNITS,
        IDLE_MARINES,
        PROTECT_MARINES,
        ATTACK_MARINES,
        BASE_ENTRY_POSITION,
        SCOUT_UNIT,
        ENEMIES_BUILDINGS,
        ENEMY_IN_BASE,
        ENEMIES_BUILDINGS_POSITIONS
    }

    private final HashMap<Key, Object> blackBoard = new HashMap<>();

    private BlackBoard() {
        blackBoard.put(Key.BUILDING_UNDER_CONSTRUCTION, new ArrayList<UnitType>());
        blackBoard.put(Key.REQUIRED_WORKERS_COUNT, new SimpleIntegerProperty(8));
        blackBoard.put(Key.TRAINING_UNITS, new ArrayList<UnitType>());
        blackBoard.put(Key.IDLE_MARINES, new ArrayList<>());
        blackBoard.put(Key.ATTACK_MARINES, new ArrayList<>());
        blackBoard.put(Key.PROTECT_MARINES, new ArrayList<>());
        blackBoard.put(Key.BASE_ENTRY_POSITION, new SimpleObjectProperty<TilePosition>(null));
        blackBoard.put(Key.SCOUT_UNIT, new SimpleObjectProperty<Unit>(null));
        blackBoard.put(Key.ENEMIES_BUILDINGS, new HashMap<Player, ArrayList<Unit>>());
        blackBoard.put(Key.ENEMY_IN_BASE, new SimpleObjectProperty<Unit>());
        blackBoard.put(Key.ENEMIES_BUILDINGS_POSITIONS, new HashMap<Unit, Position>());
    }

    private static class InstanceHolder {
        private final static BlackBoard instance = new BlackBoard();
    }

    public static BlackBoard getInstance() {
        return InstanceHolder.instance;
    }

    public ArrayList<UnitType> getBuildingsUnderConstruction() {
        return (ArrayList<UnitType>) blackBoard.get(Key.BUILDING_UNDER_CONSTRUCTION);
    }

    public IntegerProperty getRequiredWorkersCount() {
        return (SimpleIntegerProperty) blackBoard.get(Key.REQUIRED_WORKERS_COUNT);
    }

    public ArrayList<UnitType> getTrainingUnits() {
        return (ArrayList<UnitType>) blackBoard.get(Key.TRAINING_UNITS);
    }

    public ArrayList<Unit> getIdleMarines() {
        return (ArrayList<Unit>) blackBoard.get(Key.IDLE_MARINES);
    }

    public SimpleObjectProperty<TilePosition> getEntryBasePosition() {
        return (SimpleObjectProperty<TilePosition>) blackBoard.get(Key.BASE_ENTRY_POSITION);
    }

    public SimpleObjectProperty<Unit> getScoutUnit() {
        return (SimpleObjectProperty<Unit>) blackBoard.get(Key.SCOUT_UNIT);
    }

    public HashMap<Player, ArrayList<Unit>> getEnemiesBuildings() {
        return (HashMap<Player, ArrayList<Unit>>) blackBoard.get(Key.ENEMIES_BUILDINGS);
    }

    public ArrayList<Unit> getAttackMarines() {
        return (ArrayList<Unit>) blackBoard.get(Key.ATTACK_MARINES);
    }

    public ArrayList<Unit> getProtectMarines() {
        return (ArrayList<Unit>) blackBoard.get(Key.PROTECT_MARINES);
    }

    public SimpleObjectProperty<Unit> getEnemyInBase() {
        return (SimpleObjectProperty<Unit>) blackBoard.get(Key.ENEMY_IN_BASE);
    }

    public HashMap<Unit, Position> getEnemiesBuildingsPositions() {
        return (HashMap<Unit, Position>) blackBoard.get(Key.ENEMIES_BUILDINGS_POSITIONS);
    }
}
