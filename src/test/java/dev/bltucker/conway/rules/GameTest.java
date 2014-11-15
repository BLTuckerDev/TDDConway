package dev.bltucker.conway.rules;

import dev.bltucker.conway.game.Game;
import dev.bltucker.conway.tickmethods.TickMethod;
import dev.bltucker.conway.tickmethods.TimedTick;
import dev.bltucker.conway.ui.CommandLine;
import dev.bltucker.conway.ui.UserInterface;
import junit.framework.Assert;
import org.junit.Test;



public class GameTest {

    @Test
    public void TestGameInitialization(){
        
        TickMethod tickMethod = new TimedTick(10000);
        UserInterface ui = new CommandLine();
        Game game = new Game(100, 100, tickMethod, ui);
        
        Assert.assertEquals(100, game.getWidth());
        Assert.assertEquals(100, game.getHeight());
        Assert.assertEquals(game.getTickMethod(), tickMethod);
    }
}