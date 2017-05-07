import greenfoot.*; 

public class Projectile extends Actor
{
    int deathCounter = 30;
    
    public Projectile(int direction){
        setRotation(direction);
    }
    /**
     * Act - do whatever the projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move(10); // Add your action code here.
       deathCounter --;
       
       if(deathCounter < 0){
           getWorld().removeObject(this);
       }
    }    
}
