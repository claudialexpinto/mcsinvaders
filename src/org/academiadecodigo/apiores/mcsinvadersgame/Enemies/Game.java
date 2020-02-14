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
    public static Boss enemy;
    private Boss enemy2;
    private Boss enemy3;
    private Boss enemy4;
    private Keyboard keyboard;
    private boolean enemyDead;
    private boolean playerDead;
    public static boolean playerHit;
    public static boolean enemyHit;
    public static int boss;

    public Game(double width, double height) {
        this.field = new Field(width, height);
        this.enemy = new Jojo(10, this.field, 700, 50);
        this.enemy2 = new Rita(3, this.field, 700, 50);
        this.enemy3 = new Ricardo(10, this.field, 700, 50);
        this.enemy4 = new Soraia(15, this.field, 700, 50);
        this.player = new Player(this.field);
        this.keyboard = new Keyboard(this);
        this.enemyDead = false;
        this.playerDead = false;
        this.boss = 1;
    }

    public void start() {
        field.init();
        //  while(true) {
        player.start();
        while (!enemyDead && !playerDead) {



            if (enemy.getHealth() > 0) {
                enemy.start();
            } else if (enemy2.getHealth() > 0) {
                System.out.println(enemy.getHealth());
                enemy2.start();
            } else if (enemy3.getHealth() > 0) {
                enemy3.start();
            } else if (enemy4.getHealth() > 0) {
                enemy4.start();
            }

            if(enemyHit){
                enemy.setHealth(enemy.getHealth() - 1);
                enemyHit = false;
            }

            if(playerHit){
                player.setHealth(player.getHealth()-1);
                playerHit = false;
            }
            if(player.getHealth() < 0){
                playerDead = true;
            }

            //enemy4.start();
            player.shot();

            //System.out.println(enemy.getHealth());
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
            this.enemy.setHealth(0);
            start();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }









            /*if(player.getBullets(player.getBulletCounter()) == null){
                System.out.println("yey");
            } else if(player.getBullets(player.getBulletCounter()).getX() > enemy.getEnemy().getX() &&
                        player.getBullets(player.getBulletCounter()).getX() < enemy.getEnemy().getMaxX() &&
                        player.getBullets(player.getBulletCounter()).getY() == 50){
                System.out.println("Something happened");
            }*/
        /*if(player.getBullets(player.getBulletCounter()) == null ) {
            return;
        } else if (player.getBullets(player.getBulletCounter()).getX() > enemy.getEnemy().getX() &&
                player.getBullets(player.getBulletCounter()).getX() < enemy.getEnemy().getMaxX() &&
                player.getBullets(player.getBulletCounter()).getY() > enemy.getEnemy().getY() &&
                player.getBullets(player.getBulletCounter()).getY() < enemy.getEnemy().getMaxY()){
            enemy.setHealth(enemy.getHealth()-1);
        }

        if(enemy.getBullet(enemy.getBulletCounter()) == null) {
            return;
        } else if (enemy.getBullet(enemy.getBulletCounter()).getX() > player.getPlayer().getX() &&
                enemy.getBullet(enemy.getBulletCounter()).getX() < player.getPlayer().getMaxX() &&
                enemy.getBullet(enemy.getBulletCounter()).getY() > player.getPlayer().getY() &&
                enemy.getBullet(enemy.getBulletCounter()).getY() < player.getPlayer().getMaxY()){
            player.setHealth(player.getHealth()-1);
        }*/


       /* if(enemy.getBullet(enemy.getBulletCounter()) == null ){
            return;
        }else if(player.getPlayer().getX() == (enemy.getBullet(enemy.getBulletCounter()).getX()) &&
        player.getPlayer().getY() == enemy.getBullet(enemy.getBulletCounter()).getY()){
            player.setHealth(player.getHealth() - 1);
        }
        if(player.getBullets(player.getBulletCounter()) == null){
            return;
        }else if(enemy.getEnemy().getX() == (player.getBullets(player.getBulletCounter()).getX()) &&
        enemy.getEnemy().getY() == player.getBullets(player.getBulletCounter()).getY()){
            enemy.setHealth(enemy.getHealth() - 1);
        }
        System.out.println(enemy.getBullet(enemy.getBulletCounter()).getY());
    */

    public class Bullet {
        private Picture bullet;
        private Picture bullet2;
        private Field field;
        private int x;
        private int y;
        private boolean enemyCollision;
        private boolean playerCollision;

        public Bullet(int x, int y, Field field) {
            this.field = field;
            this.bullet = new Picture(x, y, "resources/laserRed.png");
            this.bullet2 = new Picture(x, y, "resources/laserGreen.png");

            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void bulletMove(Directions direction) {
            if (direction == Directions.UP) {
                bullet2.draw();
                while (bullet2.getY() > 22) {
                    bullet2.draw();
                    try {
                        Thread.sleep(10);
                        this.bullet2.translate(0, -20);
                        y -= 20;
                        System.out.println("Bullet y: " + this.y);
                        System.out.println("Bullet x: " + this.x);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                    //collisionDetector();
                    //System.out.println(bullet.getY());
                }
            } else if (direction == Directions.DOWN) {
                bullet.draw();
                while (bullet.getY() < field.getHeight() - 22) {
                    try {
                        Thread.sleep(10);
                        this.bullet.translate(0, 20);
                        y += 20;
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            bullet.delete();
            bullet2.delete();
        }

        public Picture getBullet() {
            return this.bullet;
        }

        public void collisionDetector4(Player player, Jojo enemy) {

            if (player.getBullets(player.getBulletCounter()) == null) {
                return;
            }
            System.out.println("passed");

            for (int i = player.getBullets(player.getBulletCounter()).getX(); i <= player.getBullets(player.getBulletCounter()).getX() + 100; i++) {
                for (int j = enemy.getX(); j <= enemy.getX() + 100; j++) {
                    if (player.getBullets(player.getBulletCounter()).getY() <= 300 &&
                            player.getBullets(player.getBulletCounter()).getX() >= enemy.getX() &&
                            player.getBullets(player.getBulletCounter()).getX() <= enemy.getX() + 100) {
                        System.out.println("Jojo down");
                        this.enemyCollision = true;
                    }
                }
            }
        }
    }
}

