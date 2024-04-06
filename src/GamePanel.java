import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
    Background background;
    private static ArrayList<Enemy> enemies = new ArrayList<>();
    private static ArrayList<Tower> towers = new ArrayList<>();
    JButton myButton = new JButton("Button");
    public GamePanel(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(null);
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseListener());
        this.add(myButton);

        background = new Background();
        myButton.setBounds(60, 750, 100, 100);
        myButton.addActionListener(new MyButtonListener(0,0,5,5,10, new File("pictures/Towers/Tower_1.png")));
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
    public static void addTower(Tower tower){
        towers.add(tower);
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
        for (int i =0; i < enemies.size(); i++) {
            if (enemies.get(i).isDeath() == true) {
                enemies.remove(enemies.get(i));
            }
            enemies.get(i).update();
        }
        for (int i =0; i < towers.size(); i++) {
            towers.get(i).update();
        }

    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        background.draw(graphics2D);
        try {
            graphics2D.drawImage(ImageIO.read(new File("pictures/Health_Bar/Health_Bar_" + HEALTH + ".png")), -40,-80, 240, 240, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i =0; i < enemies.size(); i++) {
            enemies.get(i).draw(graphics2D);
        }
        for (int i =0; i < towers.size(); i++) {
            towers.get(i).update();
        }
        for (int i =0; i < towers.size(); i++) {
            towers.get(i).draw(graphics2D);
        }

    }
}
