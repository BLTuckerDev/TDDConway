package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import static dev.bltucker.conway.cells.Direction.EAST;
import static dev.bltucker.conway.cells.Direction.NORTH;
import dev.bltucker.conway.cells.State;
import org.junit.Assert;
import org.junit.Test;

public class UnderPopulationRuleTest {
    
    @Test
    public void testUnderPopulationLessThanTwo(){
        Cell cell = new Cell();
        cell.setState(State.LIVE);
        Underpopulated condition = new Underpopulated();
        Assert.assertTrue(condition.checkCell(cell));        
    }
    
    
    @Test
    public void testUnderPopulationEqualToTwo(){
        Cell cell = new Cell();
        cell.setState(State.LIVE);
        cell.addNeighbor(NORTH);
        cell.addNeighbor(EAST);
        Underpopulated condition = new Underpopulated();
        Assert.assertFalse(condition.checkCell(cell));
    }
}
