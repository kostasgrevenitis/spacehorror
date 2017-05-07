import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (Roy Smith & Nolan Sherman) 
 * @version (V1.2)
 */
public class Explosion extends Mover
{
    public int countFrame;
    
    private GreenfootImage Explode0;
    private GreenfootImage Explode1;
    private GreenfootImage Explode2;
    
    public Explosion()
    {
        Explode0 = new GreenfootImage("spr_projectile_explode000.png");
        Explode1 = new GreenfootImage("spr_projectile_explode001.png");
        Explode2 = new GreenfootImage("spr_projectile_explode002.png");
    }
    
    public void Explode()
    {
        if(countFrame <= 10)
        {
            setImage(Explode0);
        }
        if(countFrame <= 20 && countFrame >= 10)
        {
            setImage(Explode1);
        }
        if(countFrame <= 30 && countFrame >= 20)
        {
            setImage(Explode2);
        }
        if(countFrame > 30)
        {
            getWorld().removeObject(this);
        }
    }
    
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        countFrame++;
        Explode();
    }    
}
