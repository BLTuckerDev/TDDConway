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
        cell.addNeighbor(Direction.TOP);
        cell.addNeighbor(Direction.DOWN);
        cell.addNeighbor(Direction.RIGHT);
        cell.addNeighbor(Direction.LEFT);
        
        Overcrowded overcrowded = new Overcrowded();
        Assert.assertTrue(overcrowded.checkCell(cell));        
    }
    
    
    @Test
    public void CellIsNotOvercrowded(){
        
        Cell cell = new Cell();
        cell.setState(State.LIVE);
        cell.addNeighbor(Direction.TOP);
        cell.addNeighbor(Direction.RIGHT);
        cell.addNeighbor(Direction.DOWN);
        CellCondition condition = new Overcrowded();
        Assert.assertFalse(condition.checkCell(cell));
        
    }
    
    
}
