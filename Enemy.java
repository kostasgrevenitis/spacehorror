import greenfoot.*;

public class Enemy extends Actor {
    private int countFrame = 1;
    private int hitEnemy = 0;
    private int health = 2;
    private long startTime;
    private long startTime2;
    private static int movementStep;

    public Enemy() {
        movementStep = 2;
        startTime = System.currentTimeMillis();
        startTime2 = System.currentTimeMillis();
    }

    public void act() {
        this.Move();
        this.TurnAtEdge();
        this.AttackPlayer();
        this.HealthStatus();
        this.LayEgg();
        //this.ClusterBreed();
    }

    public void Move() {
        if (movementStep != 0) {
            if (!isTouching(Player.class)) {
                int randomMove = Greenfoot.getRandomNumber(100);
                if (randomMove >= 97) {
                    turn(90);
                }
            }
            if (!isTouching(Player.class)) {
                move(movementStep);
            } else {
                move(0);
            }
        }
    }

    public void TurnAtEdge() {
        if (movementStep != 0) {
            if (isAtEdge()) {
                turn(90);
            }
        }
    }

    public void AttackPlayer() {
        if (!getObjectsInRange(200, Player.class).isEmpty()) {
            Actor player = (Actor) getObjectsInRange(200, Player.class).get(0);
            if (player != null) {
                turnTowards(player.getX(), player.getY());
                move(0);

                if (intersects(player)) {
                    StarshipWorld starshipWorld = (StarshipWorld) getWorld();
                    if (starshipWorld.playerLifes == 1) {
                        getWorld().addObject(new GameOver(), 320, 240);
                        movementStep = 0;
                    }
                }
            }
        }
    }

    public void HealthStatus() {
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

    private void LayEgg() {
        if (movementStep != 0) {
            long eggNowTime = System.currentTimeMillis();

            if ((eggNowTime - startTime > 10000) && !isTouching(Player.class) && !isTouching(Explosion.class)
                    && !isTouching(Projectile.class) && getNeighbours(300, true, Egg.class).size() == 0) {
                Egg egg = new Egg();
                getWorld().addObject(egg, getX(), getY());
                startTime = System.currentTimeMillis();
            }
        }
    }
}
