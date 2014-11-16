package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.Direction;
import org.junit.Assert;
import org.junit.Test;

public class ReproductionRuleTest {

    
    @Test
    public void WillReproduce(){
        Cell cell = new Cell();
        cell.addNeighbor(Direction.NORTH);
        cell.addNeighbor(Direction.EAST);
        cell.addNeighbor(Direction.SOUTH);
        
        CellCondition condition = new Reproduction();
        Assert.assertTrue(condition.checkCell(cell));    
        
    }
    
    
    @Test
    public void WillNotReproduce(){
        Cell cell = new Cell();
        cell.addNeighbor(Direction.NORTH);
        
        CellCondition condition = new Reproduction();
        Assert.assertFalse(condition.checkCell(cell));
    }
    
}
