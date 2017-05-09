import greenfoot.*;

public class Menu extends World {
    public Menu() {
        super(640, 480, 1);
        BuildMenu();
        prepare();
    }

    private void BuildMenu() {
        ButtonPlay buttonPlay = new ButtonPlay();
        addObject(buttonPlay, 170, 420);

        ButtonControls buttonControls = new ButtonControls();
        addObject(buttonControls, 480, 420);
    }

    private void prepare() {
    }
}
