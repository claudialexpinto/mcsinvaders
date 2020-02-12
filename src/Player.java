import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {
    private Rectangle player;
    private int x;
    private int y;
    private int width;
    private int height;
    private Field field;
    private Keyboard keyboard;
    private int distanceMoved;
    private Bullet[] bullets;
    private int bulletCounter;


    public Player(Field field) {
        this.field = field;
        this.keyboard = new Keyboard(this);
        this.x = 644;
        this.y = 749;
        this.width = 100;
        this.height = 50;
        this.distanceMoved = 1;
        this.bullets = new Bullet[20];
        this.bulletCounter = 0;
    }

    public void start() {
        this.player = new Rectangle(this.x, this.y, this.width, this.height);
        this.player.fill();
        init();
    }


    public void init( ){

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent shoot = new KeyboardEvent();
        shoot.setKey(KeyboardEvent.KEY_SPACE);
        shoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        /*KeyboardEvent stop = new KeyboardEvent();
        stop.setKey(KeyboardEvent.KEY_LEFT);
        stop.setKeyboardEventType(KeyboardEventType.KEY_RELEASED); //Falta uma parte que involva o "key released" para implementar corretamente a classe

        KeyboardEvent stop2 = new KeyboardEvent();
        stop2.setKey(KeyboardEvent.KEY_RIGHT);
        stop2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);*/

        keyboard.addEventListener(shoot);
    }

    public void shot(){
        if(bulletCounter == 10){
            bulletCounter = 0;
        }
        bullets[bulletCounter] = new Bullet(player.getX() + 100,player.getY(),field);
        bullets[bulletCounter].bulletMove(Directions.UP,10);
        bulletCounter++;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            shot();
        }
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                player.translate(- 10, 0);
                //rectangle.set
                break;
            case KeyboardEvent.KEY_RIGHT:
                if(player.getX() < field.getWidth() - player.getWidth()) {
                    player.translate(10, 0);
                    break;
                }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){};
}