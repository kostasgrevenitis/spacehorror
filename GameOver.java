import greenfoot.*;

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
