package dev.bltucker.conway.ui;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.State;
import dev.bltucker.conway.grid.GameGrid;
import java.io.Console;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CommandLine implements UserInterface {

    private final Console console;
    
    public CommandLine(){
        this.console = System.console();
    }
    
    @Override
    public void draw(GameGrid grid) {
        
        clearScreen();
        
        
        for(int i = grid.getHeight(); i > 0; i--){
            for(int j = 0; j < grid.getWidth(); j++){
                Cell cell = grid.getCell(j, i-1);
                drawCell(cell);
            }
            System.out.println(System.lineSeparator());
        }
    }
    
    
    public void drawCell(Cell cell){
    
        if(cell.getState().equals(State.LIVE)){
            System.out.print("1");
        } else {
            System.out.print("0");
        }
    }
    
    
    public void clearScreen(){
        for(int i = 0; i < 100; i++){
            System.out.print(System.lineSeparator());
        }
    }
}
