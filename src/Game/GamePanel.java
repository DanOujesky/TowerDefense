package Game;

import Game.Background;

import javax.swing.*;
import java.awt.*;

/**
 * this class will create JPanel and creates a game thread
 */
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
    TowerButton_1 tower1 = new TowerButton_1();
    CanonButton_1 canon = new CanonButton_1();
    static JButton speedButton = new JButton(new ImageIcon("pictures/Speed_icons/Speed_icon_1x.png"));
    MyMouseListener myMouseListener = new MyMouseListener();
    MySpellButton mySpellButton = new MySpellButton();

    MySpellButtonFreeze mySpellButtonFreeze = new MySpellButtonFreeze();
    Waves waves = new Waves();
    MyWaveButton myWaveButton = new MyWaveButton(waves);
    PlayButton playButton;
    SettingsButton settingsButton;
    ExitButton exitButton;

    /**
     * assign variables
     */
    public GamePanel(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(null);
        playButton = new PlayButton(this);
        settingsButton = new SettingsButton(this);
        exitButton = new ExitButton(this);

    }

    /**
     * adds buttons to JFrame
     */
    public void showGameMenu() {
        this.add(playButton);
        this.add(settingsButton);
        this.add(exitButton);
    }

    /**
     * adds buttons and create object and start a new thread
     */
    public void launchGame(){

        this.addMouseListener(new MyMouseListener());
        this.setFocusable(true);
        this.add(tower1);
        this.add(canon);
        this.add(speedButton);
        this.add(myWaveButton);
        this.add(mySpellButton);
        this.add(mySpellButtonFreeze);

        background = new Background();
        towerManager = new TowerManager();
        enemyManager = new EnemyManager();
        bulletManager = new BulletManager();
        healthBar = new HealthBar(20);
        coinBar = new CoinBar(18);

        speedButton.setBounds(800, 800, 60, 60);
        myWaveButton.setBorder(BorderFactory.createEmptyBorder());
        speedButton.setBorder(BorderFactory.createEmptyBorder());
        myWaveButton.setContentAreaFilled(false);
        speedButton.setContentAreaFilled(false);

        speedButton.addActionListener(new SpeedButtonListener());

        gameThread = new Thread(this);
        gameThread.start();

    }

    /**
     * every second it will call update and repaint methods
     */
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
                if (mySpellButtonFreeze.isFreezeWasUsed()) {
                    mySpellButtonFreeze.decreaseTimer();
                    if (mySpellButtonFreeze.run()) {
                        updateAll(true);
                    } else {
                        updateAll(false);
                    }
                } else {
                   updateAll(true);
                }
                repaint();
                delta--;
                if (HealthBar.HEALTH < 1) {
                    gameOver = true;
                }
            }
        }
        repaint();
    }

    /**
     * update all components
     * @param enemyUpdate
     */
    public void updateAll(boolean enemyUpdate){
        update(enemyUpdate);
        if (SpeedButtonListener.speed == 2) {
            update(enemyUpdate);
        }  if (SpeedButtonListener.speed == 4) {
            update(enemyUpdate);
            update(enemyUpdate);
        }
    }

    /**
     * update all components
     * @param enemyUpdate
     */
    public void update(boolean enemyUpdate){
        if (enemyUpdate) enemyManager.update();
        bulletManager.update();
        towerManager.update();
        if (waves.wave) {
            if (waves.resetColdowns) {
                mySpellButtonFreeze.resetColdDown();
                mySpellButton.resetColdDown();
            }
            waves.update();
        }
        myMouseListener.updatePositions();
    }

    /**
     * draw all components
     * @param graphics the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        try {
            background.draw(graphics2D);
            if (mySpellButton.isPlaceSpell()) mySpellButton.draw(graphics2D);
            healthBar.draw(graphics2D);
            enemyManager.draw(graphics2D);
            towerManager.draw(graphics2D);
            bulletManager.draw(graphics2D);
            coinBar.draw(graphics2D);
            if (myWaveButton.visible) myWaveButton.draw(graphics2D);
            if (gameOver && waves.waveCount != 13) {
                graphics2D.setFont(new Font("Arial", 1,145));
                graphics2D.setColor(Color.RED);
                graphics2D.drawString("GAME OVER", 0,450);
            }
            if (waves.waveCount == 13) {
                graphics2D.setFont(new Font("Arial", 1,145));
                graphics2D.setColor(Color.YELLOW);
                graphics2D.drawString("YOU WON", 100,450);
            }
        }catch (NullPointerException e) {}



    }


    public void hideGameMenu() {
        settingsButton.setVisible(false);
        playButton.setVisible(false);
        exitButton.setVisible(false);

    }

}
