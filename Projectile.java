import greenfoot.*;

public class Projectile extends Actor {
    int duration = 60;

    public Projectile(int direction) {
        setRotation(direction);
        int handRotation = 0;

        //player up
        if  (direction == 270){
            handRotation = 90;
        }

        //player down
        if (direction == 90) {
            handRotation = 90;
        }

        //player left
        if (direction == 180) {
            handRotation = 90;
        }

        //player right
        if (direction == 0) {
            handRotation = 90;
        }

        getImage().rotate(handRotation);
    }

    public void act() {
        move(15);
        duration--;

        if (duration < 0) {
            getWorld().removeObject(this);
        }
    }
}
