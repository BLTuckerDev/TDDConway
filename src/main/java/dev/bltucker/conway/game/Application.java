package dev.bltucker.conway.game;

import dev.bltucker.conway.tickmethods.TickMethod;
import dev.bltucker.conway.tickmethods.TimedTick;
import dev.bltucker.conway.ui.CommandLine;
import dev.bltucker.conway.ui.SwingWindow;
import dev.bltucker.conway.ui.UserInterface;

public final class Application {

    
    //default to 100x100
    //use timed method
    //and swing window
    
    //java -jar conway {width} {height} {ui} {tickmethod}
    
    //eventually feed it an input file rather than the random seed that we currently have.
    
    public static void main(String[] args){
        
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
     
        TickMethod tickMethod = new TimedTick(1000);
        
        int width = 100;
        int height = 100;
     
        UserInterface ui = new SwingWindow(width, height);
        //UserInterface ui = new CommandLine();
        
        Game game = new Game(width, height, tickMethod, ui);
        game.randomInitialization();
        game.start();
        
        while(true){}
        
    }
}
