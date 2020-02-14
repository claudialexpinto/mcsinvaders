package org.academiadecodigo.apiores.mcsinvadersgame.Enemies;

import org.academiadecodigo.apiores.mcsinvadersgame.Bullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Boss {

    private int health;
    private int x;
    private int y;
    private Picture enemy;
    private int bulletCounter;
    private Bullet[] bullet;


    public int getBulletCounter() {
        return bulletCounter;
    }

    public Bullet getBullet(int i) {
        return bullet[i];
    }

    public Picture getEnemy() {
        return enemy;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void start(){
        if(health == 0){
            this.enemy.delete();
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
