package org.academiadecodigo.apiores.mcsinvadersgame.Enemies;

import org.academiadecodigo.apiores.mcsinvadersgame.Enemies.Enemies.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    public static Player player;
    private Field field;
    public static Boss enemy1;
    private static Boss enemy2;
    private Boss enemy3;
    private Boss enemy4;
    private Keyboard keyboard;
    private boolean enemyDead;
    private boolean playerDead;
    public static boolean playerHit;
    public static boolean enemyHit;
    public static int boss;
    public static Boss enemy;
    public Picture startKey;
    public Picture reStartKey;

    public Game(double width, double height) {
        this.field = new Field(width, height);
        this.enemy1 = new Jojo(10, this.field, 700, 50);
        this.enemy2 = new Rita(3, this.field, 700, 50);
        this.enemy3 = new Ricardo(10, this.field, 700, 50);
        this.enemy4 = new Soraia(15, this.field, 700, 50);
        this.player = new Player(this.field);
        this.keyboard = new Keyboard(this);
        this.enemyDead = false;
        this.playerDead = false;
        this.boss = 1;
        this.enemy = enemy1;
    }

    public void start() {
        field.init();
        //  while(true) {
        player.start();
        while (!enemyDead && !playerDead) {


            if (enemy1.getHealth() > 0) {
                enemy = enemy1;
                enemy.start();
            /*} else if (enemy2.getHealth() > 0) {
                enemy = enemy2;
                enemy.start();*/
            } else if (enemy3.getHealth() > 0) {
                enemy = enemy3;
                enemy.start();
            } else if (enemy4.getHealth() > 0) {
                enemy = enemy4;
                enemy.start();
            }

            if (enemyHit) {
                enemy.setHealth(enemy.getHealth() - 1);
                System.out.println("Enemy health: " + enemy.getHealth());
                enemyHit = false;
            }

            if (playerHit) {
                player.setHealth(player.getHealth() - 1);
                playerHit = false;
            }
            if (player.getHealth() < 0) {
                playerDead = true;
            }

            //enemy4.start();
            player.shot();

            //System.out.println(enemy1.getHealth());
            //System.out.println(player.getHealth());
        }
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_R:
                reStart();
                reStartKey.delete();
                this.player.setHealth(3);
                start();
                break;
            case KeyboardEvent.KEY_S:
                start();
                startKey.delete();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public void init() {
        this.startKey = new Picture(field.getx(), field.getY(), "");
        this.startKey.draw();
        gameControls();
    }

    public void reStart() {
        this.reStartKey = new Picture(field.getx(), field.getY(), "");
        this.reStartKey.draw();
        gameControls();
    }

    public void gameControls() {
        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_S);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(start);

        KeyboardEvent reStart = new KeyboardEvent();
        reStart.setKey(KeyboardEvent.KEY_R);
        reStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(reStart);
    }


}

