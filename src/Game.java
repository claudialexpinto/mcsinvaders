import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    public static Player player;
    private Field field;
    public static Enemy enemy;
    private Enemy2 enemy2;
    private Enemy3 enemy3;
    private Enemy4 enemy4;
    private Keyboard keyboard;
    private boolean enemyCollision;
    private boolean playerCollision;
    Picture newPic = new Picture(700, 100, "resources/ritaNormal.png");

    public Game(double width, double height) {
        this.field = new Field(width, height);
        this.enemy = new Enemy(10000, this.field, 0, 50);
        this.enemy2 = new Enemy2(3, this.field, 700, 50);
        this.enemy3 = new Enemy3(10, this.field, 700, 50);
        this.enemy4 = new Enemy4(15, this.field, 700, 50);
        this.player = new Player(this.field);
        this.keyboard = new Keyboard(this);
        this.enemyCollision = false;
        this.playerCollision = false;
    }

    public void start() {
        field.init();
        //  while(true) {
        player.start();
        while (!enemyCollision && !playerCollision) {
            if (enemy.getHealth() > 0) {
                enemy.start();
            } else if (enemy2.getHealth() > 0) {
                System.out.println(enemy.getHealth());
                enemy2.start();
            } else if (enemy3.getHealth() > 0) {
                enemy3.start();
            } else if (enemy4.getHealth() > 0) {
                enemy4.start();
            }
            //enemy4.start();
            player.shot();
            collisionDetector4(player, enemy);
            //System.out.println(enemy.getHealth());
            //System.out.println(player.getHealth());
        }
    }

    public void restart() {
        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_R);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(start);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            this.player.setHealth(3);
            this.enemy.setHealth(0);
            start();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public void collisionDetector4(Player player, Enemy enemy) {

        if (player.getBullets(player.getBulletCounter()) == null) {
            return;
        }
        System.out.println("passed");

        for (int i = player.getBullets(player.getBulletCounter()).getX(); i <= player.getBullets(player.getBulletCounter()).getX() + 100; i++) {
            for (int j = enemy.getX(); j <= enemy.getX() + 100; j++) {
                if (player.getBullets(player.getBulletCounter()).getY() <= 300 &&
                        player.getBullets(player.getBulletCounter()).getX() >= enemy.getX() &&
                        player.getBullets(player.getBulletCounter()).getX() <= enemy.getX() + 100) {
                    System.out.println("Enemy down");
                    this.enemyCollision = true;
                }
            }
        }
    }

    public void collisionDetector3(Player player, Enemy enemy) {
        if (player.getBullets(player.getBulletCounter()) == null) {
            return;
        }
        for (int i = player.getBullets(player.getBulletCounter()).getX(); i <= player.getBullets(player.getBulletCounter()).getX() + 100; i++) {
            for (int j = player.getBullets(player.getBulletCounter()).getY(); i <= player.getBullets(player.getBulletCounter()).getY() + 300; j++) {
                if (j >= enemy.getX() && j <= enemy.getEnemy().getWidth() &&
                        i <= 700 && i >= 500) {
                    System.out.println("Enemy down");
                    this.enemyCollision = true;
                }
            }
        }
    }

    public void collisionDetector2(Player player, Enemy enemy) {

        if (player.getBullets(player.getBulletCounter()) == null) {
            return;
        }

        for (int i = player.getBullets(player.getBulletCounter()).getX(); i <= player.getBullets(player.getBulletCounter()).getX() + player.getBullets(player.getBulletCounter()).getBullet().getWidth(); i++) {
            for (int j = player.getBullets(player.getBulletCounter()).getY(); i <= player.getBullets(player.getBulletCounter()).getY() + player.getBullets(player.getBulletCounter()).getBullet().getHeight(); j++) {
                if (i >= enemy.getX() && i <= enemy.getX() + enemy.getBullet(enemy.getBulletCounter()).getBullet().getWidth() &&
                        j >= enemy.getY() && j <= enemy.getY() + enemy.getBullet(enemy.getBulletCounter()).getBullet().getHeight()) {
                    System.out.println("Enemy down");
                    this.enemyCollision = true;
                }
            }
        }
        System.out.println("Passed");
    }


    public void collisionDetector(Enemy enemy, Player player) {
        //System.out.println("START");
        if (player.getBullets(player.getBulletCounter()) == null) {
            return;
        }

        for (int i = player.getBullets(player.getBulletCounter()).getBullet().getX(); i <= player.getBullets(player.getBulletCounter()).getBullet().getX()
                + player.getBullets(player.getBulletCounter()).getBullet().getWidth(); i++) {
            for (int j = player.getBullets(player.getBulletCounter()).getBullet().getY(); j <= player.getBullets(player.getBulletCounter()).getBullet().getY() +
                    player.getBullets(player.getBulletCounter()).getBullet().getHeight(); j++) {
                if (j >= enemy.getEnemy().getX() && j <= enemy.getEnemy().getX() + enemy.getEnemy().getWidth() &&
                        j >= enemy.getEnemy().getY() && j <= enemy.getEnemy().getY() + enemy.getEnemy().getHeight()) {
                    this.playerCollision = true;
                    System.out.println("Player down");
                }
            }
        }

        if (enemy.getBullet(enemy.getBulletCounter()) == null) {
            return;
        }

        for (int i = enemy.getBullet(enemy.getBulletCounter()).getBullet().getX(); i <= enemy.getBullet(enemy.getBulletCounter()).getBullet().getX() +
                enemy.getBullet(enemy.getBulletCounter()).getBullet().getWidth(); i++) {
            for (int j = enemy.getBullet(enemy.getBulletCounter()).getBullet().getY(); j <= enemy.getBullet(enemy.getBulletCounter()).getBullet().getY() +
                    enemy.getBullet(enemy.getBulletCounter()).getBullet().getHeight(); j++) {
                if (j >= player.getPlayer().getX() && j <= player.getPlayer().getX() + player.getPlayer().getWidth() &&
                        j >= player.getPlayer().getY() && j >= player.getPlayer().getY() + player.getPlayer().getHeight()) {
                    enemy.setEnemy(newPic);
                    enemy.getEnemy().draw();
                    this.enemyCollision = true;
                    System.out.println("Enemy down");
                }
            }
        }
        System.out.println("FINISH");
    }





            /*if(player.getBullets(player.getBulletCounter()) == null){
                System.out.println("yey");
            } else if(player.getBullets(player.getBulletCounter()).getX() > enemy.getEnemy().getX() &&
                        player.getBullets(player.getBulletCounter()).getX() < enemy.getEnemy().getMaxX() &&
                        player.getBullets(player.getBulletCounter()).getY() == 50){
                System.out.println("Something happened");
            }*/
        /*if(player.getBullets(player.getBulletCounter()) == null ) {
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
        }*/


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
    */

    public class Bullet {
        private Picture bullet;
        private Picture bullet2;
        private Field field;
        private int x;
        private int y;
        private boolean enemyCollision;
        private boolean playerCollision;

        public Bullet(int x, int y, Field field) {
            this.field = field;
            this.bullet = new Picture(x, y, "resources/laserRed.png");
            this.bullet2 = new Picture(x, y, "resources/laserGreen.png");

            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void bulletMove(Directions direction) {
            if (direction == Directions.UP) {
                bullet2.draw();
                while (bullet2.getY() > 22) {
                    bullet2.draw();
                    try {
                        Thread.sleep(10);
                        this.bullet2.translate(0, -20);
                        y -= 20;
                        System.out.println("Bullet y: " + this.y);
                        System.out.println("Bullet x: " + this.x);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                    //collisionDetector();
                    //System.out.println(bullet.getY());
                }
            } else if (direction == Directions.DOWN) {
                bullet.draw();
                while (bullet.getY() < field.getHeight() - 22) {
                    try {
                        Thread.sleep(10);
                        this.bullet.translate(0, 20);
                        y += 20;
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            bullet.delete();
            bullet2.delete();
        }

        public Picture getBullet() {
            return this.bullet;
        }

        public void collisionDetector4(Player player, Enemy enemy) {

            if (player.getBullets(player.getBulletCounter()) == null) {
                return;
            }
            System.out.println("passed");

            for (int i = player.getBullets(player.getBulletCounter()).getX(); i <= player.getBullets(player.getBulletCounter()).getX() + 100; i++) {
                for (int j = enemy.getX(); j <= enemy.getX() + 100; j++) {
                    if (player.getBullets(player.getBulletCounter()).getY() <= 300 &&
                            player.getBullets(player.getBulletCounter()).getX() >= enemy.getX() &&
                            player.getBullets(player.getBulletCounter()).getX() <= enemy.getX() + 100) {
                        System.out.println("Enemy down");
                        this.enemyCollision = true;
                    }
                }
            }
        }
    }
}

