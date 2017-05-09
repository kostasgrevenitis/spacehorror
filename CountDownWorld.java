import greenfoot.*;
import greenfoot.Actor;

public class CountDownWorld extends World {
    public CountDownWorld() {
        super(640, 480, 1);

        Countdown countdown = new Countdown();
        addObject(countdown, 320, 250);
    }
}
