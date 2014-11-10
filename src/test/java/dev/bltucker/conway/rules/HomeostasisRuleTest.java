package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.Direction;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HomeostasisRuleTest {
    

    @Test
    public void WillSurviveToNextGeneration(){
        Cell cell = new Cell();
        cell.addNeighbor(Direction.TOP);
        cell.addNeighbor(Direction.DOWN);
        
        Homeostasis alive = new Homeostasis();
        Assert.assertTrue(        alive.checkCell(cell)      );
    }
    
    
    @Test
    public void WillNotSurviveToNextGeneration(){
        Cell cell = new Cell();
        cell.addNeighbor(Direction.TOP);
        
        Homeostasis dead = new Homeostasis();
       Assert.assertFalse(dead.checkCell(cell));
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}