import greenfoot.*;

public class Enemy extends Mover {
    public int countFrame = 1;//Variable used for animation
    public int hitEnemy = 0; //how many times the projectile hits enemy
    public int health = 2; //how many shots it takes to kill the enemy

    private GreenfootImage BloodImage;
    private long startTime;
    private long startTime2;

    public Enemy() {
        this.BloodImage = new GreenfootImage("spr_blood_0.png");
        startTime = System.currentTimeMillis();
        startTime2 = System.currentTimeMillis();
    }

    public void act() {
        movement(); //method used to move the enemey
        turnAtEdge(); //method that forces the enemy to turn 90 degrees when it reaches the edge of the screen
        attackPlayer(); //method that forces the enemy to chase the player when the player is within 200 pixels
        health();
        layEgg();
        clusterBreed();
    }

    public void health() {
        if (isTouching(Projectile.class)) {
            removeTouching(Projectile.class);
            getWorld().addObject(new Explosion(), getX(), getY());
            hitEnemy++;
            if (hitEnemy == health) {
                ((StarshipWorld) (getWorld())).spawnedEnemies--;
                int spidersLeft = ((StarshipWorld) (getWorld())).spawnedEnemies;
                ((Text) (getWorld().getObjects(Text.class).get(1))).setText("Spiders left : " + spidersLeft);
                getWorld().removeObject(this);
            }
        }
    }

    /**
     * This turns the enemy 180 degrees away from the edge of the screen to keep them from getting stuck
     */
    public void turnAtEdge() {
        if (isAtEdge()) {
            turn(90);
        }
    }

    public void movement() {
        if (!isTouching(Player.class)) {
            int randomMove = Greenfoot.getRandomNumber(100);
            if (randomMove >= 97) {
                turn(90);
            }
        }
        if (!isTouching(Player.class)) {
            move(2);
        } else {
            move(0);
        }
    }

    /**
     * This forces the enemey to chase the Player
     */
    public void attackPlayer() {
        if (!getObjectsInRange(200, Player.class).isEmpty()) {
            Actor player = (Actor) getObjectsInRange(200, Player.class).get(0);
            if (player != null) {
                followPlayer(player);
            }
        }
    }

    /**
     * This is what turns the enemy to face the Player and attack to end the game
     */
    public void followPlayer(Actor player) {
        turnTowards(player.getX(), player.getY());
        move(0); //this adds movement speed to the enemy, which makes it +* faster than player
        if (intersects(player)) {
            getWorld();
            setImage(this.BloodImage);

            //display Game Over
            GameOver gameOver = new GameOver();
            getWorld().addObject(gameOver, 320, 240);
        }

    }

    private void layEgg() {
        long eggNowTime = System.currentTimeMillis();

        if (eggNowTime - startTime > 5000 && !isTouching(Player.class)) {
            int randomEgg = Greenfoot.getRandomNumber(10);
            if (randomEgg == 0) {
                Egg egg = new Egg();
                getWorld().addObject(egg, getX(), getY());
            }
            startTime = System.currentTimeMillis();
        }
    }

    private void clusterBreed() {
        Egg egg = new Egg();
        try {
            if (getNeighbours(100, false, Egg.class).size() > 0) {
                long nowTime = System.currentTimeMillis();
                if (nowTime - startTime > 7000 && !isTouching(Explosion.class) && !isTouching(Projectile.class)) {
                    getWorld().addObject(egg, getX(), getY());
                    getWorld().removeObject(this);
                    startTime2 = System.currentTimeMillis();
                }
            }
        } catch (IllegalStateException e) {

        }
    }
}
