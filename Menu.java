import greenfoot.*;  

/**
 * @author Konstantinos Grevenitis
 * @version 1.0
 */

public class Menu extends World
{
    public Menu()
    {    
        super(640, 480, 1);
        BuildMenu();
        prepare();
    }

    private void BuildMenu()
    {
        ButtonPlay buttonPlay = new ButtonPlay();
        addObject(buttonPlay, 170, 420);

        ButtonControls buttonControls = new ButtonControls();
        addObject(buttonControls, 480, 420);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
