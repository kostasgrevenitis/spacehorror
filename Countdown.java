import greenfoot.*;

/**
 * @author Konstantinos Grevenitis
 * @version 1.0
 */

public class Countdown extends Actor {
    public int countdownFrame;
    public Countdown() {}

    public void act() {
        countdownFrame++;
        countdown();
    }

    public void countdown() {
        if (countdownFrame >= 0 && countdownFrame < 60) {
            GreenfootImage countdownImage3 = new GreenfootImage("3_digit.png");
            countdownImage3.scale(250, 250);
            setImage(countdownImage3);
        }

        if (countdownFrame > 60 && countdownFrame < 120) {
            GreenfootImage countdownImage2 = new GreenfootImage("2_digit.png");
            countdownImage2.scale(250, 250);
            setImage(countdownImage2);
        }

        if (countdownFrame > 120 && countdownFrame < 180) {
            GreenfootImage countdownImage1 = new GreenfootImage("1_digit.png");
            countdownImage1.scale(250, 250);
            setImage(countdownImage1);
        }
        if (countdownFrame > 180) {
            StarshipWorld starshipWorld = new StarshipWorld();
            starshipWorld.level = 1;
            starshipWorld.score = 0;
            Greenfoot.setWorld(starshipWorld);
            starshipWorld.InitiateLevelAndScore();
        }
    }

}
