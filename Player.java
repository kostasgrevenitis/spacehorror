import greenfoot.*;

public class Player extends Mover {
    private int shotsFired;
    private boolean isShiftDown = false;
    private int countFrame;

    public Player() {
        this.shotsFired = 0;
    }

    public void act() {
        this.MoveCharacter();
        this.CheckKeys();

        // if (Greenfoot.mouseMoved(null) && !isTouching(Enemy.class)) {
        //     MouseInfo mi = Greenfoot.getMouseInfo();
        //     turnTowards(mi.getX(), mi.getY());
        // }
    }

    public void MoveCharacter() {
        this.countFrame++;

        if ((Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("a")
                || Greenfoot.isKeyDown("d")) && !isTouching(Enemy.class)) {
            this.move(2);
            this.SetAnimation(Greenfoot.getKey());
        }

        if (Greenfoot.isKeyDown("shift") && !isTouching(Enemy.class)) {
            isShiftDown = true;
            move(4);
        } else {
            isShiftDown = false;
        }
    }

    public void SetAnimation(String key) {

        String direction = "";
        switch (key) {
        case "w":
            direction = "up";
            break;

        case "s":
            direction = "down";
            break;

        case "a":
            direction = "left";
            break;

        case "d":
            direction = "right";
            break;
        }

        GreenfootImage Player0 = new GreenfootImage("spr_player_" + direction + "000.png");
        GreenfootImage Player1 = new GreenfootImage("spr_player_" + direction + "001.png");
        GreenfootImage Player2 = new GreenfootImage("spr_player_" + direction + "002.png");
        GreenfootImage Player3 = new GreenfootImage("spr_player_" + direction + "003.png");
        GreenfootImage Player4 = new GreenfootImage("spr_player_" + direction + "004.png");
        GreenfootImage Player5 = new GreenfootImage("spr_player_" + direction + "005.png");
        GreenfootImage Player6 = new GreenfootImage("spr_player_" + direction + "006.png");
        GreenfootImage Player7 = new GreenfootImage("spr_player_" + direction + "007.png");

        if (countFrame <= 10) {
            setImage(Player0);
        }

        if (countFrame <= 20 && countFrame > 10){
            setImage(Player1);
        }
            
        if (countFrame <= 30 && countFrame > 20){
            setImage(Player2);
        }
            
        if (countFrame <= 40 && countFrame > 30){
            setImage(Player3);
        }
            
        if (countFrame <= 50 && countFrame > 40){
            setImage(Player4);
        }
            
        if (countFrame <= 60 && countFrame > 50){
            setImage(Player5);
        }
            
        if (countFrame <= 70 && countFrame > 60){
            setImage(Player6);
        }
            
        if (countFrame <= 80 && countFrame > 70) {
            setImage(Player7);
            countFrame = 0;
        }
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
