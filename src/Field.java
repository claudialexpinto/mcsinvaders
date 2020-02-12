import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.text.FieldPosition;

public class Field {

    private static final double PADDING = 10;

    private double width;
    private double height;

    private Rectangle field;

    public Field(double width, double height){
        this.width = width;
        this.height = height;
    }

    public void init(){
        this.field = new Rectangle(PADDING,PADDING,width,height);
        this.field.draw();
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getx(){
        return this.field.getX();
    }

    public double getY(){
        return this.field.getY();
    }

}
