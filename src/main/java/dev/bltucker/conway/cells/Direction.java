package dev.bltucker.conway.cells;

public enum Direction {
    TOP, RIGHT, DOWN, LEFT;
    
    
    public static Direction getOppositeDirection(Direction direction){
        
        switch(direction){
            case TOP:
                return DOWN;
            case RIGHT:
                return LEFT;
            case DOWN:
                return TOP;
            case LEFT:
                return RIGHT;
        }
        
        throw new IllegalArgumentException("Invalid direction");        
    }
    
}
