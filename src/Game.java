import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Game {

    private Player player;
    private Field field;
    private Enemy enemy;

    public Game(double width, double height) {
        this.field = new Field(width, height);
        this.enemy = new Enemy(3, this.field, 700, 50);
        this.player = new Player(this.field);
    }

    public void start(){
        field.init();
        //  while(true) {
        player.start();
        while (true)  {
           enemy.start();
           player.shot();
           collisionDetector(player,enemy);
            //System.out.println(enemy.getHealth());
            //System.out.println(player.getHealth());
        }
    }

    private void collisionDetector(Player player, Enemy enemy){

        if(enemy.getBullet(enemy.getBulletCounter()) == null ){
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
    }

}
