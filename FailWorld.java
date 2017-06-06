import greenfoot.*;

public class FailWorld extends World {
    public int _goalNumber = -1;
    public int playerLifes = -1;
    public int currentSum = -1;
    public int score = -1;
    public int level = -1;

    public FailWorld() {    
        super(640, 480, 1);
        int rand = Greenfoot.getRandomNumber(10);
        if(rand == 0) {
            rand = 10;
        }
        ButtonGoToLevel goToLevel = new ButtonGoToLevel(rand);
        addObject(goToLevel, 320, 400);
        Greenfoot.playSound("fail_trumpet.mp3");
    }
}
