package dev.bltucker.conway.game;

import dev.bltucker.conway.tickmethods.TickMethod;
import dev.bltucker.conway.tickmethods.TimedTick;
import dev.bltucker.conway.ui.CommandLine;
import dev.bltucker.conway.ui.UserInterface;

public final class Application {

    
    public static void main(String[] args){
     
        TickMethod tickMethod = new TimedTick(5000);
        UserInterface ui = new CommandLine();
        Game game = new Game(10, 10, tickMethod, ui);
        game.randomInitialization();
        game.start();
        
        while(true){}
        
    }
}
