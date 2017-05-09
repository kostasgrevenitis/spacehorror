import greenfoot.*;

public class Projectile extends Actor {
    int duration = 60;

    public Projectile(int x, int y) {
        this.turnTowards(x, y);
    }

    public void act() {
        move(10);
        duration--;

        if (duration < 0) {
            getWorld().removeObject(this);
        }
    }
}
