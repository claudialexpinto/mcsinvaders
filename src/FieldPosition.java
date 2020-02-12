import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class FieldPosition {
    private int x;
    private int y;
    private Rectangle rectangle;
    private Field field;

    public FieldPosition(int x, int y, Field field){
        this.field = field;
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        show();
    }

    public void show(){
        this.rectangle.fill();
    }

    public void hide(){
        this.rectangle.delete();;
    }





}
