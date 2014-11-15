package dev.bltucker.conway.grid;

import dev.bltucker.conway.cells.Cell;
import dev.bltucker.conway.cells.Direction;
import dev.bltucker.conway.cells.State;

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

    
    public void CreateCell(Cell cell, int x, int y) {
        
        if(!this.isInBounds(x, y)){
            throw new IllegalArgumentException("Out of bounds!");
        }
        
        cell.setState(State.LIVE);
               
        
        //check for neighbors
        
        if(this.isInBounds(x, y+1)){
            //top neighbor
            Cell top = this.getCell(x, y+1);
            
            if(top.getState().equals(State.LIVE)){
                cell.addNeighbor(Direction.TOP);
                top.addNeighbor(Direction.DOWN);
            }
        }
        
        if(this.isInBounds(x + 1, y)){
            //right neighbor
            
            Cell right = this.getCell(x+1, y);
            
            if(right.getState().equals(State.LIVE)){
                cell.addNeighbor(Direction.RIGHT);
                right.addNeighbor(Direction.LEFT);
            }            
        }
        
        if(this.isInBounds(x, y -1)){
            //bottom neighbor
            
            Cell bottom = this.getCell(x, y-1);
            
            if(bottom.getState().equals(State.LIVE)){
                cell.addNeighbor(Direction.DOWN);
                bottom.addNeighbor(Direction.TOP);
            }
        
        }
        
        if(this.isInBounds(x-1, y)){
            //left neighbor
        
            Cell left = this.getCell(x-1, y);
            
            if(left.getState().equals(State.LIVE)){
                cell.addNeighbor(Direction.LEFT);
                left.addNeighbor(Direction.RIGHT);
            }            
        }
        
    }

    
    
    public void killCell(Cell cell, int x, int y){
        
        
        if(!this.isInBounds(x, y)){
            throw new IllegalArgumentException("Out of bounds!");
        }
        
        cell.setState(State.DEAD);
               
        
        //check for neighbors
        
        if(this.isInBounds(x, y+1)){
            //top neighbor
            Cell top = this.getCell(x, y+1);
            
            if(top.getState().equals(State.LIVE)){
                cell.RemoveNeighbor(Direction.TOP);
                top.RemoveNeighbor(Direction.DOWN);
            }
        }
        
        if(this.isInBounds(x + 1, y)){
            //right neighbor
            
            Cell right = this.getCell(x+1, y);
            
            if(right.getState().equals(State.LIVE)){
                cell.RemoveNeighbor(Direction.RIGHT);
                right.RemoveNeighbor(Direction.LEFT);
            }            
        }
        
        if(this.isInBounds(x, y -1)){
            //bottom neighbor
            
            Cell bottom = this.getCell(x, y-1);
            
            if(bottom.getState().equals(State.LIVE)){
                cell.RemoveNeighbor(Direction.DOWN);
                bottom.RemoveNeighbor(Direction.TOP);
            }
        
        }
        
        if(this.isInBounds(x-1, y)){
            //left neighbor
        
            Cell left = this.getCell(x-1, y);
            
            if(left.getState().equals(State.LIVE)){
                cell.RemoveNeighbor(Direction.LEFT);
                left.RemoveNeighbor(Direction.RIGHT);
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
        return x < this.grid.length && y < this.grid[0].length;
    }    
}
