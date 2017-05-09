import greenfoot.*; 

public class Controls extends World {
    public Controls() {
        super(640, 480, 1);
    }

    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new Menu());
        }
    }
}
