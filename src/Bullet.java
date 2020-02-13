import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet {
    private Picture bullet;
    private Field field;
    private int x;
    private int y;

    public Bullet(int x, int y, Field field) {
        this.field = field;
        this.bullet = new Picture(x, y, "resources/laserRed.png");
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
            bullet.load("resources/laserGreen.png");
            bullet.draw();
            while (bullet.getY() > 22) {
                bullet.draw();
                this.bullet.translate(0, -0.00035);
            }
        } else if (direction == Directions.DOWN) {
            while (bullet.getY() < field.getHeight() - 22) {
                bullet.draw();
                bullet.translate(0, 0.00035);
            }
        }
        bullet.delete();
    }

    public Picture getBullet() {
        return this.bullet;
    }

/*    public void movement() {
        while (bullet.getY()<field.getHeight()-20) {
            bullet.draw();
            bullet.translate(0, 0.0001);
        }
    }*/
}
