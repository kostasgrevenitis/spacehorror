import greenfoot.*; 

public class ButtonControls extends Actor {
    public ButtonControls() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Controls());
        }
    }
}
