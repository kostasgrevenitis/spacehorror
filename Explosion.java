import greenfoot.*;

public class Explosion extends Actor {
    public int countFrame;

    public Explosion() {
    }

    public void Explode() {
        if (countFrame <= 10) {
            setImage(new GreenfootImage("spr_projectile_explode000.png"));
        }
        if (countFrame <= 20 && countFrame >= 10) {
            setImage(new GreenfootImage("spr_projectile_explode001.png"));
        }
        if (countFrame <= 30 && countFrame >= 20) {
            setImage(new GreenfootImage("spr_projectile_explode002.png"));
        }
        if (countFrame > 30) {
            getWorld().removeObject(this);
        }
    }

    public void act() {
        countFrame++;
        this.Explode();
    }
}
