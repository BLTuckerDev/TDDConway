package dev.bltucker.conway.tickmethods;

import java.util.Timer;
import java.util.TimerTask;

public final class TimedTick extends TickMethod {

    private Timer timer;
    private final long period;
    
    public TimedTick(long period){
        this.period = period;
    }
    
    
    @Override
    public void start() {
        this.timer = new Timer("TickMethodTimer");
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                TimedTick.this.setChanged();
               TimedTick.this.notifyObservers();
            }
        }, 0, period);
        
    }
}
