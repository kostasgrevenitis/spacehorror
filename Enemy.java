import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (Roy Smith & Nolan Sherman) 
 * @version (V1.2)
 */
public class Enemy extends Mover
{
    public int countFrame = 1;//Variable used for animation
    public int hitEnemy = 0; //how many times the projectile hits enemy
    public int health = 2;  //how many shots it takes to kill the enemy

    private GreenfootImage Blood;
    
    private long startTime;
    private long startTime2;
    
    /**
     * Start the enemy with the follow attributes
     */
    public Enemy()
    {
     Blood = new GreenfootImage("spr_blood_0.png");
     startTime = System.currentTimeMillis();
     startTime2 = System.currentTimeMillis();
     
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement(); //method used to move the enemey
        turnAtEdge(); //method that forces the enemy to turn 90 degrees when it reaches the edge of the screen
        attackPlayer(); //method that forces the enemy to chase the player when the player is within 200 pixels
        health();
        layEgg();
        clusterBreed();
    }
    
    /**
     * Return the current stability of the enemy.(if it goes down to zero, it dies)
     */
    public void health()
    {
        if(isTouching(Projectile.class))
        {
            removeTouching(Projectile.class);
            getWorld().addObject(new Explosion(), getX(), getY());
            hitEnemy++;
            if(hitEnemy == health)
            {
                getWorld().removeObject(this);
            }
        }
    }
    
    /**
     * When the enemy dies
     */
    public void death()
    {
        getWorld().removeObject(this);
        // /**When an Enemy is killed increment the Kill Counter by 1
        // */
        //Player.deadEnemies = Player.deadEnemies +1;
        //stability = Greenfoot.getRandomNumber(300);
        //return;
    }
    
    /**
     * This turns the enemy 180 degrees away from the edge of the screen to keep them from getting stuck
     */
    public void turnAtEdge()
    {
        if(isAtEdge())
        {
         turn(90);   
        }
    }
    
    /**
     * This defines how the enemy will move and randomly turn while outside of 200 pixels from the player
     * 
     * Method created by Lilly**
     */
    public void movement()
    {
        if(!isTouching(Player.class))
        {
            int randomMove = Greenfoot.getRandomNumber(100);
            if(randomMove >= 97)
            {
                turn(90);
            }
        }
        if(!isTouching(Player.class))
        {
            move(2);
        }
        else
        {
            move(0);
        }
    }
    
    /**
     * This forces the enemey to chase the Player
     */
    public void attackPlayer()
    {
        if(!getObjectsInRange(200,Player.class).isEmpty())
        {
            Actor player = (Actor) getObjectsInRange(200,Player.class).get(0);
            if(player != null)
            {
                followPlayer(player);
            }
        }
    }
    
    /**
     * This is what turns the enemy to face the Player and attack to end the game
     */
    public void followPlayer(Actor player)
    {
        turnTowards(player.getX(), player.getY());
        move(0); //this adds movement speed to the enemy, which makes it +* faster than player
        if(intersects(player))
        {
         getWorld();
         setImage(Blood);
            
         //display Game Over
         GameOver gameOver = new GameOver();
         getWorld().addObject(gameOver, 320, 240);
      }
        
    }
    
    private void layEgg()
    {
        long eggNowTime = System.currentTimeMillis();
        
        if(eggNowTime - startTime >  5000 && !isTouching(Player.class))
        {
            int randomEgg = Greenfoot.getRandomNumber(10);
            if(randomEgg == 0)
            {
                Egg egg = new Egg();
                getWorld().addObject(egg, getX(), getY());
            }
            startTime = System.currentTimeMillis();
        }
    }
    
    private void clusterBreed()
    {
        Egg egg = new Egg();
        try
        {
            if(getNeighbours(100,false,Egg.class).size() > 0)
            {
                long nowTime = System.currentTimeMillis();
                if(nowTime - startTime > 7000 && !isTouching(Explosion.class) && !isTouching(Projectile.class))
                {
                    getWorld().addObject(egg, getX(), getY());
                    getWorld().removeObject(this);
                    startTime2 = System.currentTimeMillis();
                }
            }   
        }
        catch (IllegalStateException e)
        {
            
        }
    }
}
