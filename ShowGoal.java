import greenfoot.*;  

public class ShowGoal extends World {
    public ShowGoal() {    
        super(640, 480, 1); 
        int rand = Greenfoot.getRandomNumber(10);
        char[] randCharArray = Integer.toString(rand).toCharArray();
        int xPosition = 100;
        for(int i=0; i<randCharArray.length; i++){
            GreenfootImage image = new GreenfootImage(randCharArray[i] + "_digit.png");
            image.scale(150, 150);
            Container c = new Container();
            c.setImage(image);
            addObject(c, xPosition, 250);
            xPosition = xPosition + 160;
         }
    }
}
