import greenfoot.*;

/**
 * @author Konstantinos Grevenitis
 * @version 1.0
 */
public class GameOver extends Actor
{
    public void act() 
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new CountDownWorld());
        }
    }    
}
