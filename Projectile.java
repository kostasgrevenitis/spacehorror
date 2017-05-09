import greenfoot.*;

public class Projectile extends Actor {
    int duration = 60;

    public Projectile(int direction) {
        setRotation(direction);
    }

    public void act() {
        move(15);
        duration--;

        if (duration < 0) {
            getWorld().removeObject(this);
        }
    }
}
