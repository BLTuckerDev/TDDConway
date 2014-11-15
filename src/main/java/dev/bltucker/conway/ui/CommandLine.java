package dev.bltucker.conway.ui;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.State;
import dev.bltucker.conway.grid.GameGrid;
import java.io.Console;

public final class CommandLine implements UserInterface {

    private final Console console;
    
    public CommandLine(){
        this.console = System.console();
    }
    
    @Override
    public void draw(GameGrid grid) {
        
        clearScreen();
       
        for(int i = 0; i < grid.getWidth(); i++){
            for(int j = 0; j < grid.getHeight(); j++){                
                Cell cell = grid.getCell(i, j);
                drawCell(cell);
            }            
            System.out.print(System.lineSeparator());
        }
    }
    
    
    public void drawCell(Cell cell){
    
        if(cell.getState().equals(State.LIVE)){
            System.out.print("O");
        } else {
            System.out.print("X");
        }
    }
    
    
    public void clearScreen(){
        for(int i = 0; i < 100; i++){
            System.out.print(System.lineSeparator());
        }
    }
}
