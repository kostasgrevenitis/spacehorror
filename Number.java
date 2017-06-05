import greenfoot.*;

public class Number extends Actor {
    private int countFrame = 1;
    private int health = 1;
    private static int movementStep;
    private int _goalNumber = -1;
    private int myNumber = -1;

    public Number(int goalNumber) {
        this._goalNumber = goalNumber;
        int rand = Greenfoot.getRandomNumber(this._goalNumber) + 1;
        if(rand >= 10){
            rand = 9;
        }

        this.myNumber = rand;
        GreenfootImage image = new GreenfootImage(rand + "_digit.png");
        image.scale(50, 50);
        setImage(image);
        movementStep = 2;
    }

    public void act() {
        this.Move();
        this.TurnAtEdge();
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

    public void HealthStatus() {
        if (isTouching(Projectile.class)) {
            removeTouching(Projectile.class);
            getWorld().addObject(new Explosion(), getX(), getY());
                GetNumbersWorld world = (GetNumbersWorld) getWorld();
                world.score = world.score + 100;
                ((Text) (getWorld().getObjects(Text.class).get(1))).setText("Πόντοι : " + world.score);

                world.currentSum = world.currentSum + this.myNumber;
                ((Text) (getWorld().getObjects(Text.class).get(3))).setText("Μέχρι στιγμής το άθροισμα είναι : " + world.currentSum);

                Greenfoot.playSound("Chomp+1.mp3");
                getWorld().removeObject(this);

                if(world.currentSum == world._goalNumber) {
                    world.currentSum = 0;
                     Greenfoot.setWorld(new SuccessWorld(world.score));
                } else if (world.currentSum > world._goalNumber) {
                    world.currentSum = 0;
                    Greenfoot.setWorld(new FailWorld());
                }
        }
    }
}