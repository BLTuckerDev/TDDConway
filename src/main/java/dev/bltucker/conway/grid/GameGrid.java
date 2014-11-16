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

    
    private void updateNeighbor(int neighborRow, int neighborColumn, Direction neighborDirection, Cell currentCell){
        
        if(this.isInBounds(neighborRow, neighborColumn)){
            Cell neighbor = this.getCell(neighborRow, neighborColumn);
            
            if(neighbor.getState().equals(State.LIVE)){
                currentCell.addNeighbor(neighborDirection);
                neighbor.addNeighbor(Direction.getOppositeDirection(neighborDirection));
            }
        }        
    }
    
    public void createCell(int x, int y) {
        
        if(!this.isInBounds(x, y)){
            throw new IllegalArgumentException("Out of bounds!");
        }
        
        Cell cell = this.getCell(x, y);        
        cell.setState(State.LIVE);
        
        
        updateNeighbor(x, y+1, Direction.TOP, cell);
        updateNeighbor(x+1, y, Direction.RIGHT, cell);
        updateNeighbor(x, y-1, Direction.DOWN, cell);
        updateNeighbor(x-1, y, Direction.LEFT, cell);
               
        
    }
    
    
    public void killCell(int x, int y){
        
        
        if(!this.isInBounds(x, y)){
            throw new IllegalArgumentException("Out of bounds!");
        }
        
        Cell cell = this.getCell(x, y);
        cell.setState(State.DEAD);
               
        
        //check for neighbors
        
        if(this.isInBounds(x, y+1)){
            //top neighbor
            Cell top = this.getCell(x, y+1);
            
            if(top.getState().equals(State.LIVE)){
                cell.removeNeighbor(Direction.TOP);
                top.removeNeighbor(Direction.DOWN);
            }
        }
        
        if(this.isInBounds(x + 1, y)){
            //right neighbor
            
            Cell right = this.getCell(x+1, y);
            
            if(right.getState().equals(State.LIVE)){
                cell.removeNeighbor(Direction.RIGHT);
                right.removeNeighbor(Direction.LEFT);
            }            
        }
        
        if(this.isInBounds(x, y -1)){
            //bottom neighbor
            
            Cell bottom = this.getCell(x, y-1);
            
            if(bottom.getState().equals(State.LIVE)){
                cell.removeNeighbor(Direction.DOWN);
                bottom.removeNeighbor(Direction.TOP);
            }
        
        }
        
        if(this.isInBounds(x-1, y)){
            //left neighbor
        
            Cell left = this.getCell(x-1, y);
            
            if(left.getState().equals(State.LIVE)){
                cell.removeNeighbor(Direction.LEFT);
                left.removeNeighbor(Direction.RIGHT);
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
