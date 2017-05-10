import greenfoot.*;

public class Egg extends Actor {
    public long startHatch = System.currentTimeMillis();

    public void act() {
        this.HealthStatus();
        this.Hatch();
        τηισ.HatchAnimation();
    }

    void HealthStatus() {
        if (isTouching(Projectile.class)) {
            removeTouching(Projectile.class);
            getWorld().removeObject(this);
        }
    }

    private void Hatch() {
        long nowHatch = System.currentTimeMillis();

        if (nowHatch - startHatch > 2000) {
            int spiderNumber = Greenfoot.getRandomNumber(3) + 2;
            ((StarshipWorld) (getWorld())).spawnedEnemies = ((StarshipWorld) (getWorld())).spawnedEnemies + spiderNumber;

            int spidersLeft = ((StarshipWorld) (getWorld())).spawnedEnemies;
            ((Text) (getWorld().getObjects(Text.class).get(1))).setText("Spiders left : " + spidersLeft);
            for (int i = 0; i < spiderNumber; i++) {
                Enemy spider = new Enemy();
                getWorld().addObject(spider, getX(), getY());
            }

            getWorld().removeObject(this);
        }
    }

    private void HatchAnimation() {
        long hatchNow = System.currentTimeMillis();
        if (hatchNow - startHatch < 200) {
            setImage(new GreenfootImage("creep_egg0.png"));
        }
        if (hatchNow - startHatch > 400) {
            setImage(new GreenfootImage("creep_egg1.png"));
        }
        if (hatchNow - startHatch > 600) {
            setImage(new GreenfootImage("creep_egg2.png"));
        }
        if (hatchNow - startHatch > 800) {
            setImage(new GreenfootImage("creep_egg3.png"));
        }
        if (hatchNow - startHatch > 1000) {
            setImage(new GreenfootImage("creep_egg4.png"));
        }
        if (hatchNow - startHatch > 1200) {
            setImage(new GreenfootImage("creep_egg5.png"));
        }
        if (hatchNow - startHatch > 1400) {
            setImage(new GreenfootImage("creep_egg6.png"));
        }
        if (hatchNow - startHatch > 1600) {
            setImage(new GreenfootImage("creep_egg7.png"));
        }
        if (hatchNow - startHatch > 1800) {
            setImage(new GreenfootImage("creep_egg8.png"));
        }
    }
}
