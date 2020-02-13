import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    private Player player;
    private Field field;
    private Enemy enemy;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private Enemy4 enemy4;
    private Keyboard keyboard;

    public Game(double width, double height) {
        this.field = new Field(width, height);
        this.enemy = new Enemy(5, field, 700, 50);
        this.enemy2 = new Enemy2(10, field, 700, 50);
        this.player = new Player(field);
        this.enemy3 = new Enemy3(15, field, 700, 50);
        this.enemy4 = new Enemy4(20, field, 700, 50);
        this.keyboard = new Keyboard(this);
    }

    public void restart(){
        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_R);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(start);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            try {
                start();
            } catch (InterruptedException ex){
                System.out.println("Restart not possible");
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){}




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
        if (enemy.getHealth() > 0) {
            enemy.start();
        } else if (enemy2.getHealth() > 0) {
            enemy2.start();
        } else if (enemy3.getHealth() > 0) {
            enemy3.start();
        } else {
            restart();
        }

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
