import greenfoot.*;

public class Menu extends World {
    public Menu() {
        super(640, 480, 1);
        BuildMenu();
    }

    private void BuildMenu() {
        GreenfootSound backgroundMusic = new GreenfootSound("mr_clown.mp3");
        backgroundMusic.setVolume(40);
        backgroundMusic.playLoop();
        ButtonPlay buttonPlay = new ButtonPlay();
        addObject(buttonPlay, 170, 420);

        ButtonControls buttonControls = new ButtonControls();
        addObject(buttonControls, 480, 420);
    }
}
