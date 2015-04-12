package dev.bltucker.conway.cells;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public final class Cell {
    
    private final Set<Direction> neighbors = new HashSet<>();
    private final UUID identifier;
    private State state = State.DEAD;
    
    public Cell(){
        this.identifier = UUID.randomUUID();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public void toggleState(){
        this.setState(State.getOppositeState(this.getState()));
    }
    
    public boolean addNeighbor(Direction direction) {
        return neighbors.add(direction);
    }

    public int getLiveNeighborCount() {        
        return this.neighbors.size();
    }
        
    public void removeLiveNeighbor(Direction direction){
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
