package dev.bltucker.conway.game;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.grid.GameGrid;
import dev.bltucker.conway.rules.CellCondition;
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
    private final GameGrid grid;
    
    private final CellCondition overCrowded = new Overcrowded();
    private final CellCondition reproduction = new Reproduction();
    private final CellCondition underPopulation = new Underpopulated();
    
    
    public Game(int width, int height, TickMethod tickmethod, UserInterface ui){
        this.grid = new GameGrid(width, height);
        this.tickMethod = tickmethod;
        this.ui = ui;
    }
    
    
    public void start(){
        tickMethod.addObserver(this);
        tickMethod.start();
        ui.draw(grid);
    }
    

    @Override
    public void update(Observable o, Object arg) {
        for(int i = 0; i < grid.getWidth(); i++){
            for(int j = 0; j < grid.getHeight(); j++){
                Cell cell = grid.getCell(i, j);
                applyRules(cell, i, j);
            }
        }        
        ui.draw(grid);
    }

    
    private void applyRules(Cell cell, int row, int column){
        if(overCrowded.checkCell(cell)){
            grid.killCell(row, column);
        } else if(reproduction.checkCell(cell)){
            grid.createCell(row, column);
        } else if(underPopulation.checkCell(cell)){
            grid.killCell( row, column);
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

        Random random = new Random(System.currentTimeMillis());
        
        for(int i = 0; i < grid.getWidth(); i++){
            for(int j = 0; j < grid.getHeight(); j++){
                if(random.nextBoolean()){
                    grid.createCell( i, j);
                }                               
            }
        }
    }
}
