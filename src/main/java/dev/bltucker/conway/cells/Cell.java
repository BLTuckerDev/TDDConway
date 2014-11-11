package dev.bltucker.conway.cells;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public final class Cell {
    
    private final Set<Direction> neighbors = new HashSet<>();
    private final UUID identifier;
    
    public Cell(){
        this.identifier = UUID.randomUUID();
    }
      
    
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

    @Override
    public int hashCode() {
        return this.identifier.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cell other = (Cell) obj;
        return Objects.equals(this.identifier, other.identifier);
    }
}
