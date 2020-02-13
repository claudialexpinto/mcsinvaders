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

    public void start() throws InterruptedException {
        field.init();
        //  while(true) {
        player.start();
        while (true)  {
            //Thread.sleep(200);
           enemy.start();
           player.shot();
        }
        // }
    }
/*
    public void init() {

       ;


    }
*/}
