package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.Direction;
import dev.bltucker.conway.cells.State;
import org.junit.Assert;
import org.junit.Test;

public class OvercrowdedRuleTest {

    @Test
    public void CellIsOvercrowded(){
        
        Cell cell = new Cell();
        cell.setState(State.LIVE);
        cell.addNeighbor(Direction.NORTH);
        cell.addNeighbor(Direction.SOUTH);
        cell.addNeighbor(Direction.EAST);
        cell.addNeighbor(Direction.WEST);
        
        Overcrowded overcrowded = new Overcrowded();
        Assert.assertTrue(overcrowded.checkCell(cell));        
    }
    
    
    @Test
    public void CellIsNotOvercrowded(){
        
        Cell cell = new Cell();
        cell.setState(State.LIVE);
        cell.addNeighbor(Direction.NORTH);
        cell.addNeighbor(Direction.EAST);
        cell.addNeighbor(Direction.SOUTH);
        CellCondition condition = new Overcrowded();
        Assert.assertFalse(condition.checkCell(cell));
        
    }
    
    
}
