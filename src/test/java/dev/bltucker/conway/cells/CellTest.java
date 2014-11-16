package dev.bltucker.conway.cells;

import org.junit.Assert;
import org.junit.Test;

public class CellTest {
  
    @Test
    public void CellNeighborCountTest(){
        
        Cell cell = new Cell();
        cell.addNeighbor(Direction.NORTH);
        cell.addNeighbor(Direction.SOUTH);
        
        Assert.assertEquals(2, cell.getLiveNeighborCount());
    }
    
    
//    @Test(expected=IllegalArgumentException.class)
    public void DoNotAddANeighborTwiceTest(){
        
        Cell cell = new Cell();
        cell.addNeighbor(Direction.NORTH);
        cell.addNeighbor(Direction.NORTH);            
    }
    
    
    @Test
    public void RemoveNeighborTest(){
        
        Cell cell = new Cell();
        cell.addNeighbor(Direction.NORTH);
        cell.addNeighbor(Direction.SOUTH);
        cell.removeLiveNeighbor(Direction.NORTH);
        
        Assert.assertEquals(1, cell.getLiveNeighborCount());
    }
    
    @Test
    public void toggleStateTest(){
        Cell cell = new Cell();
        
        cell.setState(State.LIVE);
        cell.toggleState();
        
        Assert.assertEquals(State.DEAD, cell.getState());
        
    }
    
}