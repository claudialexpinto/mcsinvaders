import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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
                    try{
                        Thread.sleep(10);
                        this.bullet2.translate(0, -20);
                        y -= 20;
                        System.out.println("Bullet y: "+ this.y);
                        System.out.println("Bullet x: " + this.x);
                    }catch (InterruptedException ex){
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
                } catch (InterruptedException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        collisionDetector4(Game.player,Game.enemy);
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
                    //System.out.println("Enemy down");
                    enemy.setHealth(enemy.getHealth() - 1);
                    if (enemy.getHealth() < 0){
                        enemy.setHealth(0);
                        enemy.getEnemy().delete();
                    }
                }
            }
        }
    }

    public void collisionDetector(Enemy enemy, Player player) {
        for (int i = bullet.getX(); i <= bullet.getX() + bullet.getWidth(); i++) {
            for (int j = bullet.getY(); j <= bullet.getY() + bullet.getHeight(); j++) {
                if (j >= enemy.getEnemy().getX() && j <= enemy.getEnemy().getX() + enemy.getEnemy().getWidth() &&
                        j >= enemy.getEnemy().getY() && j <= enemy.getEnemy().getY() + enemy.getEnemy().getHeight()) {
                    this.enemyCollision = true;
                }
            }
        }
        for (int i = bullet.getX(); i <= bullet.getX() + bullet.getWidth(); i++) {
            for (int j = bullet.getY(); j <= bullet.getY() + bullet.getHeight(); j++) {
                if (j >= player.getPlayer().getX() && j <= player.getPlayer().getX() + player.getPlayer().getWidth() &&
                        j >= player.getPlayer().getY() && j >= player.getPlayer().getY() + player.getPlayer().getHeight()) {
                    this.enemyCollision = true;
                }
            }
        }
    }
}

/*    public void movement() {
        while (bullet.getY()<field.getHeight()-20) {
            bullet.draw();
            bullet.translate(0, 0.0001);
        }
    }*/
