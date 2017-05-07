import greenfoot.*;

/**
 * @author Konstantinos Grevenitis
 * @version 1.0
 */
public class StarshipWorld extends World
{
    public int locationX;
    public int locationY;
    public int randomSpawn;
    private int xOffset = 0;
    
    public StarshipWorld()
    {    
        super(640, 480, 1);
		//https://www.greenfoot.org/files/javadoc/greenfoot/World.html#setPaintOrder-java.lang.Class...-
        setPaintOrder(PlayerLife.class, GameOver.class, Enemy.class, Explosion.class, Projectile.class, Player.class, Portal.class);
        BuildWorld();
    }
    
    public void act()
    {
    }
    
    public void BuildWorld()
    {
        BuildLifes();
        SpawnPlayer();
        
        Portal portal0 = new Portal();
        addObject(portal0, 320, 240);
        
        //determine how many enemies will populate the screen
        randomSpawn = (Greenfoot.getRandomNumber(4)+1);
        
        //this loop is used to spawn enemies to the world based on the # randomSpawn generates
        for(int i = 0; i < randomSpawn; i++)
        {
            SpawnEnemy();
        }
    }
    
    /**
     * this method creates (4) 200x200 fields for the enemies to be placed in when they spawn. in turn this creates a 400x800
     * (T) shaped safe zone for the Player to spawn in.
     */
    public void SpawnEnemy()
    {
        boolean isPlaced = false;
        int locationX = 400;
        int locationY = 400;
            //by starting the locationX & locationY with a value of 400, it starts the while loops
            locationX = Greenfoot.getRandomNumber(640);
            locationY = Greenfoot.getRandomNumber(480);
        
            //if the X location is between 200 & 600 generate a new number, if the number is below 200 and above 600 keep the number
            //and pass the location to the enemy
            while (locationX < 50 && locationX > 750)
            {
                locationX = Greenfoot.getRandomNumber(800);
            }
            //if the Y location is between 200 & 600 generate a new number, if the number is below 200 and above 600 keep the number
            //and pass the location to the enemy
            while (locationY > 200 && locationY < 600)
            {
                locationY = Greenfoot.getRandomNumber(800);
            }
        
        Enemy enemy0 = new Enemy();
        addObject(enemy0, locationX, locationY);
        
    }
    
    private void SpawnPlayer()
    {
        Player player0 = new Player();
        addObject(player0, 320, 240);    
    }

    private void BuildLifes()
    {
        int startLives = 5;
        for(int i = 0; i < startLives; i++)
        {
            PlayerLife life = new PlayerLife();
            addObject(life, 250 + xOffset, 20);
            xOffset = xOffset + 30;
        }
    }
}
