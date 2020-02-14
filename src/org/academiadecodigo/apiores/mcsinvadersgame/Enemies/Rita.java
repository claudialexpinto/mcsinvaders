package org.academiadecodigo.apiores.mcsinvadersgame.Enemies;

import org.academiadecodigo.apiores.mcsinvadersgame.Bullet;
import org.academiadecodigo.apiores.mcsinvadersgame.Directions;
import org.academiadecodigo.apiores.mcsinvadersgame.Field;
import org.academiadecodigo.apiores.mcsinvadersgame.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;
public class Rita extends Boss{
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

    public Rita(int health, Field field, int x, int y) {
        this.health = health;
        this.field = field;
        this.dead = false;
        this.bullets = new Bullet[10];
        this.bulletCounter = 0;
        this.x = x;
        this.y = y;
        //this.width = 50;
        //this.height = 25;
        this.movement = true;
        this.enemy = new Picture(this.x, this.y, "resources/Enemies/Rita/ritaNormal.png");
        //for(int i = 0; i < bulletCounter; i++){
        //  bullets[i] = new Bullet(enemy1.getX() + (enemy1.getWidth()/2) , enemy1.getY() + enemy1.getHeight(), this.field);
        //}
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }



    public void start() {
        this.enemy.draw();
        if(this.health <= 0){
            this.enemy.delete();
        }
        int random = (int) (Math.ceil(Math.random()*20));
        //System.out.println(random);
        if(random >7) {
            shootBack();
            move();
        }
    }

    public void shootBack() {
        Sound laser = new Sound(" resources/Music/Laser Gun Sound Effect (1).wav");
        laser.play(true);
        if (bulletCounter == 9) {
            bulletCounter = 0;
        }
        bullets[bulletCounter] = new Bullet(enemy.getX() + (enemy.getWidth()/2) , enemy.getY() + enemy.getHeight(), this.field);
        bullets[bulletCounter].bulletMove(Directions.DOWN);
        bulletCounter++;
    }

    public void move(){
        if(movement){ // RIGHT
            if(enemy.getX() >= this.field.getWidth() - (enemy.getWidth()+100)){
                enemy.draw();
                movement = false;
                return;
            } else {
                try{
                    Thread.sleep(10);
                    enemy.translate(200, 0);
                    x += 200;
                    enemy.draw();
                }catch (InterruptedException ex){
                    System.out.println(ex.getMessage());
                }
            }
            return;
        }

        if(!movement){ //LEFT
            enemy.delete();
            if(enemy.getX() - 200 <= this.field.getX()){
                movement = true;
                return;
            } else {
                try{
                    Thread.sleep(10);
                    enemy.translate(-200, 0);
                    x -= 200;
                    enemy.draw();
                }catch (InterruptedException ex){
                    System.out.println(ex.getMessage());
                }
            }
            return;
        }
    }



    public Bullet getBullet(int i) {
        return bullets[i];
    }

    public Picture getEnemy() {
        return enemy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBulletCounter() {
        return bulletCounter;
    }

    public boolean isDead() {
        return dead;
    }

    public void setEnemy(Picture enemy) {
        this.enemy = enemy;
    }
}
