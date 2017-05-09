import greenfoot.*;

public class Portal extends Actor {
    private long startTime = System.currentTimeMillis();
    private int countFrame = 0;

    public void act() {
        turnOnPortal();
    }

    private void turnOnPortal() {
        countFrames();
        if (countFrame <= 0) {
            setImage(new GreenfootImage("portal0.png"));
        }
        if (countFrame > 0 && countFrame <= 10) {
            setImage(new GreenfootImage("portal1.png"));
            //Στη κλάση Enemy το πλήθος δεν έπεφτε ποτέ κάτω από 1. Για να μηδενιστεί έπρεπε να μπει εδώ.
            ((Text) (getWorld().getObjects(Text.class).get(1))).setText("Spiders left : 0");
        }
        if (countFrame > 10 && countFrame <= 20) {
            setImage(new GreenfootImage("portal2.png"));
        }
        if (countFrame > 20 && countFrame <= 30) {
            setImage(new GreenfootImage("portal3.png"));
        }
        if (countFrame > 30 && countFrame <= 40) {
            setImage(new GreenfootImage("portal4.png"));
        }
        if (countFrame > 40 && countFrame <= 50) {
            setImage(new GreenfootImage("portal5.png"));
        }
        if (countFrame > 50 && countFrame <= 60) {
            setImage(new GreenfootImage("portal6.png"));
        }
        if (countFrame > 60 && countFrame <= 70) {
            setImage(new GreenfootImage("portal7.png"));
        }
        if (countFrame > 70) {
            setImage(new GreenfootImage("portal8.png"));
            if (isTouching(Player.class)) {
                Greenfoot.setWorld(new StarshipWorld());
            }
        }
    }

    public void countFrames() {
        if (getWorld().getObjects(Enemy.class).size() == 0) {
            countFrame++;
        }
    }
}
