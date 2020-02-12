import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Game {

    private Player player;
    private Field field;
    private Enemy enemy;

    public Game(double width, double height) {
        this.field = new Field(width, height);
        this.enemy = new Enemy(3, field, 700, 25);
        this.player = new Player(field);
    }

    public void start() throws InterruptedException {

        //  while(true) {
        player.start();
        while (true) {
            init();
            Thread.sleep(300);
        }
        // }
    }

    public void init() {

        field.init();

        enemy.start();
    }
}
