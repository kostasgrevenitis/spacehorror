import greenfoot.*;

public class ButtonGoToLevel extends Actor {
    private int _goalNumber;

    public ButtonGoToLevel(int goalNumber) {
        _goalNumber = goalNumber;
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if(getWorld() instanceof SuccessWorld) {
                Greenfoot.setWorld(new ShowGoalWorld());
            }
            else if (getWorld() instanceof ShowGoalWorld) {
                GetNumbersWorld newWorld = new GetNumbersWorld(this._goalNumber);
                newWorld.InitiateLevelAndScore();
                newWorld.level = 1;
                newWorld.currentSum = 0;
                newWorld.score = 0;
                ((Text) (newWorld.getObjects(Text.class).get(0))).setText("Επίπεδο : 1");
                ((Text) (newWorld.getObjects(Text.class).get(1))).setText("Πόντοι : 0");
                ((Text) (newWorld.getObjects(Text.class).get(3)))
                        .setText("Μέχρι στιγμής το άθροισμα είναι : 0");

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
                ;
                newWorld.score = f.score;
                newWorld.currentSum = 0;

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