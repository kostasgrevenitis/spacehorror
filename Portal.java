import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Actor
{
    private long startTime = System.currentTimeMillis();
    private int countFrame = 0;
    
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turnOnPortal();
    }
    
    private void turnOnPortal()
    {   
        countFrames();
        if(countFrame <= 0)
        {
           setImage(new GreenfootImage("portal0.png"));
        }
        if(countFrame > 0 && countFrame <= 10)
        {
            setImage(new GreenfootImage("portal1.png"));
        }
        if(countFrame > 10 && countFrame <= 20)
        {
            setImage(new GreenfootImage("portal2.png"));
        }
        if(countFrame > 20 && countFrame <= 30)
        {
            setImage(new GreenfootImage("portal3.png"));
        }
        if(countFrame > 30 && countFrame <= 40)
        {
            setImage(new GreenfootImage("portal4.png"));
        }
        if(countFrame > 40 && countFrame <= 50)
        {
            setImage(new GreenfootImage("portal5.png"));
        }
        if(countFrame > 50 && countFrame <= 60)
        {
            setImage(new GreenfootImage("portal6.png"));
        }
        if(countFrame > 60 && countFrame <= 70)
        {
            setImage(new GreenfootImage("portal7.png"));
        }
        if(countFrame > 70)
        {
            setImage(new GreenfootImage("portal8.png"));
            if(isTouching(Player.class))
            {
                 Greenfoot.setWorld(new StarshipWorld());
            }
        }
    }
    
    public void countFrames()
    {
         if(getWorld().getObjects(Enemy.class).size()== 0)
           {
              countFrame++;
           }
    }
}

