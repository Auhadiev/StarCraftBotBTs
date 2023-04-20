package starcraft.bot.Bot;

import bwapi.Game;

public class GameWrapper {

    private Game game;

    private GameWrapper(){}

    public static class SingletonHolder {
        private final static GameWrapper instance = new GameWrapper();
    }

    public static GameWrapper getInstance() {
        return SingletonHolder.instance;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
