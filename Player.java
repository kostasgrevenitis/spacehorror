import greenfoot.*;

public class Player extends Actor {
    private int countFrame = 0;
    private int x = 0;
    private int y = 0;
    private int degrees = 0;

    public Player() {
    }

    public void act() {
        // if (isTouching(Enemy.class) == true) {
        //     StarshipWorld starshipWorld = (StarshipWorld) getWorld();
        //     if (starshipWorld.playerLifes > 0) {
        //         starshipWorld.playerLifes--;
        //         PlayerLife playerLife = (PlayerLife) getWorld().getObjects(PlayerLife.class).get(0);
        //         if (playerLife != null) {
        //             getWorld().removeObject(playerLife);
        //         }
        //         this.setLocation(this.getX() + 60, this.getY() + 60);
        //         Greenfoot.playSound("Chomp+1.mp3");
        //     }
        //     return;
        // }

        if (Greenfoot.mouseClicked(null)) {
            this.ThrowHand();
            Greenfoot.playSound("throw_hand.mp3");
            return;
        }

        String direction = "";
        if (Greenfoot.isKeyDown("w")) {
            direction = "up";
            this.x = this.getX();
            this.y = this.getY() - 3;
            this.degrees = 270;
        }

        if (Greenfoot.isKeyDown("s")) {
            direction = "down";
            this.x = this.getX();
            this.y = this.getY() + 3;
            this.degrees = 90;
        }

        if (Greenfoot.isKeyDown("a")) {
            direction = "left";
            this.x = this.getX() - 3;
            this.y = this.getY();
            this.degrees = 180;
        }

        if (Greenfoot.isKeyDown("d")) {
            direction = "right";
            this.x = this.getX() + 3;
            this.y = this.getY();
            this.degrees = 0;
        }

        if (direction == "") {
            return;
        }

        this.setLocation(x, y);
        this.countFrame++;
        this.SetAnimation(direction);
    }

    public void SetAnimation(String direction) {
        if (countFrame <= 10) {
            setImage(new GreenfootImage("spr_player_" + direction + "000.png"));
        }

        if (countFrame <= 20 && countFrame > 10) {
            setImage(new GreenfootImage("spr_player_" + direction + "001.png"));
        }

        if (countFrame <= 30 && countFrame > 20) {
            setImage(new GreenfootImage("spr_player_" + direction + "002.png"));
        }

        if (countFrame <= 40 && countFrame > 30) {
            setImage(new GreenfootImage("spr_player_" + direction + "003.png"));
        }

        if (countFrame <= 50 && countFrame > 40) {
            setImage(new GreenfootImage("spr_player_" + direction + "004.png"));
        }

        if (countFrame <= 60 && countFrame > 50) {
            setImage(new GreenfootImage("spr_player_" + direction + "005.png"));
        }

        if (countFrame <= 70 && countFrame > 60) {
            setImage(new GreenfootImage("spr_player_" + direction + "006.png"));
        }

        if (countFrame <= 80 && countFrame > 70) {
            setImage(new GreenfootImage("spr_player_" + direction + "007.png"));
            countFrame = 0;
        }
    }

    private void ThrowHand() {
        Projectile projectile = new Projectile(this.degrees);
        getWorld().addObject(projectile, this.getX(), this.getY());
    }
}