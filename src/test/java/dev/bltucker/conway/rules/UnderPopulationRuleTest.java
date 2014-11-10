package dev.bltucker.conway.rules;

import dev.bltucker.conway.cells.Cell;
import static dev.bltucker.conway.cells.Direction.RIGHT;
import static dev.bltucker.conway.cells.Direction.TOP;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnderPopulationRuleTest {
    
    
    public UnderPopulationRuleTest() {
    }
           
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
                
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testUnderPopulationLessThanTwo(){
        Cell cell = new Cell();
        Underpopulated condition = new Underpopulated();
        Assert.assertTrue(condition.checkCell(cell));        
    }
    
    
    @Test
    public void testUnderPopulationEqualToTwo(){
        Cell cell = new Cell();
        cell.addNeighbor(TOP);
        cell.addNeighbor(RIGHT);
        Underpopulated condition = new Underpopulated();
        Assert.assertFalse(condition.checkCell(cell));
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
