import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet {
    private Rectangle bullet;
    private FieldPosition bulletPos;
    private int distanceByMove;
    private Directions bulletDirection;
    private int x;
    private int y;

    public Bullet(int x, int y, Field field) {
        this.distanceByMove = 1;
        this.x = x;
        this.y = y;
        bullet = new Rectangle(this.x, this.y, 30, 30);
        bullet.delete();
    }

    public void bulletMove(Directions direction, int distanceByMove) {

            if(direction == Directions.UP) {
                while (bullet.getY() > 30) {
                    bullet.fill();
                    this.y = this.y - distanceByMove;
                    bullet.translate(0, y - distanceByMove);
                    //bullet.delete();
                }
            }
            if(direction.equals(Directions.DOWN)){
                while (bullet.getY() < 800) {
                    bullet.fill();
                    this.y = this.y + distanceByMove;
                    bullet.translate(0, y + distanceByMove);
                   // bullet.delete();
                }
            }
            bullet.fill();
        }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
