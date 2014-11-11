package dev.bltucker.conway.cells;

import java.util.HashSet;
import java.util.Set;

public class Cell {
    
    private final Set<Direction> neighbors = new HashSet<>();

    public void addNeighbor(Direction direction) {
        
        if(!neighbors.add(direction)){
            throw new IllegalArgumentException("The cell already has a neighbor in that direction!");
        }
    }

    public int getNeighborCount() {        
        return this.neighbors.size();
    }
    
    
    public void RemoveNeighbor(Direction direction){
        this.neighbors.remove(direction);
    }
}
