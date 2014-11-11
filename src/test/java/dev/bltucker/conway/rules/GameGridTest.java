package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.grid.GameGrid;
import junit.framework.Assert;
import org.junit.Test;

public class GameGridTest {

    @Test
    public void GridInitializationTest(){
        
        GameGrid grid = new GameGrid(100,100);
        boolean initialized = grid.getWidth() == 100 && grid.getHeight() == 100;
        Assert.assertTrue(initialized);
    }
    
    @Test
    public void AddCellToGrid(){
        
        GameGrid grid = new GameGrid(100, 100);
        Cell cell = new Cell();
        
        grid.addCell(cell, 1, 3);
        
        Assert.assertEquals(cell, grid.getCell(1,3));        
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void AddCellOutsideOfGridRows(){
        
        GameGrid grid = new GameGrid(100,100);
        Cell cell = new Cell();
        
        grid.addCell(cell, 101, 0);        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void AddCellOutsideOfGridColumns(){
        GameGrid grid = new GameGrid(100,100);
        Cell cell = new Cell();
        
        grid.addCell(cell, 0, 101);   
    }
    
}