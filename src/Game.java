import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Game {

    private Player player;
    private Field field;
    private Enemy enemy;

    public Game(double width, double height) {
        this.field = new Field(width, height);
    }

 /*   public void start() throws InterruptedException {
        while (true) {
            Thread.sleep(200);
            //player.start();
        }
    }
*/
    public void init() {

        field.init();

        this.enemy = new Enemy(3, field);
        this.player = new Player(field);
        player.start();
        // enemy.start();
    }
}
