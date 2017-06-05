import greenfoot.*;

public class SuccessWorld extends World {

    public SuccessWorld(int score) {    
        super(640, 480, 1);
        int rand = Greenfoot.getRandomNumber(10);
        if(rand == 0) {
            rand = 10;
        }
        
        ButtonGoToLevel goToLevel = new ButtonGoToLevel(rand);
        addObject(goToLevel, 320, 400);
    }
}
