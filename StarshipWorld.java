import greenfoot.*;

public class StarshipWorld extends World {
    public int spawnedEnemies;
    public int playerLifes = 5;
    private int xOffset = 0;

    public static int score = 0;
    public static int level = 0;

    public StarshipWorld() {
        super(640, 480, 1);
        level++;
        int img = Greenfoot.getRandomNumber(3) + 1;
        this.setBackground(new GreenfootImage("background00" + img + ".jpg"));
        this.setPaintOrder(Text.class, PlayerLife.class, GameOver.class, Enemy.class, Explosion.class, Projectile.class,
                Player.class, Portal.class);

        this.BuildLifes();
        this.SpawnPlayer();
        this.BuildPortal();
        this.SpawnEnemies();
        this.InitiateLevelAndScore();
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
        Text shotFiredText = new Text("Ammo spent : 0/15");
        addObject(shotFiredText, 10, 10);
    }

    private void BuildPortal() {
        Portal portal0 = new Portal();
        addObject(portal0, 320, 240);
    }

    private void SpawnEnemies() {
        this.spawnedEnemies = (Greenfoot.getRandomNumber(4) + 1);
        addObject(new Text("Spiders left : " + spawnedEnemies), 10, 30);
        for (int i = 0; i < spawnedEnemies; i++) {
            this.SpawnEnemy();
        }
    }

    public void SpawnEnemy() {
        //Για να σιγουρέψουμε ότι δημιουργείται ο εχθρός μακριά από το παίχτη
        Enemy enemy = new Enemy();
        addObject(enemy, Greenfoot.getRandomNumber(50), Greenfoot.getRandomNumber(50));
    }

    public void InitiateLevelAndScore() {
        if (getObjects(Text.class).size() > 2) {
            Text level = (Text) getObjects(Text.class).get(2);
            if (level != null) {
                this.removeObject(level);
            }

            Text score = (Text) getObjects(Text.class).get(2);
            if (score != null) {
                this.removeObject(score);
            }
        }

        addObject(new Text("Level : " + level), 550, 10);
        addObject(new Text("Score : " + score), 550, 30);
    }
}
