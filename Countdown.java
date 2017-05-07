import greenfoot.*;  

/**
 * @author Konstantinos Grevenitis
 * @version 1.0
 */

public class Countdown extends Actor
{
    public int countdownFrame;
    
    private GreenfootImage countdownImage1;
    private GreenfootImage countdownImage2;
    private GreenfootImage countdownImage3;
    
    public Countdown()
    {
        countdownImage1 = new GreenfootImage("countdown_1.png");
        countdownImage2 = new GreenfootImage("countdown_2.png");
        countdownImage3 = new GreenfootImage("countdown_3.png");
    }
    
    public void act() 
    {
       countdownFrame++;
       countdown();
    }
    
    public void countdown()
    {
        if(countdownFrame >= 0 && countdownFrame < 60)
        {
            setImage(countdownImage3);
        }
        if(countdownFrame > 60 && countdownFrame < 120)
        {
            setImage(countdownImage2);
        }
        if(countdownFrame > 120 && countdownFrame < 180)
        {
            setImage(countdownImage1);
        }
        if(countdownFrame > 180)
        {
            Greenfoot.setWorld(new StarshipWorld());
        }
    }

}
