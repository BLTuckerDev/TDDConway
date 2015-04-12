package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.Direction;
import dev.bltucker.conway.cells.State;
import junit.framework.Assert;
import org.junit.Test;

public class HomeostasisRuleTest {
    
    @Test
    public void WillSurviveToNextGeneration() {
        
        Cell cell = new Cell();
        cell.setState(State.LIVE);
        cell.addNeighbor(Direction.NORTH);
        cell.addNeighbor(Direction.SOUTH);
        
        Homeostasis alive = new Homeostasis();
        Assert.assertTrue(alive.checkCell(cell));
    }
    
    @Test
    public void WillNotSurviveToNextGeneration() {
        Cell cell = new Cell();
        cell.setState(State.LIVE);
        cell.addNeighbor(Direction.NORTH);
        
        Homeostasis dead = new Homeostasis();
        Assert.assertFalse(dead.checkCell(cell));
    }
}
