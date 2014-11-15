package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.State;
import dev.bltucker.conway.grid.GameGrid;
import dev.bltucker.conway.ui.CommandLine;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class CommandLineTest {

    private GameGrid grid;
    
    @Before
    public void SetupGameGrid(){
        grid = new GameGrid(10, 10);
        Random random = new Random(System.currentTimeMillis());
        
        for(int i = 0; i < grid.getWidth(); i++){
            for(int j = 0; j < grid.getHeight(); j++){
                Cell cell = new Cell();
                
                if(random.nextBoolean()){
                    cell.setState(State.LIVE);
                }                               
                
                grid.addCell(cell, i, j);
            }
        }
        
        
    }
    
    @Test
    public void TestCommandLinePrint(){
        CommandLine cl = new CommandLine();
        cl.draw(grid);
    }
}
