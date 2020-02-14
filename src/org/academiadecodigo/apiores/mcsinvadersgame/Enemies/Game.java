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
    public static Boss enemy2;
    public static Boss enemy3;
    public static Boss enemy4;
    private Keyboard keyboard;
    private boolean enemyDead;
    private boolean playerDead;
    public static boolean playerHit;
    public static boolean enemyHit;
    public static int boss;
    public static Boss enemy;

    public Game(double width, double height) {
        this.field = new Field(width, height);
        this.enemy1 = new Jojo(3, this.field, 700, 50);
        this.enemy2 = new Rita(3, this.field, 700, 50);
        this.enemy3 = new Ricardo(3, this.field, 700, 50);
        this.enemy4 = new Soraia(3, this.field, 700, 50);
        this.player = new Player(this.field);
        this.keyboard = new Keyboard(this);
        this.enemyDead = false;
        this.playerDead = false;
    }



    public void start() {
        //restart();
        field.init();
        //  while(true) {
        //restart();
        player.start();
        while (!enemyDead && !playerDead) {


            if (enemy1.getHealth() > 0) {
                enemy = enemy1;
                enemy.start();
            } else if (enemy2.getHealth() > 0) {
                enemy = enemy2;
                enemy.start();
            } else if (enemy3.getHealth() > 0) {
                enemy = enemy3;
                enemy.start();
            } else if (enemy4.getHealth() > 0) {
                enemy = enemy4;
                enemy.start();
            }

            if (enemyHit) {
                /*if(enemy1.getHealth() == 0){
                    enemy1.setHealth(enemy1.getHealth()-1);
                    enemyHit = false;
                } else if(enemy2.getHealth() == 0){
                    enemy2.setHealth(enemy2.getHealth()-1);
                    enemyHit = false;
                }*/
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

    public void restart() {
        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_R);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(start);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            this.player.setHealth(3);
            this.enemy1.setHealth(5);
            this.enemy2.setHealth(5);
            this.enemy3.setHealth(5);
            this.enemy4.setHealth(5);
            this.enemy4.setHealth(5);
            start();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }


}

