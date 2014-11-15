package dev.bltucker.conway.game;

import dev.bltucker.conway.tickmethods.TickMethod;
import dev.bltucker.conway.tickmethods.TimedTick;
import dev.bltucker.conway.ui.CommandLine;
import dev.bltucker.conway.ui.UserInterface;

public final class Application {

    
    public static void main(String[] args){
     
        TickMethod tickMethod = new TimedTick(10000);
        UserInterface ui = new CommandLine();
        Game game = new Game(100, 100, tickMethod, ui);
        
    }
}
