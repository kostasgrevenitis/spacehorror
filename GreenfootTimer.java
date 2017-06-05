import greenfoot.*;

public class GreenfootTimer extends Actor {
    int duration;
    boolean finished = false;
    long startTime = 0;

    public GreenfootTimer(int duration) {
        this.duration = duration;
        setImage(new GreenfootImage(1, 1));
    }

    public void act() {
        if(this.finished) return;
        
        if(startTime == 0) {
            startTime = System.currentTimeMillis();
        } 
    
         if(System.currentTimeMillis() <= (startTime + this.duration)) {
            long newTime = (startTime + this.duration) - System.currentTimeMillis();
            String t = String.format( "%.0f",(newTime/1000.0));
            ((Text) (getWorld().getObjects(Text.class).get(4))).setText("Χρόνος : " + t + " δευτερόλεπτα");
        }else{
            ((Text) (getWorld().getObjects(Text.class).get(4))).setText("Χρόνος : 0 δευτερόλεπτα");
            this.finished = true;
        }
    }
}

