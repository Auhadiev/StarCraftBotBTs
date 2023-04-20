package starcraft.bot.Bot;

import bwem.BWEM;

public class BwemWrapper {

    private BWEM bwem;

    private BwemWrapper(){}

    public static class SingletonHolder {
        private final static BwemWrapper instance = new BwemWrapper();
    }

    public static BwemWrapper getInstance() {
        return SingletonHolder.instance;
    }

    public void setBwem(BWEM bwem) {
        this.bwem = bwem;
    }

    public BWEM getBwem() {
        return bwem;
    }
}
