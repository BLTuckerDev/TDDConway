package dev.bltucker.conway.cells;

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
    
    
    @Test
    public void RemoveNeighborTest(){
        
        Cell cell = new Cell();
        cell.addNeighbor(Direction.TOP);
        cell.addNeighbor(Direction.DOWN);
        cell.removeNeighbor(Direction.TOP);
        
        Assert.assertEquals(1, cell.getNeighborCount());
    }
    
    @Test
    public void toggleStateTest(){
        Cell cell = new Cell();
        
        cell.setState(State.LIVE);
        cell.toggleState();
        
        Assert.assertEquals(State.DEAD, cell.getState());
        
    }
    
}