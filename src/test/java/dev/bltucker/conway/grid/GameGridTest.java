package dev.bltucker.conway.grid;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.State;
import junit.framework.Assert;
import org.junit.Test;

public class GameGridTest {

    @Test
    public void gridInitializationTest(){
        
        GameGrid grid = new GameGrid(100,100);
        boolean initialized = grid.getWidth() == 100 && grid.getHeight() == 100;
        Assert.assertTrue(initialized);
    }
    
    @Test
    public void addCellToGrid(){
        
        GameGrid grid = new GameGrid(100, 100);
        
        grid.createCell(1, 3);
        
        Cell cell = grid.getCell(1, 3);
        
        Assert.assertTrue(cell.getState().equals(State.LIVE));
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void addCellOutsideOfGridRows(){
        
        GameGrid grid = new GameGrid(100,100);
        Cell cell = new Cell();
        
        grid.createCell(101, 0);        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void addCellOutsideOfGridColumns(){
        GameGrid grid = new GameGrid(100,100);
        Cell cell = new Cell();
        
        grid.createCell(0, 101);   
    }
    
    @Test
    public void killCell(){
        GameGrid grid = new GameGrid(10,10);
        grid.createCell(1, 1);
        
        Cell cell = grid.getCell(1, 1);
        
        Assert.assertEquals(State.LIVE, cell.getState());
        
        grid.killCell(1, 1);
        
        Assert.assertEquals(State.DEAD, cell.getState());
        
    }
    
}