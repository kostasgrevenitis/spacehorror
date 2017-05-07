import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Egg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Egg extends Actor
{
    
    public long startHatch = System.currentTimeMillis();
    /**
     * Act - do whatever the Egg wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    public void act() 
    {
        health();
        hatch();
        hatchAnimation();
    }    
    
    private void hatch(){
        long nowHatch = System.currentTimeMillis();
        
        if(nowHatch - startHatch > 2000){
            int spiderNumber = Greenfoot.getRandomNumber(7)+3;
            
            for(int i = 0; i < spiderNumber; i++){
                Enemy spider = new Enemy();
                getWorld().addObject(spider, getX(), getY());
            }
            
            getWorld().removeObject(this);
        }
         
    }
    
    void health(){
        if(isTouching(Projectile.class)){
            removeTouching(Projectile.class);//remove the projectile
            getWorld().removeObject(this);//remove the enemy
        
        }
    }
    
    private void hatchAnimation()
    {
        long hatchNow = System.currentTimeMillis();
        if(hatchNow - startHatch < 200)
        {
           setImage(new GreenfootImage("creep_egg0.png"));
        }
        if(hatchNow - startHatch > 400)
        {
            setImage(new GreenfootImage("creep_egg1.png"));
        }
        if(hatchNow - startHatch > 600)
        {
            setImage(new GreenfootImage("creep_egg2.png"));
        }
        if(hatchNow - startHatch > 800)
        {
            setImage(new GreenfootImage("creep_egg3.png"));
        }
        if(hatchNow - startHatch > 1000)
        {
            setImage(new GreenfootImage("creep_egg4.png"));
        }
        if(hatchNow - startHatch > 1200)
        {
            setImage(new GreenfootImage("creep_egg5.png"));
        }
        if(hatchNow - startHatch > 1400)
        {
            setImage(new GreenfootImage("creep_egg6.png"));
        }
        if(hatchNow - startHatch > 1600)
        {
            setImage(new GreenfootImage("creep_egg7.png"));
        }
        if(hatchNow - startHatch > 1800)
        {
            setImage(new GreenfootImage("creep_egg8.png"));
        }
    }
}
