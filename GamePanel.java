import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements KeyListener {
    Player player;  // define variables
    ArrayList<Wall> walls = new ArrayList<>(); // create arraylists to contain map components
    ArrayList<Coin> coins = new ArrayList<>();
    Timer gameTimer;

    public GamePanel(){
        player = new Player(60, 650, this); // player spawn location
        makeWalls();
        makeCoins();
        gameTimer = new Timer(); // create a timer
        gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.set();
                repaint();
            }
        }, 0, 17); // update player position on panel

    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        player.draw(gtd);
        for (Wall wall: walls){
            wall.draw(gtd);
        }
        for (Coin coin: coins){
            coin.draw(gtd);
        }
    }
    public void makeWalls() {
        Random r = new Random();
        int n = 0;
        //36 by 26 square space, boundary walls
        for (int i = 0; i < 100; i++) {
            walls.add(new Wall(0, 25 * i, 25, 25, Color.WHITE));
            walls.add(new Wall(25 * i, 0, 25, 25, Color.white));
            walls.add(new Wall(25 * i, 700, 25, 25, Color.WHITE));
            walls.add(new Wall(975, 25 * i, 25, 25, Color.WHITE));
        }
        //randomized platform generator
        while (n < 50) {
            int n1 = r.nextInt(35) + 1;
            int n2 = r.nextInt(23) + 4;
            int n3 = r.nextInt(36) + 1;
            int n4 = r.nextInt(23) + 4;
            int n5 = r.nextInt(36) + 1;
            int n6 = r.nextInt(23) + 4;

            for (int j = 0; j < 3; j++) {
                walls.add(new Wall((j + n1) * 25, n2 * 25, 25, 25, Color.green));
                if (j < 0) {
                    walls.add(new Wall((j + n3) * 25, n4 * 25, 25, 25, Color.green));
                }
                if (j < 1) {
                    walls.add(new Wall((j + n5) * 25, n6 * 25, 25, 25, Color.green));
                }
            }
            n += 1;
        }
    }

    public void makeCoins(){
        coins.add(new Coin(485, 30, 25,25));
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==37) // left arrow
            player.keyLeft = true;
        if (e.getKeyCode()== 38) // up arrow
            player.keyUp = true;
        if (e.getKeyCode()== 39) // right arrow
            player.keyRight = true;
    }
    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode()== 37)
                player.keyLeft = false;
        if (e.getKeyCode()== 38)
                player.keyUp = false;
        if (e.getKeyCode()== 39)
                player.keyRight = false;
    }
    public boolean playerGetFinish(){
        return player.getFinish();
    }
}
