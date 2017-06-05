import greenfoot.*;  

public class ButtonGoToLevel extends Actor {
    private int _goalNumber;
   public ButtonGoToLevel(int goalNumber){
        _goalNumber = goalNumber;
   }
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (getWorld() instanceof ShowGoalWorld){
                Greenfoot.setWorld(new GetNumbersWorld(this._goalNumber));
            }else if(getWorld() instanceof TimemoutFailedWorld) {
                TimemoutFailedWorld t = (TimemoutFailedWorld) getWorld();
                GetNumbersWorld newWorld = new GetNumbersWorld(this._goalNumber);

                newWorld.playerLifes = t.playerLifes; //already minus one
                if((newWorld.level - 1) > 0 ) {
                    newWorld.level--;
                };
                newWorld.score = t.score;
                newWorld.currentSum = 0;

                ((Text) (newWorld.getObjects(Text.class).get(0))).setText("Επίπεδο : " + newWorld.level);
                ((Text) (newWorld.getObjects(Text.class).get(1))).setText("Πόντοι : " + newWorld.score);
                ((Text) (newWorld.getObjects(Text.class).get(3))).setText("Μέχρι στιγμής το άθροισμα είναι : " + newWorld.currentSum);
                newWorld.BuildLifes(newWorld.playerLifes);

                Greenfoot.setWorld(newWorld);
            }
            
        }
    }    
}
