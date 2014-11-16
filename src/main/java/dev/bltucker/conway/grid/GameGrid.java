package dev.bltucker.conway.grid;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.Direction;
import dev.bltucker.conway.cells.State;

public class GameGrid {

    private final Cell grid[][];
        
    public GameGrid(int width, int height){
        this.grid = new Cell[width][height];
            
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                grid[i][j] = new Cell();
            }
        }
    }

    
    public int getWidth() {
        return this.grid.length;
    }

    
    public int getHeight() {
        return this.grid[0].length;
    }    
    
    
    public void createCell(int x, int y) {
        this.toggleCellState(x, y);
    }

    
    public void killCell(int x, int y){
        this.toggleCellState(x, y);
    }
    
    
    private void toggleCellState(int x, int y){
        if(!this.isInBounds(x, y)){
            throw new IllegalArgumentException("Out of bounds!");
        }
        
        Cell cell = this.getCell(x, y);
        cell.toggleState();

        
        updateNeighbor(x, y+1, Direction.NORTH, cell);
        updateNeighbor(x+1, y+1, Direction.NORTH_EAST, cell);
        updateNeighbor(x+1, y, Direction.EAST, cell);
        updateNeighbor(x+1, y-1, Direction.SOUTH_EAST, cell);
        updateNeighbor(x, y-1, Direction.SOUTH, cell);
        updateNeighbor(x-1, y-1, Direction.SOUTH_WEST, cell);
        updateNeighbor(x-1, y, Direction.WEST, cell);
        updateNeighbor(x-1, y+1, Direction.NORTH_WEST, cell);
    }
     
    
    private void updateNeighbor(int neighborRow, int neighborColumn, Direction neighborDirection, Cell currentCell){
        
        if(this.isInBounds(neighborRow, neighborColumn)){
            Cell neighbor = this.getCell(neighborRow, neighborColumn);
            
            if(currentCell.getState().equals(State.LIVE)){
                neighbor.addNeighbor(Direction.getOppositeDirection(neighborDirection));
                
                if(neighbor.getState().equals(State.LIVE)){
                    currentCell.addNeighbor(neighborDirection);
                }
                
                
            } else {
                neighbor.removeLiveNeighbor(Direction.getOppositeDirection(neighborDirection));
            }
        }        
    }
    
    
    public Cell getCell(int x, int y) {
        
        if(!this.isInBounds(x, y)){
            throw new IllegalArgumentException("Out of bounds!");
        }

        return this.grid[x][y];        
    }
    
    
    private boolean isInBounds(int x, int y){
        
        if(x < 0 || y < 0){
            return false;
        }
                
        return x < this.grid.length && y < this.grid[0].length;
    }    
}
