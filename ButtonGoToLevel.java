import greenfoot.*;

public class ButtonGoToLevel extends Actor {
    private int _goalNumber;

    public ButtonGoToLevel(int goalNumber) {
        _goalNumber = goalNumber;
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if(getWorld() instanceof SuccessWorld) {
                SuccessWorld s = (SuccessWorld)getWorld();
                ShowGoalWorld showGoalWorld = new ShowGoalWorld();
                showGoalWorld.level = ++s.level;
                showGoalWorld.score = s.score;
                showGoalWorld.playerLifes = s.playerLifes;
                Greenfoot.setWorld(showGoalWorld);
            }
            else if (getWorld() instanceof ShowGoalWorld) {
                ShowGoalWorld showGoalWorld = new ShowGoalWorld();
                GetNumbersWorld newWorld = new GetNumbersWorld(this._goalNumber);
                newWorld.InitiateLevelAndScore();

                newWorld.level = showGoalWorld.level;
                newWorld.score = showGoalWorld.score;
                newWorld.playerLifes = showGoalWorld.playerLifes; //already minus one
                newWorld.currentSum = 0;
                
                ((Text) (newWorld.getObjects(Text.class).get(0))).setText("Επίπεδο : " + newWorld.level);
                ((Text) (newWorld.getObjects(Text.class).get(1))).setText("Πόντοι : "+ newWorld.score);
                ((Text) (newWorld.getObjects(Text.class).get(3)))
                        .setText("Μέχρι στιγμής το άθροισμα είναι : 0");
                        
                newWorld.BuildLifes(newWorld.playerLifes);
                Greenfoot.setWorld(newWorld);
            } else if (getWorld() instanceof TimemoutFailedWorld) {
                TimemoutFailedWorld t = (TimemoutFailedWorld) getWorld();
                GetNumbersWorld newWorld = new GetNumbersWorld(this._goalNumber);

                newWorld.playerLifes = t.playerLifes; //already minus one
                if ((newWorld.level - 1) > 0) {
                    newWorld.level--;
                }
                ;
                newWorld.score = t.score;
                newWorld.currentSum = 0;

                ((Text) (newWorld.getObjects(Text.class).get(0))).setText("Επίπεδο : " + newWorld.level);
                ((Text) (newWorld.getObjects(Text.class).get(1))).setText("Πόντοι : " + newWorld.score);
                ((Text) (newWorld.getObjects(Text.class).get(3)))
                        .setText("Μέχρι στιγμής το άθροισμα είναι : " + newWorld.currentSum);
                
                newWorld.BuildLifes(newWorld.playerLifes);
                Greenfoot.setWorld(newWorld);
            } else if (getWorld() instanceof FailWorld) {
                FailWorld f = (FailWorld) getWorld();
                GetNumbersWorld newWorld = new GetNumbersWorld(f._goalNumber);
                newWorld.currentSum = 0;
                if ((newWorld.level - 1) > 0) {
                    newWorld.level--;
                }

                newWorld.score = f.score;
                newWorld.currentSum = 0;
                newWorld.playerLifes = f.playerLifes; //already minus one

                ((Text) (newWorld.getObjects(Text.class).get(0))).setText("Επίπεδο : " + newWorld.level);
                ((Text) (newWorld.getObjects(Text.class).get(1))).setText("Πόντοι : " + newWorld.score);
                ((Text) (newWorld.getObjects(Text.class).get(3)))
                        .setText("Μέχρι στιγμής το άθροισμα είναι : " + newWorld.currentSum);
                newWorld.BuildLifes(newWorld.playerLifes);

                Greenfoot.setWorld(newWorld);
            }
        }
    }
}