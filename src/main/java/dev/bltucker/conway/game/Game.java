package dev.bltucker.conway.game;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.grid.GameGrid;
import dev.bltucker.conway.rules.CellCondition;
import dev.bltucker.conway.rules.Homeostasis;
import dev.bltucker.conway.rules.Overcrowded;
import dev.bltucker.conway.rules.Reproduction;
import dev.bltucker.conway.rules.Underpopulated;
import dev.bltucker.conway.tickmethods.TickMethod;
import dev.bltucker.conway.tickmethods.TimedTick;
import dev.bltucker.conway.ui.UserInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public final class Game implements Observer{
    
    private final TickMethod tickMethod;
    private final UserInterface ui;
    private final GameGrid grid;
    
    private CellCondition homeoStasis = new Homeostasis();
    private CellCondition overCrowded = new Overcrowded();
    private CellCondition reproduction = new Reproduction();
    private CellCondition underPopulation = new Underpopulated();
    
    
    public Game(int width, int height, TickMethod tickmethod, UserInterface ui){
        
        this.grid = new GameGrid(100, 100);
        this.tickMethod = tickmethod;
        this.ui = ui;
        
        
    }
    
    
    public void start(){
        tickMethod.addObserver(this);
        tickMethod.start();
        
        
    }
    

    @Override
    public void update(Observable o, Object arg) {

        System.out.println("Do Tick");
        
        for(int i = 0; i < grid.getWidth(); i++){
            for(int j = 0; j < grid.getHeight(); j++){
                
                Cell cell = grid.getCell(i, j);
                applyRules(cell, j, j);
            }
        }
        
        
        
    }

    
    private void applyRules(Cell cell, int row, int column){
        
        //set each cell's state
        //add or remove neighbors as needed.
        
        if(homeoStasis.checkCell(cell)){
            //we do nothing
        } else if(overCrowded.checkCell(cell)){
            //kill the cell
            grid.killCell(cell, row, column);
        } else if(reproduction.checkCell(cell)){
            //create the cell
            grid.CreateCell(cell, row, column);
        } else if(underPopulation.checkCell(cell)){
            //kill the cell
            grid.killCell(cell, row, column);
        }
        
    }
    
    
    
    public TickMethod getTickMethod() {
        return tickMethod;
    }

    
    public int getWidth(){
        return this.grid.getWidth();
    }
    
    
    public int getHeight(){
        return this.grid.getHeight();
    }
}
