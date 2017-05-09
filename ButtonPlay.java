import greenfoot.*;  
 
public class ButtonPlay extends Actor
{
    public ButtonPlay() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
    }
        
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new CountDownWorld());
        }
    }    
}
