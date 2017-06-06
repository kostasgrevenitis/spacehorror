import greenfoot.*;
import java.util.List;

public class GetNumbersWorld extends World {
    private int spawnedNumbers;
    public static int duration = 120000;

    public int playerLifes = 5;

    public int _goalNumber = -1;
    public static int currentSum = 0;
    public static int score = 0;
    public static int level = 0;

    public GetNumbersWorld(int goalNumber) {
        super(640, 480, 1);
        this._goalNumber = goalNumber;
        level++;
        int img = Greenfoot.getRandomNumber(3) + 1;
        this.setBackground(new GreenfootImage("background00" + img + ".jpg"));
        this.setPaintOrder(Text.class, PlayerLife.class, GameOver.class, Number.class, Explosion.class,
                Projectile.class, Player.class);

        this.BuildLifes(this.playerLifes);
        this.SpawnPlayer();
        this.SpawnNumbers();
        this.InitiateLevelAndScore();
    }

    public void BuildLifes(int _playerLifes) {
        int xOffset = 0;
        if (getObjects(PlayerLife.class).size() > 0) {
            removeObjects(getObjects(PlayerLife.class));
        }

        for (int i = 0; i < _playerLifes; i++) {
            PlayerLife life = new PlayerLife();
            addObject(life, 250 + xOffset, 20);
            xOffset = xOffset + 30;
        }
    }

    private void SpawnPlayer() {
        Player player0 = new Player();
        addObject(player0, 320, 240);
    }

    private void SpawnNumbers() {
        for (int i = 0; i < 9; i++) {
            this.SpawnNumber();
        }
    }

    public void SpawnNumber() {
        Number number = new Number(this._goalNumber);
        addObject(number, Greenfoot.getRandomNumber(50), Greenfoot.getRandomNumber(50));
    }

    public void InitiateLevelAndScore() {
        if (getObjects(Text.class).size() > 0) {
            removeObjects(getObjects(Text.class));
        }

        addObject(new Text("Επίπεδο : " + level), 550, 10);
        addObject(new Text("Πόντοι : " + score), 550, 30);
        addObject(new Text("Ο στόχος είναι ο αριθμός : " + this._goalNumber), 10, 10);
        addObject(new Text("Μέχρι στιγμής το άθροισμα είναι : " + currentSum), 10, 30);
        String t = String.format("%.0f", (this.duration / 1000.0));
        addObject(new Text("Χρόνος : " + t + " δευτερόλεπτα"), 240, 50);
        addObject(new GreenfootTimer(this.duration), 0, 0);
    }
}
