package dev.bltucker.conway.cells;

public enum Direction {
    NORTH,
    NORTH_EAST,
    EAST,
    SOUTH_EAST,
    SOUTH,
    SOUTH_WEST,
    WEST,
    NORTH_WEST;
    
    
    public static Direction getOppositeDirection(Direction direction){
        
        switch(direction){
            case NORTH:
                return SOUTH;
            case EAST:
                return WEST;
            case SOUTH:
                return NORTH;
            case WEST:
                return EAST;
            case NORTH_EAST:
                return SOUTH_WEST;
            case SOUTH_EAST:
                return NORTH_WEST;
            case SOUTH_WEST:
                return NORTH_EAST;
            case NORTH_WEST:
                return SOUTH_EAST;                
        }
        
        throw new IllegalArgumentException("Invalid direction");        
    }
    
}
