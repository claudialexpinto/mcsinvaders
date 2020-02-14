package org.academiadecodigo.apiores.mcsinvadersgame;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.text.FieldPosition;

public class Field {

    private static final double PADDING = 10;

    private double width;
    private double height;

    private Picture field;

    public Field(double width, double height){
        this.width = width;
        this.height = height;
        field = new Picture(PADDING,PADDING,"resources/GameImages/background.png");
    }

    public void init(){
        field.draw();
    }

    public double getHeight() {
        return field.getHeight();
    }

    public double getWidth() {
        return field.getWidth();
    }

    public double getX(){
        return field.getX();
    }

    public double getY(){
        return field.getY();
    }

}
