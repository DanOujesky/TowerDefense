package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * this class represents tower
 */
public class Tower {
    private double x,y, attackSpeed, damage, prize;
    private int range;
    private BufferedImage towerImage, towerImageLevel2, towerImageLevel3, towerImageLevel4, towerImageLevel5;
    String name;
    private boolean placeTower = false;
    private boolean placeTowerFirst = true;
    private Enemy enemyTarget = null;
    private int clock;
    private Rectangle towerBounds;
    private boolean towerMenu = false;
    private MyUpgradeButton upgradeButton;
    private MySellButton mySellButton;
    private TowerButton towerButton;
    int level;
    int maxLevel;

    /**
     * assign values and variables
     * @param x
     * @param y
     * @param attackSpeed
     * @param damage
     * @param prize
     * @param maxLevel
     * @param towerFile
     * @param name
     * @param range
     */
    public Tower(double x, double y, double attackSpeed,  double damage, double prize, int maxLevel, File towerFile, String name, int range) {
        try {
            towerImage = ImageIO.read(towerFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.x = x;
        this.y = y;
        this.attackSpeed = attackSpeed;
        this.damage = damage;
        this.prize = prize;
        this.name = name;
        this.range = range;
        this.maxLevel = maxLevel;
        towerBounds = new Rectangle((int) x, (int)y,towerImage.getWidth(), towerImage.getHeight());
        level = 1;
        if (name.equals("Tower_1")) {
            try {
                towerImageLevel2 = ImageIO.read(new File("pictures/Towers/Tower_1(level2).png"));
                towerImageLevel3 = ImageIO.read(new File("pictures/Towers/Tower_1(level3).png"));
                towerImageLevel4 = ImageIO.read(new File("pictures/Towers/Tower_1(level4).png"));
                towerImageLevel5 = ImageIO.read(new File("pictures/Towers/Tower_1(level5).png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (name.equals("Canon_1")) {
            try {
                towerImageLevel2 = ImageIO.read(new File("pictures/Towers/Canon_1(level2).png"));
                towerImageLevel3 = ImageIO.read(new File("pictures/Towers/Canon_1(level3).png"));
                towerImageLevel4 = ImageIO.read(new File("pictures/Towers/Canon_1(level4).png"));
                towerImageLevel5 = ImageIO.read(new File("pictures/Towers/Canon_1(level5).png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * this method will return the distance between tower and enemy
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public static int getDistance(double x1, double y1, double x2,  double y2){
        double xDiff = Math.abs(x1 -x2);
        double yDiff = Math.abs(y1 - y2);
        return (int) Math.hypot(xDiff, yDiff);
    }

    /**
     * this method will update hit box of the tower
     */
    public void updateHitBox(){
        towerBounds.x = (int) x;
        towerBounds.y = (int) y;
    }

    /**
     * this method will return true if enemy is in the tower range
     * @return
     */
    private boolean isThereEnemy(){
        boolean trueFalse = false;
        double range;
        for (int i =0; i < EnemyManager.getEnemies().size(); i++) {
            range = getDistance(x, y,EnemyManager.getEnemies().get(i).getX(), EnemyManager.getEnemies().get(i).getY());
            if (checkTowerRange(range)) {
                trueFalse = true;
                break;
            }
        }
        return trueFalse;

    }

    /**
     * this method will return true if enemy target is in the tower range
     * @return
     */
    private boolean checkEnemyTarget(){
        int range = getDistance(x , y,enemyTarget.getX(), enemyTarget.getY());
        return checkTowerRange(range);
    }

    /**
     * this method sets enemy target
     */
    public void setEnemyTarget(){
        for (int i =0; i < EnemyManager.getEnemies().size(); i++) {
            double range = getDistance(x, y,EnemyManager.getEnemies().get(i).getX(), EnemyManager.getEnemies().get(i).getY());
            if (checkTowerRange(range)) {
                enemyTarget = EnemyManager.getEnemies().get(i);
                break;
            }
        }
    }

    /**
     * this method will return if tower range is less than range between tower and enemy
     * @param range
     * @return
     */
    public boolean checkTowerRange(double range){
        return range < this.range/2+16;
    }

    /**
     * if tower does not have enemy target it will set one, and then it will shoot a bullet
     */
    public void shoot(){
        if (enemyTarget == null) {
            setEnemyTarget();
        } else {
            if (!checkEnemyTarget() || enemyTarget.isDeath()) {
                setEnemyTarget();
            }
        }
        BulletManager.newBullet(this);
    }

    /**
     * this method updates tower position and tower shoots
     */
    public void update() {
        if (placeTower) {
            x = MyMouseListener.positionX     - MyMouseListener.positionX%15;
            y =  MyMouseListener.positionY   - MyMouseListener.positionY%15;
            updateHitBox();
            if (MyMouseListener.letfMousePressed && TowerManager.isPlaceable(this)) {
                if (placeTowerFirst)CoinBar.COINS -= prize;
                placeTower = false;
                placeTowerFirst = false;
                towerButton = new TowerButton(this);
                upgradeButton = new MyUpgradeButton(this);
                mySellButton = new MySellButton(this);
                MyWindow.addButton(towerButton);
                MyWindow.addButton(upgradeButton);
                MyWindow.addButton(mySellButton);
            }
            if (placeTowerFirst) if (MyMouseListener.rightMousePressed) TowerManager.removeTower(this);
        } else {
            if (!isCooldownOver()) {
                clock++;
            } else {
                if (isThereEnemy()) {
                    shoot();
                    rotateTower(90);
                    resetCooldown();
                }
            }
        }
        if (!MyMouseListener.leftMouseClicked) towerMenu = false;
        if (upgradeButton!= null) {
            if (towerMenu) {
                if (!upgradeButton.isVisible()) {
                    upgradeButton.clickCount = 0;
                    upgradeButton.changeIcon();
                    mySellButton.clickCount = 0;
                    mySellButton.changeIcon();
                    upgradeButton.setVisible(true);
                    mySellButton.setVisible(true);
                }
            } else {
                if (upgradeButton.isVisible()) {
                    upgradeButton.setVisible(false);
                    mySellButton.setVisible(false);
                }
            }
        }



    }

    /**
     * this method will rotate tower by 90 degrees
     * @param rotate
     */
    public void rotateTower(double rotate) {
        switch (level) {
            case 1:
                towerImage = Enemy.rotateImage(towerImage,rotate);
                break;
            case 2:
                towerImageLevel2 = Enemy.rotateImage(towerImageLevel2,rotate);
                break;
            case 3:
                towerImageLevel3 = Enemy.rotateImage(towerImageLevel3,rotate);
                break;
            case 4:
                towerImageLevel4 = Enemy.rotateImage(towerImageLevel4,rotate);
                break;
            case 5:
                towerImageLevel5 = Enemy.rotateImage(towerImageLevel5,rotate);
                break;
        }
    }

    /**
     * this method will return true if turret coldown is over
     * @return
     */
    public boolean isCooldownOver(){
        return clock >= attackSpeed;
    }

    /**
     * this method will set clock to 0
     */
    public void resetCooldown(){
        clock = 0;
    }


    /**
     * this method will draw tower on the screen
     * @param graphics2D
     */
    public void draw(Graphics2D graphics2D) {
        switch (level) {
            case 1:
                graphics2D.drawImage(towerImage, (int) x - 30, (int) y - 30, null);
                break;
            case 2:
                graphics2D.drawImage(towerImageLevel2, (int) x - 30, (int) y - 30, null);
                break;
            case 3:
                graphics2D.drawImage(towerImageLevel3, (int) x - 30, (int) y - 30, null);
                break;
            case 4:
                graphics2D.drawImage(towerImageLevel4, (int) x - 30, (int) y - 30, null);
                break;
            case 5:
                graphics2D.drawImage(towerImageLevel5, (int) x - 30, (int) y - 30, null);
                break;

        }

        if (placeTower) {
            TowerManager.drawCollisionRect(graphics2D);
        }
        if (towerMenu) {
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawOval((int) x - range/2, (int) y - range/2, this.range, this.range);
            if (upgradeButton.collisionWithMouse()) {
                upgradeButton.draw(graphics2D);
            }
            if (mySellButton.collisionWithMouse()) {
                mySellButton.draw(graphics2D);
            }
        } else {
            if (collisionWithMouse()) {
                graphics2D.setColor(Color.black);
                graphics2D.drawOval((int) x - range/2, (int) y - range/2, this.range, this.range);
            }
        }
    }

    /**
     * this method will return true if mouse is touching the tower
     * @return
     */
    public boolean collisionWithMouse(){
        if (towerBounds.contains(MyMouseListener.positionX+30, MyMouseListener.positionY+30)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * this method will return upgraded values
     * @return
     */
    public int[] getUpgradeValues(){
        int [] towerValues = new int[4];
        towerValues[0] = (int) damage;
        towerValues[1] = (int) attackSpeed;
        towerValues[2] = (int) prize;
        towerValues[3] = range;
        switch (name) {
            case "Tower_1":
                switch (level) {
                    case 1:
                        towerValues[0] = (int) (damage + 1);
                        towerValues[3] = range + 5;
                        break;
                    case 2:
                        towerValues[1] = (int) (attackSpeed - 2);
                        towerValues[2] = 5;
                        towerValues[3] = range + 5;
                        break;
                    case 3:
                        towerValues[0] = (int) (damage + 2);
                        towerValues[2] = 20;
                        break;
                    case 4:
                        towerValues[2] = 9;
                        towerValues[3] = range + 20;
                        break;

                }
                break;
            case "Canon_1":
                switch (level) {
                    case 1:
                        towerValues[0] = (int) (damage + 1);
                        towerValues[2] = 23;
                        break;
                    case 2:
                        towerValues[2]= 12;
                        towerValues[3] = range + 20;
                        break;
                    case 3:
                        towerValues[2]= 10;
                        towerValues[3] = range + 20;
                        break;
                    case 4:
                        towerValues [2] = 5;
                        towerValues[1] = (int) (attackSpeed - 3);
                        break;
                }

        }

        return towerValues;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public Enemy getEnemyTarget() {
        return enemyTarget;
    }

    public double getDamage() {
        return damage;
    }

    public void setPlaceTower(boolean placeTower) {
        this.placeTower = placeTower;
    }

    public void setPlaceTowerFirst(boolean placeTowerFirst) {
        this.placeTowerFirst = placeTowerFirst;
    }

    public double getPrize() {
       return prize;
    }

    public boolean isPlaceTower() {
        return placeTower;
    }

    public Rectangle getTowerBounds() {
        return towerBounds;
    }

    public boolean isTowerMenu() {
        return towerMenu;
    }

    public void setTowerMenu(boolean towerMenu) {
        this.towerMenu = towerMenu;
    }

    public int getRange() {
        return range;
    }

    /**
     * this method will increase tower level by one and set tower values to upgraded ones
     */
    public void upgrade() {
        damage = getUpgradeValues()[0];
        attackSpeed = getUpgradeValues()[1];
        prize += getUpgradeValues()[2];
        range = getUpgradeValues()[3];
        level++;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public MyUpgradeButton getUpgradeButton() {
        return upgradeButton;
    }

    public MySellButton getMySellButton() {
        return mySellButton;
    }

    public int getLevel() {
        return level;
    }

    public BufferedImage getTowerImage() {
        return towerImage;
    }
}
