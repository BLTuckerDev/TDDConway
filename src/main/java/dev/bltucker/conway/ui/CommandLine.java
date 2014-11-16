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
       
        for(int i = grid.getWidth(); i > 0 ; i--){
            for(int j = 0; j < grid.getHeight(); j++){                
                Cell cell = grid.getCell(i-1, j);
                drawCell(cell);
            }            
            System.out.print(System.lineSeparator());
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
        try {
            Runtime.getRuntime().exec("clear");
//        for(int i = 0; i < 100; i++){
//            System.out.print(System.lineSeparator());
//        }
        } catch (IOException ex) {
            Logger.getLogger(CommandLine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
