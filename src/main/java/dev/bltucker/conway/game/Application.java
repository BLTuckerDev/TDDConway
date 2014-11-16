package dev.bltucker.conway.game;

import dev.bltucker.conway.tickmethods.TickMethod;
import dev.bltucker.conway.tickmethods.TimedTick;
import dev.bltucker.conway.ui.CommandLine;
import dev.bltucker.conway.ui.SwingWindow;
import dev.bltucker.conway.ui.UserInterface;

public final class Application {

    
    public static void main(String[] args){
        
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
     
        TickMethod tickMethod = new TimedTick(1000);
        UserInterface ui = new CommandLine();
     
        ui = new SwingWindow(100, 100);
        
        Game game = new Game(100, 100, tickMethod, ui);
        game.randomInitialization();
        game.start();
        
        while(true){}
        
    }
}
