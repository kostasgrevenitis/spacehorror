import greenfoot.*;

public class GameOver extends Actor {

    public GameOver(){
    }
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new ShowGoalWorld());
        }
    }
}
