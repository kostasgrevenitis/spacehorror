import greenfoot.*;  

/**
 * @author Konstantinos Grevenitis
 * @version 1.0
 */
 
public class ButtonPlay extends Actor
{
    public ButtonPlay() {
		//https://www.greenfoot.org/topics/1763
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 830, image.getHeight() - 230);
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
