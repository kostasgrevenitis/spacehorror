import greenfoot.*;

public class Number extends Actor {
    private int countFrame = 1;
    private int health = 1;
    private static int movementStep;
    private int _goalNumber = -1;

    public Number(int goalNumber) {
        this._goalNumber = goalNumber;
        int rand = Greenfoot.getRandomNumber(this._goalNumber);
        GreenfootImage image = new GreenfootImage(rand + "_digit.png");
        image.scale(50, 50);
        setImage(image);
        movementStep = 2;
    }

    public void act() {
        this.Move();
        this.TurnAtEdge();
        //this.AttackPlayer();
        this.HealthStatus();
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
                    GetNumbersWorld world = (GetNumbersWorld) getWorld();
                    if (world.playerLifes == 1) {
                        Greenfoot.playSound("Scream+9.mp3");
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
                GetNumbersWorld world = (GetNumbersWorld) getWorld();
                world.score = world.score + 100;
                ((Text) (getWorld().getObjects(Text.class).get(1))).setText("Πόντοι : " + world.score);

                Greenfoot.playSound("Chomp+1.mp3");
                getWorld().removeObject(this);
        }
    }
}
