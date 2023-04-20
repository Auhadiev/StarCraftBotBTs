package starcraft.bot;

import bwapi.BWClient;
import starcraft.bot.Bot.Bot;

public class Application {

    public static void main(String[] args) {
        Bot bot = new Bot();
        bot.setBwClient(new BWClient(bot));
        bot.getBwClient().startGame();
    }
}
