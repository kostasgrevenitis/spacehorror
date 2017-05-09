import greenfoot.*;

public class GameOver extends Actor {

    public GameOver(){
        this.setImage("spr_blood_0.png");
        this.setImage("game_over_0.png");
    }
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new CountDownWorld());
        }
    }
}
