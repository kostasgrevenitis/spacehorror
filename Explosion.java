import greenfoot.*;

public class Explosion extends Actor {
    public int countFrame;

    private GreenfootImage Explode0;
    private GreenfootImage Explode1;
    private GreenfootImage Explode2;

    public Explosion() {
        Explode0 = new GreenfootImage("spr_projectile_explode000.png");
        Explode1 = new GreenfootImage("spr_projectile_explode001.png");
        Explode2 = new GreenfootImage("spr_projectile_explode002.png");
    }

    public void Explode() {
        if (countFrame <= 10) {
            setImage(Explode0);
        }
        if (countFrame <= 20 && countFrame >= 10) {
            setImage(Explode1);
        }
        if (countFrame <= 30 && countFrame >= 20) {
            setImage(Explode2);
        }
        if (countFrame > 30) {
            getWorld().removeObject(this);
        }
    }

    public void act() {
        countFrame++;
        Explode();
    }
}
