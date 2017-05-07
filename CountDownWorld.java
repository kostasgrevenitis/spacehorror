import greenfoot.*;
import greenfoot.Actor;

/**
 * @author Konstantinos Grevenitis
 * @version 1.0
 */

public class CountDownWorld extends World
{    
    public CountDownWorld()
    {     
        super(640, 480, 1);
        
        Countdown countdown = new Countdown();
        addObject(countdown, 320, 250);
    }
}
