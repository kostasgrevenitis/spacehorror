import greenfoot.*;  

public class ShowGoal extends World {
    public ShowGoal() {    
        super(640, 480, 1); 
        int rand = Greenfoot.getRandomNumber(10);
        char[] randCharArray = Integer.toString(rand).toCharArray();
        int xPosition = 320-((100*(randCharArray.length-1))/randCharArray.length);

        for(int i=0; i<randCharArray.length; i++){
            GreenfootImage image = new GreenfootImage(randCharArray[i] + "_digit.png");
            image.scale(100, 100);
            Container c = new Container();
            c.setImage(image);
            addObject(c, xPosition, 250);
            xPosition = xPosition + 110;
         }
         
            ButtonGoToLevel goToLevel = new ButtonGoToLevel(rand);
            addObject(goToLevel, 320, 400);
    }
}