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
        this.enemy = new Enemy(1, this.field, 700, 50);
        this.enemy2 = new Enemy2(3,this.field, 700, 50);
        this.enemy3 = new Enemy3(10,this.field,700,50);
        this.enemy4 = new Enemy4(15, this.field, 700, 50);
        this.player = new Player(this.field);
        this.keyboard = new Keyboard(this);
    }

    public void start(){
        field.init();
        //  while(true) {
        player.start();
        while (true)  {
            if(enemy.getHealth() > 0){
                enemy.start();
            } else if (enemy2.getHealth() > 0){
                enemy2.start();
            } else if (enemy3.getHealth() > 0){
                enemy3.start();
            } else if(enemy4.getHealth() > 0){
                enemy4.start();
            }
           //enemy4.start();
           player.shot();
           collisionDetector(player,enemy);
            //System.out.println(enemy.getHealth());
            //System.out.println(player.getHealth());
        }
    }

    public void restart(){
        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_R);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(start);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_R){
                this.player.setHealth(3);
                this.enemy.setHealth(0);
                start();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){}

    private void collisionDetector(Player player, Enemy enemy){
        if(player.getBullets(player.getBulletCounter()) == null ) {
            return;
        } else if (player.getBullets(player.getBulletCounter()).getX() > enemy.getEnemy().getX() &&
                player.getBullets(player.getBulletCounter()).getX() < enemy.getEnemy().getMaxX() &&
                player.getBullets(player.getBulletCounter()).getY() > enemy.getEnemy().getY() &&
                player.getBullets(player.getBulletCounter()).getY() < enemy.getEnemy().getMaxY()){
            enemy.setHealth(enemy.getHealth()-1);
        }

        if(enemy.getBullet(enemy.getBulletCounter()) == null) {
            return;
        } else if (enemy.getBullet(enemy.getBulletCounter()).getX() > player.getPlayer().getX() &&
                enemy.getBullet(enemy.getBulletCounter()).getX() < player.getPlayer().getMaxX() &&
                enemy.getBullet(enemy.getBulletCounter()).getY() > player.getPlayer().getY() &&
                enemy.getBullet(enemy.getBulletCounter()).getY() < player.getPlayer().getMaxY()){
            player.setHealth(player.getHealth()-1);
        }


       /* if(enemy.getBullet(enemy.getBulletCounter()) == null ){
            return;
        }else if(player.getPlayer().getX() == (enemy.getBullet(enemy.getBulletCounter()).getX()) &&
        player.getPlayer().getY() == enemy.getBullet(enemy.getBulletCounter()).getY()){
            player.setHealth(player.getHealth() - 1);
        }
        if(player.getBullets(player.getBulletCounter()) == null){
            return;
        }else if(enemy.getEnemy().getX() == (player.getBullets(player.getBulletCounter()).getX()) &&
        enemy.getEnemy().getY() == player.getBullets(player.getBulletCounter()).getY()){
            enemy.setHealth(enemy.getHealth() - 1);
        }
        System.out.println(enemy.getBullet(enemy.getBulletCounter()).getY());
    */}

}
