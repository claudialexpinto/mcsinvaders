/*import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyListener implements KeyboardHandler{
    private Rectangle rectangle;
    private int distance;
    private Keyboard keyboard;

    public void init( ){

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        /*KeyboardEvent shoot = new KeyboardEvent();
        shoot.setKey(KeyboardEvent.KEY_SPACE);
        shoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        */
        /*KeyboardEvent stop = new KeyboardEvent();
        stop.setKey(KeyboardEvent.KEY_LEFT);
        stop.setKeyboardEventType(KeyboardEventType.KEY_RELEASED); //Falta uma parte que involva o "key released" para implementar corretamente a classe

        KeyboardEvent stop2 = new KeyboardEvent();
        stop2.setKey(KeyboardEvent.KEY_RIGHT);
        stop2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);*/

        //keyboard.addEventListener(shoot);
/*    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                rectangle.translate(rectangle.getX() - distance, 0);
                //rectangle.set
            case KeyboardEvent.KEY_RIGHT:
                rectangle.translate(rectangle.getX() + distance, 0);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){};
}
*/