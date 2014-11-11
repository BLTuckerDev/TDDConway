package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.Direction;
import org.junit.Assert;
import org.junit.Test;

public class CellTest {

  
    @Test
    public void CellNeighborCountTest(){
        
        Cell cell = new Cell();
        cell.addNeighbor(Direction.TOP);
        cell.addNeighbor(Direction.DOWN);
        
        Assert.assertEquals(2, cell.getNeighborCount());
    }
    
    
    @Test(expected=IllegalArgumentException.class)
    public void DoNotAddANeighborTwiceTest(){
        
        Cell cell = new Cell();
        cell.addNeighbor(Direction.TOP);
        cell.addNeighbor(Direction.TOP);            
    }   
}