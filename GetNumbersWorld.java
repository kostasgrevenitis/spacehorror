import greenfoot.*;

public class GetNumbersWorld extends World {
    private int spawnedNumbers;
    private int xOffset = 0;
    private int _goalNumber = -1;

    public int playerLifes = 5;
    
    public static int score = 0;
    public static int level = 0;

    public GetNumbersWorld(int goalNumber) {
        super(640, 480, 1);
        this._goalNumber = goalNumber;
        level++;
        int img = Greenfoot.getRandomNumber(3) + 1;
        this.setBackground(new GreenfootImage("background00" + img + ".jpg"));
        this.setPaintOrder(
            Text.class, 
            PlayerLife.class, 
            GameOver.class, 
            Number.class, 
            Explosion.class, 
            Projectile.class,
            Player.class);

        this.BuildLifes();
        this.SpawnPlayer();
        this.SpawnNumbers();
        this.InitiateLevelAndScore();
        GreenfootSound backgroundMusic = new GreenfootSound("Dark-noise-sound-effect.mp3");
        backgroundMusic.setVolume(40);
        backgroundMusic.playLoop();
        Greenfoot.playSound("electriccurrent.mp3");
    }

    private void BuildLifes() {
        for (int i = 0; i < playerLifes; i++) {
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
        //Για να σιγουρέψουμε ότι δημιουργείται ο εχθρός μακριά από το παίχτη
        Number number = new Number(this._goalNumber);
        addObject(number, Greenfoot.getRandomNumber(50), Greenfoot.getRandomNumber(50));
    }

    public void InitiateLevelAndScore() {
        if (getObjects(Text.class).size() > 2) {
            Text level = (Text) getObjects(Text.class).get(0);
            if (level != null) {
                this.removeObject(level);
            }

            Text score = (Text) getObjects(Text.class).get(1);
            if (score != null) {
                this.removeObject(score);
            }
        }

        addObject(new Text("Επίπεδο : " + level), 550, 10);
        addObject(new Text("Πόντοι : " + score), 550, 30);
        addObject(new Text("Ο στόχος είναι ο αριθμός " + this._goalNumber ), 10, 10);
        addObject(new Text("Μέχρι στιγμής το άθροισμα είναι "), 10, 30);
        GreenfootTimer t = new GreenfootTimer(120);
        addObject(t, 250, 50);
    }
}
