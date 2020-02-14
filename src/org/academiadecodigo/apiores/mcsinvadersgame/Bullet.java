package org.academiadecodigo.apiores.mcsinvadersgame;

import org.academiadecodigo.apiores.mcsinvadersgame.Enemies.Boss;
import org.academiadecodigo.apiores.mcsinvadersgame.Enemies.Jojo;
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
        this.bullet = new Picture(x, y, "resources/Enemies/laserRed.png");
        this.bullet2 = new Picture(x, y, "resources/Players/laserGreen.png");
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
            while (bullet2.getY() > 20) {
                bullet2.draw();
                try {
                    Thread.sleep(10);
                    this.bullet2.translate(0, -20);
                    y -= 20;
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } else if (direction == Directions.DOWN) {
            bullet.draw();
            while (bullet.getY() < field.getHeight() - bullet.getHeight() - 10) {
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

        for (int i = player.getBullets(player.getBulletCounter()).getX(); i <= player.getBullets(player.getBulletCounter()).getX() + 100; i++) {
            for (int j = enemy.getX(); j <= enemy.getX() + 100; j++) {
                if (player.getBullets(player.getBulletCounter()).getY() <= 400 &&
                        player.getBullets(player.getBulletCounter()).getX() >= enemy.getX() &&
                        player.getBullets(player.getBulletCounter()).getX() <= enemy.getX() + 100) {
                    Game.enemyHit = true;
                    if (enemy.getHealth() <= 0) {
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

        for (int i = enemy.getBullet(enemy.getBulletCounter()).getX(); i <= enemy.getBullet(enemy.getBulletCounter()).getX() + 100; i++) {
            for (int j = player.getX(); j <= player.getX() + 100; j++) {
                if (enemy.getBullet(enemy.getBulletCounter()).getY() >= 700 &&
                        enemy.getBullet(enemy.getBulletCounter()).getX() >= player.getX() &&
                        enemy.getBullet(enemy.getBulletCounter()).getX() <= player.getX() + 100) {
                    Game.playerHit = true;

                    if (player.getHealth() < 0) {
                        player.setHealth(0);
                        player.getPlayer().delete();
                    }
                }
            }

        }
    }
}


