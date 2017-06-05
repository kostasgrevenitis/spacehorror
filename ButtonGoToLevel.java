import greenfoot.*;  

public class ButtonGoToLevel extends Actor {
    private int _goalNumber;
   public ButtonGoToLevel(int goalNumber){
        _goalNumber = goalNumber;
   }
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new GetNumbersWorld(this._goalNumber));
        }
    }    
}
