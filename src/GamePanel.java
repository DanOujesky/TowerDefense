import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 900;
    public static final int HEIGHT = 900;
    public static int FPS = 60;
    private boolean gameOver = false;
    Thread gameThread;
    Background background;
    TowerManager towerManager;
    EnemyManager enemyManager;
    BulletManager bulletManager;
    HealthBar healthBar;
    CoinBar coinBar;
    JButton tower1 = new JButton(new ImageIcon("pictures/TowerButtons/TowerButton_1.png"));
    JButton canon = new JButton(new ImageIcon("pictures/TowerButtons/TowerButton_2.png"));
    static JButton speedButton = new JButton(new ImageIcon("pictures/Speed_icons/Speed_icon_1x.png"));
    static JButton myWaveButton = new JButton(new ImageIcon("pictures/Wave_icon/Wave_icon.png"));
    MyMouseListener myMouseListener = new MyMouseListener();
    public GamePanel(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(null);
        this.addMouseListener(new MyMouseListener());
        this.setFocusable(true);
        this.add(tower1);
        this.add(canon);
        this.add(speedButton);
        this.add(myWaveButton);


        background = new Background();
        towerManager = new TowerManager();
        enemyManager = new EnemyManager();
        bulletManager = new BulletManager();
        healthBar = new HealthBar(20);
        coinBar = new CoinBar(21);

        tower1.setBounds(120, 750, 100, 100);
        canon.setBounds(235, 750, 100, 100);
        speedButton.setBounds(800, 750, 60, 60);
        myWaveButton.setBounds(0,Background.positionOfFirstTile(), myWaveButton.getIcon().getIconWidth(), myWaveButton.getIcon().getIconHeight());
        myWaveButton.setBorder(BorderFactory.createEmptyBorder());
        speedButton.setBorder(BorderFactory.createEmptyBorder());
        myWaveButton.setContentAreaFilled(false);
        speedButton.setContentAreaFilled(false);

        tower1.addActionListener(new MyTowerButtonListener("Tower_1"));
        canon.addActionListener(new MyTowerButtonListener("Canon_1"));
        speedButton.addActionListener(new SpeedButtonListener());
        myWaveButton.addActionListener(new MyWaveButtonListener());
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

        while(!gameOver) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)  / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                if (SpeedButtonListener.speed == 2) {
                    update();
                }  if (SpeedButtonListener.speed == 4) {
                    update();
                    update();
                }
                repaint();
                delta--;
                if (HealthBar.HEALTH < 1) {
                    gameOver = true;
                }
            }
        }

    }
    public void update(){
        enemyManager.update();
        bulletManager.update();
        towerManager.update();
        if (Waves.wave) {
            Waves.update();
        }
        myMouseListener.updatePositions();


    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        background.draw(graphics2D);
        healthBar.draw(graphics2D);
        enemyManager.draw(graphics2D);
        towerManager.draw(graphics2D);
        bulletManager.draw(graphics2D);
        coinBar.draw(graphics2D);

    }


}
