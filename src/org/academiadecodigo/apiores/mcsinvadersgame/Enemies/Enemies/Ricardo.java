package org.academiadecodigo.apiores.mcsinvadersgame.Enemies.Enemies;

import org.academiadecodigo.apiores.mcsinvadersgame.Enemies.Bullet;
import org.academiadecodigo.apiores.mcsinvadersgame.Enemies.Directions;
import org.academiadecodigo.apiores.mcsinvadersgame.Enemies.Field;
import org.academiadecodigo.simplegraphics.pictures.Picture;
public class Ricardo extends Boss{
    private Picture enemy;
    private int health;
    private boolean dead;
    private Field field;
    private Bullet[] bullets;
    private int bulletCounter;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean movement;


    public Ricardo(int health, Field field, int x, int y) {
        this.health = health;
        this.field = field;
        this.dead = false;
        this.bullets = new Bullet[20];
        this.bulletCounter = 0;
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 25;
        this.movement = true;
        this.enemy = new Picture(this.x, this.y, "resources/Enemies/Ricardo/rickyMoveRightN.png");
    }
    public void start() {
        this.enemy.draw();
        move();
        int random = (int) (Math.ceil(Math.random() * 10));
        if (random > 7) {
            shootBack();
        }
    }
    public void shootBack() {
        if (bulletCounter == 10) {
            bulletCounter = 0;
        }
        bulletCounter++;
        bullets[bulletCounter] = new Bullet(enemy.getX() + (enemy.getWidth()/2) , enemy.getY() + enemy.getHeight(), this.field);
        bullets[bulletCounter].bulletMove(Directions.DOWN);
    }
    public void move() {
        enemy.delete();
        int random = (int)(Math.ceil(Math.random()*10));
        if (random < 5){
            movement = true;
        } else {
            movement = false;
        }
        if (movement) { // RIGHT
            if (enemy.getX() > field.getWidth() - enemy.getWidth()) {
                enemy.draw();
                movement = false;
                return;
            } else {
                enemy.translate(100, 0);
                x += 100;
                enemy.draw();
            }
            return;
        }
        if (!movement) { //LEFT
            if (enemy.getX() <= field.getX() + 15) {
                enemy.draw();
                movement = true;
                return;
            } else {
                enemy.translate(-100, 0);
                x -= 100;
                enemy.draw();
            }
            return;
        }
    }

    public Bullet getBullet(int i) {
        return bullets[i];
    }
    public int getBulletCounter() {
        return bulletCounter;
    }
    public Picture getEnemy() {
        return enemy;
    }
    public boolean isDead() {
        return dead;
    }

    public int getHealth() {
        return health;
    }
}