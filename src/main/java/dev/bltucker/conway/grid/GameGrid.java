package dev.bltucker.conway.grid;

import dev.bltucker.conway.cells.Cell;

public class GameGrid {

    private final Cell grid[][];
        
    public GameGrid(int width, int height){
        this.grid = new Cell[width][height];
    }

    
    public int getWidth() {
        return this.grid.length;
    }

    
    public int getHeight() {
        return this.grid[0].length;
    }    

    
    public void addCell(Cell cell, int x, int y) {
        
        if(!this.isInBounds(x, y)){
            throw new IllegalArgumentException("Out of bounds!");
        }
        
        this.grid[x][y] = cell;        
    }

    
    public Cell getCell(int x, int y) {
        
        if(!this.isInBounds(x, y)){
            throw new IllegalArgumentException("Out of bounds!");
        }

        return this.grid[x][y];        
    }
    
    
    private boolean isInBounds(int x, int y){
        return x < this.grid.length && y < this.grid[0].length;
    }    
}
