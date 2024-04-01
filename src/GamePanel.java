import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    public static final int WIDTH = 900;
    public static final int HEIGHT = 900;
    private static final int FPS = 60;
    Thread gameThread;
    PlayManager playmanager;
    Background background;
    Enemy enemy;
    public GamePanel(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(null);

        playmanager = new PlayManager();
        background = new Background();
        enemy = new Enemy();
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

        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)  / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
    public void update(){
        playmanager.update();
        if (enemy.isDeath() == false) {
            enemy.update();
        }
    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        playmanager.draw(graphics2D);
        background.draw(graphics2D);
        if (enemy.isDeath() == false) {
            enemy.draw(graphics2D);
        }


    }
}
