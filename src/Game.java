import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Game {

    private Player player;
    private Field field;
    private Enemy enemy;

    public Game(double width, double height) {
        this.field = new Field(width, height);
        this.enemy = new Enemy(3, field, 700, 50);
        this.player = new Player(field);
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

        collisionDetector(player,enemy);
    }

    private void collisionDetector(Player player, Enemy enemy) {
        if (enemy.getBullet(enemy.getBulletCounter()) == null) {
            System.out.println("nuul");
            return;
        } else if (player.getPlayer().getX() == (enemy.getBullet(enemy.getBulletCounter()).getX()) &&
                player.getPlayer().getY() == enemy.getBullet(enemy.getBulletCounter()).getY()) {
            System.out.println("kabum");
        }


        if (player.getBullets(player.getBulletCounter()) == null) {
            return;
        } else if (enemy.getEnemy().getX() == (player.getBullets(player.getBulletCounter()).getX()) &&
                enemy.getEnemy().getY() == player.getBullets(player.getBulletCounter()).getY()) {
            System.out.println("tatatatatau");
        }
        System.out.println(enemy.getEnemy().getX() + " enemy x");
        System.out.println(enemy.getEnemy().getY() + " enemy y");
        System.out.println(player.getBullets(player.getBulletCounter()).getX() + " player bullet x");
        System.out.println(player.getBullets(player.getBulletCounter()).getY() + " player bullet y");
        //System.out.println(player.getPlayer().getY() + " player y");
        //System.out.println(enemy.getBullet(enemy.getBulletCounter()).getY() + " enemy bullet y");
        //System.out.println(enemy.getBullet(enemy.getBulletCounter()).getX() + " enemy bullet x");
    }

}
