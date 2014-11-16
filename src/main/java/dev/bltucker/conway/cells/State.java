package dev.bltucker.conway.cells;

public enum State {
    LIVE,
    DEAD;
    
    public static State getOppositeState(State currentState){
        
        switch(currentState){
            case LIVE:
                return DEAD;
            case DEAD:
                return LIVE;
        }
        
        throw new IllegalArgumentException("Invalid state argument");        
    }  
}
