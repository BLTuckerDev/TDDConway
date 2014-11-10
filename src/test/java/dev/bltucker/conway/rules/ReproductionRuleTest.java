package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.Direction;
import org.junit.Assert;
import org.junit.Test;

public class ReproductionRuleTest {

    
    @Test
    public void WillReproduce(){
        Cell cell = new Cell();
        cell.addNeighbor(Direction.TOP);
        cell.addNeighbor(Direction.RIGHT);
        cell.addNeighbor(Direction.DOWN);
        
        CellCondition condition = new Reproduction();
        Assert.assertTrue(condition.checkCell(cell));    
        
    }
    
    
    @Test
    public void WillNotReproduce(){
        Cell cell = new Cell();
        cell.addNeighbor(Direction.TOP);
        
        CellCondition condition = new Reproduction();
        Assert.assertFalse(condition.checkCell(cell));
    }
    
}
