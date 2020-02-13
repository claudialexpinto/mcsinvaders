import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy {
    private Picture enemy;
    private int health;
    private boolean dead;
    private Field field;
    private Bullet[] bullets;
    private int bulletCounter;
    private int x;
    private int y;
    //private int width;
    //private int height;
    private boolean movement;

    public Enemy(int health, Field field, int x, int y) {
        this.health = health;
        this.field = field;
        this.dead = false;
        this.bullets = new Bullet[20];
        this.bulletCounter = 0;
        this.x = x;
        this.y = y;
        //this.width = 50;
        //this.height = 25;
        this.movement = true;
        this.enemy = new Picture(this.x, this.y, "resources/jojoNormal.png");
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }



    public void start() {
        this.enemy.draw();
            int random = (int) (Math.ceil(Math.random()*20));
            //System.out.println(random);
            if(random >10) {
                shootBack();
                move();
            }
    }

    public void shootBack() {
        if (bulletCounter == 10) {
            bulletCounter = 0;
        }
        bullets[bulletCounter] = new Bullet(enemy.getX() + (enemy.getWidth()/2) , enemy.getY() + enemy.getHeight(), this.field);
        bullets[bulletCounter].bulletMove(Directions.DOWN);
        bulletCounter++;
    }

    public void move(){
        if(movement){ // RIGHT
            if(enemy.getX() > this.field.getWidth() - enemy.getWidth()){
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

        if(!movement){ //LEFT
            if(enemy.getX() <= this.field.getx() + 100){
                movement = true;
                return;
            } else {
                enemy.draw();
                enemy.translate(-100,0);
                x -=100;
                enemy.draw();
            }
            return;
        }
    }

    public void GetHit(int damage) {
        health = damage - health;
        if (health == 0) {
            dead = true;
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
}

