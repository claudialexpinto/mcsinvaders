import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Enemy {
    private Rectangle enemy;
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

    public Enemy(int health, Field field, int x, int y) {
        this.health = health;
        this.field = field;
        this.dead = false;
        this.bullets = new Bullet[20];
        this.bulletCounter = 0;
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 50;
        this.movement = true;
        this.enemy = new Rectangle(this.x, this.y, this.width, this.height);
    }

    public void start() {
        this.enemy.fill();
        move();
    }

    public void ShootBack() {
        if (bulletCounter == 10) {
            bulletCounter = 0;
        }
        bullets[bulletCounter] = new Bullet(this.x, this.y, field);
        bullets[bulletCounter].bulletMove(Directions.DOWN, 10);
        bulletCounter++;
    }


    public void lateralMove(){
            int movement;
            for (movement = enemy.getX(); movement >= 0; movement--) {
                int random = (int) (Math.random() * 10);

                enemy.translate(-10, 0);
                if (random == 5) {
                    //Thread.sleep(100);
                    ShootBack();
                    enemy.translate(-10, 0);
                    break;
                }
                if (movement == 0) {
                    break;
                }
            }
            if (movement == 0) {
                for (movement = enemy.getX(); movement < field.getWidth(); movement++) {
                    int random = (int) (Math.random() * 10);

                    enemy.translate(10, 0);
                    if (random == 5) {
                        //Thread.sleep(100);
                        ShootBack();
                        enemy.translate(10, 0);
                        break;
                    }
                    if (movement == 139) {
                        break;
                    }
                }
            }
            if (movement == 139) {
                for (movement = enemy.getX(); movement >= 0; movement--) {
                    int random = (int) (Math.random() * 10);

                    enemy.translate(-10, 1);
                    if (random == 5) {
                        ShootBack();
                        enemy.translate(-10, 1);
                        break;
                    }
                    if (movement == 0) {
                        break;
                    }
                }
            }
    }

    public void move(){

        enemy.delete();
        if(movement){ // RIGHT
            if(enemy.getX() > field.getWidth() - width){
                enemy.fill();
                movement = false;
                return;
            } else {
                    enemy.translate(100, 0);
                    enemy.fill();
            }
            return;
        }

        if(!movement){ //LEFT
            if(enemy.getX() <= field.getx() + 100){
                enemy.fill();
                movement = true;
                return;
            } else {
                enemy.translate(-100,0);
                enemy.fill();

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

    public boolean isDead() {
        return dead;
    }
}

