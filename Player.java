import greenfoot.*;

public class Player extends Mover {
    private int gunReloadTime;
    private int shotsFired;
    public int sprint;

    private static int rotRight = 0;
    private static int rotDown = 90;
    private static int rotLeft = 180;
    private static int rotUp = 270;
    public int currentRotation = 0;

    public boolean isShiftDown = false;
    public int countFrame;

    private GreenfootImage PlayerRight0;
    private GreenfootImage PlayerRight1;
    private GreenfootImage PlayerRight2;
    private GreenfootImage PlayerRight3;
    private GreenfootImage PlayerRight4;
    private GreenfootImage PlayerRight5;
    private GreenfootImage PlayerRight6;
    private GreenfootImage PlayerRight7;

    public Player() {
        gunReloadTime = 15;
        shotsFired = 0;

        PlayerRight0 = new GreenfootImage("spr_player_right000.png");
        PlayerRight1 = new GreenfootImage("spr_player_right001.png");
        PlayerRight2 = new GreenfootImage("spr_player_right002.png");
        PlayerRight3 = new GreenfootImage("spr_player_right003.png");
        PlayerRight4 = new GreenfootImage("spr_player_right004.png");
        PlayerRight5 = new GreenfootImage("spr_player_right005.png");
        PlayerRight6 = new GreenfootImage("spr_player_right006.png");
        PlayerRight7 = new GreenfootImage("spr_player_right007.png");
    }

    public void act() {
        this.MoveCharacter();
        this.SetAnimation();
        this.CountFrame();
        this.CheckKeys();

        if (Greenfoot.mouseMoved(null) && !isTouching(Enemy.class)) {
            MouseInfo mi = Greenfoot.getMouseInfo();
            turnTowards(mi.getX(), mi.getY());
        }
    }

    public void MoveCharacter() {
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

    public void SetAnimation() {
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
    public void CountFrame() {
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s"))
            countFrame++;
    }

    private void CheckKeys() {
        if (Greenfoot.mouseClicked(null) && !isShiftDown && !isTouching(Enemy.class)) {
            this.FireGun();
        }
        if (Greenfoot.isKeyDown("r")) {
            this.ReloadGun();
        }
    }

    private void FireGun() {
        if (shotsFired < 25) {
            Projectile projectile = new Projectile(getRotation());
            getWorld().addObject(projectile, getX(), getY());
            shotsFired++;
            ((Text) (getWorld().getObjects(Text.class).get(0))).setText("Ammo spent : " + shotsFired + "/25");
        }
    }

    public void ReloadGun() {
        shotsFired = 0;
        ((Text) (getWorld().getObjects(Text.class).get(0))).setText("Ammo spent : " + shotsFired + "/25");
    }
}
