import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
public class GreenfootTimer extends Actor {
    static int duration;
    long startTime = 0;
    boolean finished = false;

    public Timer(int duration) {
        this.duration = duration;
        setImage(new GreenfootImage(1, 1));
    }

    public void act() {
        if(finished) return;
        while(duration > 0) {


        }
        // if(startTime == 0) startTime = System.currentTimeMillis();
        // int diff = (int)(System.currentTimeMillis() - startTime);
        // if(diff < duration) {
        //     String text = "";
        //     int val = (255*diff)/duration;
        //     if(val > 255) val = 255;
        //     if(val < 0) val = 0;
        //     int gVal = (val*val)/255;
        //     Color color = new Color(255 - val, gVal, 0);
        //     setImage(new GreenfootImage(getText(duration-diff), fontSize, color, new Color(0, 0, 0, 0)));
        // } else {
        //     finished = true;
        //     setImage(new GreenfootImage(getText(0), fontSize, Color.GREEN, new Color(0, 0, 0, 0)));
        // }
    }
}

