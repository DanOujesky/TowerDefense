import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.TimerTask;

public class GamePanel extends JPanel implements Runnable{

    public static final int WIDTH = 900;
    public static final int HEIGHT = 900;
    public static final int FPS = 60;
    public static int HEALTH = 20;
    public static int COINS = 0;
    private boolean gameOver = false;
    Thread gameThread;
    PlayManager playmanager;
    Background background;
    private static ArrayList<Enemy> enemies = new ArrayList<>();
    public GamePanel(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(null);

        playmanager = new PlayManager();
        background = new Background();

    }
    public void addEnemy(String name){
        switch (name) {
            case "enemy1":
                enemies.add(new Enemy(new File("pictures/Enemies/Enemy_1.png"), 10,2,1, 10));
                break;
            case "enemy2":
                enemies.add(new Enemy(new File("pictures/Enemies/Enemy_2.png"), 5, 5,1,5));
                break;
            case "enemy3":
                enemies.add(new Enemy(new File("pictures/Enemies/Enemy_3.png"), 5, 10,1, 8));
                break;
        }
    }
    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();

    }
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        int timer = 0;

        while(!gameOver) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)  / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                timer++;
                if (timer % 65 == 0) {
                    addEnemy("enemy1");
                }
                if (timer % 150 == 0 ) {
                    addEnemy("enemy2");
                }
                if (timer > 300 && timer % 20 == 0) {
                    addEnemy("enemy3");
                }
                if (HEALTH < 1) {
                    gameThread.interrupt();
                    gameOver = true;
                }

            }
        }

    }
    public void update(){
        playmanager.update();
        for (int i =0; i < enemies.size(); i++) {
            if (enemies.get(i).isDeath() == true) {
                enemies.remove(enemies.get(i));
            }
            enemies.get(i).update();
        }
    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        playmanager.draw(graphics2D);
        background.draw(graphics2D);
        for (int i =0; i < enemies.size(); i++) {
            enemies.get(i).draw(graphics2D);
        }
    }
}
