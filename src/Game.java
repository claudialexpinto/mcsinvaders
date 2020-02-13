import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Game {

    private Player player;
    private Field field;
    private Enemy enemy;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private Enemy4 enemy4;

    public Game(double width, double height) {
        this.field = new Field(width, height);
        this.enemy = new Enemy(3, field, 700, 50);
        this.enemy2 = new Enemy2(3, field, 700, 50);
        this.player = new Player(field);
        this.enemy3 = new Enemy3(3, field, 700, 50);
        this.enemy4 = new Enemy4(3, field, 700, 50);
    }

    public void start() throws InterruptedException {

        //  while(true) {
        player.start();
        while (true) {
            init();
            Thread.sleep(300);
        }
        // }
    }

    public void init() {

        field.init();

        enemy.start();

        collisionDetector(player, enemy);
    }

    private void collisionDetector(Player player, Enemy enemy) {
        if (enemy.getBullet(enemy.getBulletCounter()) == null) {
            return;
        } else if (player.getPlayer().getX() == (enemy.getBullet(enemy.getBulletCounter()).getX()) &&
                player.getPlayer().getY() == enemy.getBullet(enemy.getBulletCounter()).getY()) {
            player.setHealth(player.getHealth() - 1);
        }


        if (player.getBullets(player.getBulletCounter()) == null) {
            return;
        } else if (enemy.getEnemy().getX() == (player.getBullets(player.getBulletCounter()).getX()) &&
                enemy.getEnemy().getY() == player.getBullets(player.getBulletCounter()).getY()) {
            enemy.setHealth(enemy.getHealth() - 1);
        }
        //System.out.println(enemy.getEnemy().getX() + " enemy x");
        // System.out.println(enemy.getEnemy().getY() + " enemy y");
        //  System.out.println(player.getBullets(player.getBulletCounter()).getX() + " player bullet x");
        //  System.out.println(player.getBullets(player.getBulletCounter()).getY() + " player bullet y");
        //System.out.println(player.getPlayer().getY() + " player y");
        //System.out.println(enemy.getBullet(enemy.getBulletCounter()).getY() + " enemy bullet y");
        //System.out.println(enemy.getBullet(enemy.getBulletCounter()).getX() + " enemy bullet x");
    }

}
