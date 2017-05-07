import greenfoot.*;

public class StarshipWorld extends World {
    public int locationX;
    public int locationY;
    public int spawnedEnemies;
    private int xOffset = 0;

    public StarshipWorld() {
        super(640, 480, 1);
        //https://www.greenfoot.org/files/javadoc/greenfoot/World.html#setPaintOrder-java.lang.Class...-
        this.setPaintOrder(
            Text.class, 
            PlayerLife.class, 
            GameOver.class, 
            Enemy.class, 
            Explosion.class, 
            Projectile.class,
            Player.class, 
            Portal.class);

        this.BuildLifes();
        this.SpawnPlayer();
        this.BuildPortal();
        this.SpawnEnemies();
    }

        private void BuildLifes() {
        int startLives = 5;
        for (int i = 0; i < startLives; i++) {
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
        locationX = Greenfoot.getRandomNumber(50);
        locationY = Greenfoot.getRandomNumber(50);

        Enemy enemy = new Enemy();
        addObject(enemy, locationX, locationY);
    }
}
