import greenfoot.*;

public class SuccessWorld extends World {

    public static int level = 1;
    public static int score = 0;
    public static int playerLifes = 5;

    public SuccessWorld() {
        super(640, 480, 1);
    }

    public void ShowSuccess() {
        int rand = Greenfoot.getRandomNumber(10);
        if (rand == 0) {
            rand = 10;
        }

        char[] randCharArray = Integer.toString(this.score).toCharArray();
        int xPosition = 320 - ((100 * (randCharArray.length - 1)) / randCharArray.length);

        for (int i = 0; i < randCharArray.length; i++) {
            GreenfootImage image = new GreenfootImage(randCharArray[i] + "_digit.png");
            image.scale(100, 100);
            Container c = new Container();
            c.setImage(image);
            addObject(c, xPosition, 170);
            xPosition = xPosition + 110;
        }

        ButtonGoToLevel goToLevel = new ButtonGoToLevel(rand);
        addObject(goToLevel, 320, 400);
        Greenfoot.playSound("success_fanfair.mp3");
    }
}
