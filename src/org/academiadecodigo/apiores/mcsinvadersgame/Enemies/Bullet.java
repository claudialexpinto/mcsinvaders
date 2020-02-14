package org.academiadecodigo.apiores.mcsinvadersgame.Enemies;

import org.academiadecodigo.apiores.mcsinvadersgame.Enemies.Enemies.Boss;
import org.academiadecodigo.apiores.mcsinvadersgame.Enemies.Enemies.Jojo;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet {
    private Picture bullet;
    private Picture bullet2;
    private Field field;
    private int x;
    private int y;
    public static boolean enemyDown;
    public static boolean playerDown;

    public Bullet(int x, int y, Field field) {
        this.field = field;
        this.bullet = new Picture(x, y, "resources/Bullet/laserRed.png");
        this.bullet2 = new Picture(x, y, "resources/Bullet/laserGreen.png");

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
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
                //collisionDetector();
                //System.out.println(bullet.getY());
            }
        } else if (direction == Directions.DOWN) {
            bullet.draw();
            while (bullet.getY() < field.getHeight() - 30) {
                try {
                    Thread.sleep(10);
                    this.bullet.translate(0, 20);
                    y += 20;
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        collisionDetectorE(Game.player, Game.enemy);
        collisionDetectorP(Game.player, Game.enemy);
        bullet.delete();
        bullet2.delete();
    }

    public Picture getBullet() {
        return this.bullet;
    }

    public void collisionDetectorE(Player player, Boss enemy) {

        if (player.getBullets(player.getBulletCounter()) == null) {
            return;
        }
        // System.out.println("passed");

        for (int i = player.getBullets(player.getBulletCounter()).getX(); i <= player.getBullets(player.getBulletCounter()).getX() + 100; i++) {
            for (int j = enemy.getX(); j <= enemy.getX() + 100; j++) {
                if (player.getBullets(player.getBulletCounter()).getY() <= 400 &&
                        player.getBullets(player.getBulletCounter()).getX() >= enemy.getX() &&
                        player.getBullets(player.getBulletCounter()).getX() <= enemy.getX() + 100) {
                    //System.out.println("MC down");
                    Game.enemyHit = true;
                    bullet.delete();
                    if (enemy.getHealth() <= 0) {
                        //enemy.getEnemy().load("");
                        enemy.getEnemy().draw();
                        enemy.getEnemy().delete();
                    }
                }
            }
        }
    }


    public void collisionDetectorP(Player player, Boss enemy) {

        if (enemy.getBullet(enemy.getBulletCounter()) == null) {
            return;
        }
        //System.out.println("passed");

        for (int i = enemy.getBullet(enemy.getBulletCounter()).getX(); i <= enemy.getBullet(enemy.getBulletCounter()).getX() + 100; i++) {
            for (int j = player.getX(); j <= player.getX() + 100; j++) {
                if (enemy.getBullet(enemy.getBulletCounter()).getY() >= 700 &&
                        enemy.getBullet(enemy.getBulletCounter()).getX() >= player.getX() &&
                        enemy.getBullet(enemy.getBulletCounter()).getX() <= player.getX() + 100) {
                    Game.playerHit = true;
                    bullet.delete();
                   // System.out.println(player.getHealth());
                    if (player.getHealth() < 0) {
                        player.setHealth(0);
                        player.getPlayer().delete();
                    }
                }
            }

        }
    }

    public void collisionDetector(Jojo enemy, Player player) {
        for (int i = bullet.getX(); i <= bullet.getX() + bullet.getWidth(); i++) {
            for (int j = bullet.getY(); j <= bullet.getY() + bullet.getHeight(); j++) {
                if (j >= enemy.getEnemy().getX() && j <= enemy.getEnemy().getX() + enemy.getEnemy().getWidth() &&
                        j >= enemy.getEnemy().getY() && j <= enemy.getEnemy().getY() + enemy.getEnemy().getHeight()) {
                    this.enemyDown = true;
                }
            }
        }
        for (int i = bullet.getX(); i <= bullet.getX() + bullet.getWidth(); i++) {
            for (int j = bullet.getY(); j <= bullet.getY() + bullet.getHeight(); j++) {
                if (j >= player.getPlayer().getX() && j <= player.getPlayer().getX() + player.getPlayer().getWidth() &&
                        j >= player.getPlayer().getY() && j >= player.getPlayer().getY() + player.getPlayer().getHeight()) {
                    this.enemyDown = true;
                }
            }
        }
    }
}

/*    public void movement() {
        while (bullet.getY()<field.getHeight()-20) {
            bullet.draw();
            bullet.translate(0, 0.0001);
        }
    }*/
