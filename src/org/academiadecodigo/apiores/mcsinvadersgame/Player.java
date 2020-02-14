package org.academiadecodigo.apiores.mcsinvadersgame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements KeyboardHandler {
    private Picture player;
    private int x;
    private int y;
    //private int width;
    //private int height;
    private Field field;
    private Keyboard keyboard;
    private Bullet[] bullets;
    private int bulletCounter;
    private Bullet bullet;
    private int health;


    public Player(Field field) {
        this.health = 3;
        this.field = field;
        this.keyboard = new Keyboard(this);
        this.x = 644;
        this.y = 749;
        //this.width = 100;
        //this.height = 50;
        this.bullets = new Bullet[10];
        this.bulletCounter = 0;
        this.player = new Picture(this.x, this.y,"resources/Players/player.png");
        /*for(int i = 0; i < bulletCounter; i++){
            bullets[i] = new Bullet(player.getX() + (player.getWidth()/2) , player.getY() + player.getHeight(), this.field);
        }*/
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void start() {
        this.player.draw();
        init();
    }

    public int getBulletCounter() {
        return bulletCounter;
    }

    public Picture getPlayer() {
        return player;
    }

    public int getY() {
        return y;
    }


    public int getX() {
        return x;
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

        /*KeyboardEvent shoot = new KeyboardEvent();
        shoot.setKey(KeyboardEvent.KEY_SPACE);
        shoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(shoot);


        /*KeyboardEvent stop = new KeyboardEvent();
        stop.setKey(KeyboardEvent.KEY_LEFT);
        stop.setKeyboardEventType(KeyboardEventType.KEY_RELEASED); //Falta uma parte que involva o "key released" para implementar corretamente a classe

        KeyboardEvent stop2 = new KeyboardEvent();
        stop2.setKey(KeyboardEvent.KEY_RIGHT);
        stop2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);*/
    }

    public Bullet getBullets(int i) {
        return bullets[i];
    }

    public void shot(){
        Sound laser = new Sound(" resources/Music/Laser Gun Sound Effect (1).wav");
        laser.play(true);
        if(bulletCounter == 9){
            bulletCounter = 0;
        }
        bullets[bulletCounter] = new Bullet(player.getX() + (player.getWidth()/2),player.getY()  - 10,field);
        bullets[bulletCounter].bulletMove(Directions.UP);
        bulletCounter++;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        /*if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            shot();
        }*/
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if(player.getX() > 15) {
                    player.translate(-10, 0);
                    x = x-10;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if(player.getX() < field.getWidth() - player.getWidth()) {
                    player.translate(10, 0);
                    x = x + 10;
                }
                break;
        }
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){};
}