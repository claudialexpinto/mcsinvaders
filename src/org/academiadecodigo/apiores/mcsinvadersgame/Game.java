package org.academiadecodigo.apiores.mcsinvadersgame;

import org.academiadecodigo.apiores.mcsinvadersgame.Enemies.*;
import org.academiadecodigo.apiores.mcsinvadersgame.Enemies.*;
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
    public static Boss enemy;
    public Picture startKey;
    public Picture reStartKey;
    private boolean gameStart;
    private boolean gameRestart;

    public Game(double width, double height) {
        this.field = new Field(width, height);
        this.enemy3 = new Jojo(15, this.field, 700, 50);
        this.enemy1 = new Rita(5, this.field, 700, 50);
        this.enemy2 = new Ricardo(8, this.field, 700, 50);
        this.enemy4 = new Soraia(20, this.field, 700, 50);
        this.player = new Player(this.field);
        this.keyboard = new Keyboard(this);
        this.enemyDead = false;
        this.playerDead = false;
        this.gameStart = false;
        this.gameRestart = false;
        this.startKey = new Picture(field.getX(), field.getY(), "resources/GameImages/MAIN MENU.png");
        this.reStartKey = new Picture(field.getX(), field.getY(), "resources/GameImages/GameOver.png");
        Sound music = new Sound(" resources/Music/[Electro] - Tut Tut Child - Hot Pursuit [Monstercat Release].wav");
        music.setLoop(50);
    }

    public void init() {

        this.gameStart = false;
        gameControls();
        while (!gameStart) {
            this.startKey.draw();
        }
       this.startKey.delete();

        start();

    }

    public void reStart() {

        this.gameRestart = false;
        gameControls();
        while (!gameRestart) {
            this.reStartKey.draw();
        }
        this.reStartKey.delete();

        init();

    }

    public void start() {
        field.init();
        //  while(true) {
        player.start();

        while (!enemyDead && !playerDead) {

            if (enemy1.getHealth() > 0) {
                enemy = enemy1;
                enemy.start();

            } else if (enemy2.getHealth() > 0) {
                this.enemy.getEnemy().delete();
                enemy = enemy2;
                enemy.start();

            } else if (enemy3.getHealth() > 0) {
                this.enemy.getEnemy().delete();
                enemy = enemy3;
                enemy.start();

            } else if (enemy4.getHealth() > 0) {
                this.enemy.getEnemy().delete();
                enemy = enemy4;
                enemy.start();

            } else if (enemy.getHealth() <= 0) {
                this.enemy.getEnemy().delete();

            }

            if (enemyHit) {
                enemy.setHealth(enemy.getHealth() - 1);
                enemyHit = false;
            }

            if (playerHit) {
                player.setHealth(player.getHealth() - 1);
                playerHit = false;

            }
            if (player.getHealth() <= 0) {
                playerDead = true;
                player.getPlayer().delete();

            }

            player.shot();
        }

        playerDead=false;
        player.setHealth(3);
        reStart();
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


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_R:
                if (!gameRestart) {
                    this.gameRestart = true;
                }
                break;
            case KeyboardEvent.KEY_S:
                if (!gameStart) {
                   /* this.player = new Player(this.field);
                    this.enemy3 = new Jojo(15, this.field, 700, 50);
                    this.enemy1 = new Rita(5, this.field, 700, 50);
                    this.enemy2 = new Ricardo(8, this.field, 700, 50);
                    this.enemy4 = new Soraia(20, this.field, 700, 50);*/
                    this.gameStart = true;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }


}

