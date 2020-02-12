import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet {
    private Rectangle bullet;
    private FieldPosition bulletPos;
    private int distanceByMove;
    private Directions bulletDirection;

    public Bullet(int x, int y, Field field) {
        this.distanceByMove = 1;
        bullet = new Rectangle(x, y, 30, 30);
        bullet.fill();
    }

    public void bulletMove(Directions direction, int distanceByMove) {

            if(direction == Directions.UP) {
                while (bullet.getY() > 15) {
                    bullet.fill();
                    bullet.translate(0, -distanceByMove);
                    bullet.delete();
                }
            }
            if(direction.equals(Directions.DOWN)){
                while (bullet.getY() < 830) {
                    bullet.fill();
                    bullet.translate(0, distanceByMove);
                    bullet.delete();
                }
            }
            bullet.fill();
        }
    }
