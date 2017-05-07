import greenfoot.*;

/**
 * @author Konstantinos Grevenitis
 * @version 1.0
 */

public class Player extends Mover {
    //Variables that control the firing aspect of the game
    private int gunReloadTime;
    private int reloadDelayCount;
    private int shotsFired;
    public int stability;
    public int sprint;

    //Contrls the direction the player is facing
    private static int rotRight = 0;
    private static int rotDown = 90;
    private static int rotLeft = 180;
    private static int rotUp = 270;
    public int currentRotation = 0;

    public boolean isShiftDown = false;

    //Variable used for animation
    public int countFrame;

    /**
     * Player portrait
     */
    private GreenfootImage PlayerRight0;
    private GreenfootImage PlayerRight1;
    private GreenfootImage PlayerRight2;
    private GreenfootImage PlayerRight3;
    private GreenfootImage PlayerRight4;
    private GreenfootImage PlayerRight5;
    private GreenfootImage PlayerRight6;
    private GreenfootImage PlayerRight7;

    /**
     * Start the Player with the following attributes
     */
    public Player() {
        gunReloadTime = 15;
        reloadDelayCount = 0;
        shotsFired = 0;
        stability = 100;

        //only images need are character facing right, since we can rotate him and animation stays the same.
        PlayerRight0 = new GreenfootImage("spr_player_right000.png");
        PlayerRight1 = new GreenfootImage("spr_player_right001.png");
        PlayerRight2 = new GreenfootImage("spr_player_right002.png");
        PlayerRight3 = new GreenfootImage("spr_player_right003.png");
        PlayerRight4 = new GreenfootImage("spr_player_right004.png");
        PlayerRight5 = new GreenfootImage("spr_player_right005.png");
        PlayerRight6 = new GreenfootImage("spr_player_right006.png");
        PlayerRight7 = new GreenfootImage("spr_player_right007.png");
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        //movement method
        movement();

        //Animation
        setAnimation();
        countFrame();

        //bang bang
        checkKeys();
        reloadDelayCount++;
        emptyMag();

        if (Greenfoot.mouseMoved(null) && !isTouching(Enemy.class)) {
            MouseInfo mi = Greenfoot.getMouseInfo();
            turnTowards(mi.getX(), mi.getY());
        }
    }

    /**
     * Check to see which key is pressed and determine the action it performs
     *
     */
    public void movement() {
        if (Greenfoot.isKeyDown("s") && !isTouching(Enemy.class)) {
            move(-2);
        }
        if (Greenfoot.isKeyDown("w") && !isTouching(Enemy.class)) {
            move(2);
        }

        if (Greenfoot.isKeyDown("shift") && !isTouching(Enemy.class)) {
            isShiftDown = true;
            move(2);
            sprint = 1;
        } else {
            isShiftDown = false;
        }
    }

    /**
     * Set the time needed for reloading the Players gun. The shorter the time,
     * the faster the rifle fires.
     */
    public void setGunReloadTime(int reloadTime) {
        gunReloadTime = reloadTime;
    }

    /**
     * Fire a projectile if the gun is ready
     */
    private void fire() {
        if (reloadDelayCount >= gunReloadTime) {
            Projectile projectile = new Projectile(getRotation());
            getWorld().addObject(projectile, getX(), getY());
            shotsFired++;
            ((Text) (getWorld().getObjects(Text.class).get(0))).setText("Ammo spent : " + shotsFired + "/15");
            reloadDelayCount = 0;
        }
    }

    /**
     * Return the number of shots fired from this Player
     */
    public int getShotsfired() {
        return shotsFired;
    }

    /**
     * Check to see if Player is firing weapon or reloading
     */
    private void checkKeys() {
        if (Greenfoot.mouseClicked(null) && !isShiftDown && !isTouching(Enemy.class)) {
            fire();
        }
        if (Greenfoot.isKeyDown("r")) {
            reload();
        }
    }

    /**
     * Method that controls reloading your weapon
     */
    public void emptyMag() {
        if (shotsFired == 15) {
            gunReloadTime = 400;
        }
    }

    /**
     * Reload your Weapon
     */
    public void reload() {
        gunReloadTime = 15;
        shotsFired = 0;
        ((Text) (getWorld().getObjects(Text.class).get(0))).setText("Ammo spent : " + shotsFired + "/15");
    }

    /**
    * Set Animation
    */
    public void setAnimation() {
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s")) {
            if (countFrame <= 10)
                setImage(PlayerRight0);
            if (countFrame <= 20 && countFrame > 10)
                setImage(PlayerRight1);
            if (countFrame <= 30 && countFrame > 20)
                setImage(PlayerRight2);
            if (countFrame <= 40 && countFrame > 30)
                setImage(PlayerRight3);
            if (countFrame <= 50 && countFrame > 40)
                setImage(PlayerRight4);
            if (countFrame <= 60 && countFrame > 50)
                setImage(PlayerRight5);
            if (countFrame <= 70 && countFrame > 60)
                setImage(PlayerRight6);
            if (countFrame <= 80 && countFrame > 70) {
                setImage(PlayerRight7);
                countFrame = 0;
            }
        }
    }

    /**
     * countFrame is used to animate by delaying the next image
     */
    public void countFrame() {
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s"))
            countFrame++;
    }
}
