package dev.bltucker.conway.game;

import com.sun.glass.ui.EventLoop;
import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.State;
import dev.bltucker.conway.grid.GameGrid;
import dev.bltucker.conway.rules.CellCondition;
import dev.bltucker.conway.rules.Homeostasis;
import dev.bltucker.conway.rules.Overcrowded;
import dev.bltucker.conway.rules.Reproduction;
import dev.bltucker.conway.rules.Underpopulated;
import dev.bltucker.conway.tickmethods.TickMethod;
import dev.bltucker.conway.ui.UserInterface;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public final class Game implements Observer{
    
    private final TickMethod tickMethod;
    private final UserInterface ui;
    private  GameGrid grid;
    
    private final CellCondition overCrowded = new Overcrowded();
    private final CellCondition reproduction = new Reproduction();
    private final CellCondition underPopulation = new Underpopulated();
    private final CellCondition homeostasis = new Homeostasis();
    
    
    public Game(int width, int height, TickMethod tickmethod, UserInterface ui){
        this.grid = new GameGrid(width, height);
        this.tickMethod = tickmethod;
        this.ui = ui;
    }
    
    
    public void start(){
        tickMethod.addObserver(this);
        ui.draw(grid);
        tickMethod.start();
    }
    

    @Override
    public void update(Observable o, Object arg) {
        
        GameGrid nextGenGrid = new GameGrid(this.getWidth(), this.getHeight());
        
        for(int i = 0; i < grid.getWidth(); i++){
            for(int j = 0; j < grid.getHeight(); j++){
                Cell cell = grid.getCell(i, j);
                applyRules(cell, i, j, nextGenGrid);
            }
        }     
        
        this.grid = nextGenGrid;
        ui.draw(nextGenGrid);
    }

    
    private void applyRules(Cell cell, int row, int column, GameGrid nextGenerationGrid){
             
        if(homeostasis.checkCell(cell)){
            //he lives
            nextGenerationGrid.createCell(row, column);
        }else if(overCrowded.checkCell(cell)){
            //grid.killCell(row, column);
        } else if(reproduction.checkCell(cell)){
            nextGenerationGrid.createCell(row, column);
           // grid.createCell(row, column);
        } else if(underPopulation.checkCell(cell)){
         //   grid.killCell( row, column);
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

    void randomInitialization() {

//        grid.createCell(1, 0);
//        grid.createCell(0, 0);
//        grid.createCell(0,1);
        
        grid.createCell(3, 2);
        grid.createCell(3, 3);
        grid.createCell(3, 4);
//        Random random = new Random(System.currentTimeMillis());
//        
//        for(int i = 0; i < grid.getWidth(); i++){
//            for(int j = 0; j < grid.getHeight(); j++){
//                if(random.nextBoolean()){
//                    grid.createCell( i, j);
//                }                               
//            }
//        }
    }
}
