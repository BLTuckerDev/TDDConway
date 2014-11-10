package dev.bltucker.conway.cells;

public class Cell {
    
    private int neighbors = 0;

    public void addNeighbor(Direction direction) {
        this.neighbors++;
    }

    public int getNeighborCount() {        
        return this.neighbors;
    }
}
