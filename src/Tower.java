import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tower {
    private double x,y, attackSpeed, damage, prize;
    private int range;
    private BufferedImage towerImage;
    String name;
    private boolean placeTower = false;
    private boolean placeTowerFirst = false;
    private Enemy enemyTarget = null;
    private int clock;
    private Rectangle towerBounds;
    private boolean towerMenu = false;
    private MyUpgradeButton upgradeButton;
    private MySellButton mySellButton;
    private MyMoveButton myMoveButton;
    int level;
    int maxLevel;

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
    }
    public static int getDistance(double x1, double y1, double x2,  double y2){
        double xDiff = Math.abs(x1 -x2);
        double yDiff = Math.abs(y1 - y2);
        return (int) Math.hypot(xDiff, yDiff);
    }
    public void updateHitBox(){
        towerBounds.x = (int) x;
        towerBounds.y = (int) y;
    }
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
    private boolean checkEnemyTarget(){
        int range = getDistance(x , y,enemyTarget.getX(), enemyTarget.getY());
        return checkTowerRange(range);
    }
    public void setEnemyTarget(){
        for (int i =0; i < EnemyManager.getEnemies().size(); i++) {
            double range = getDistance(x, y,EnemyManager.getEnemies().get(i).getX(), EnemyManager.getEnemies().get(i).getY());
            if (checkTowerRange(range)) {
                enemyTarget = EnemyManager.getEnemies().get(i);
                break;
            }
        }
    }
    public boolean checkTowerRange(double range){
        return range < this.range/2+16;
    }
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

    public void update() {
        if (placeTower) {
            x = MyMouseListener.positionX     - MyMouseListener.positionX%15;
            y =  MyMouseListener.positionY   - MyMouseListener.positionY%15;
            updateHitBox();
            if (MyMouseListener.letfMousePressed && TowerManager.isPlaceable(this) ) {
                if (placeTowerFirst)CoinBar.COINS -= prize;
                placeTower = false;
                placeTowerFirst = false;
                MyWindow.addButton(new TowerButton(this));
                upgradeButton = new MyUpgradeButton(this);
                mySellButton = new MySellButton(this);
                myMoveButton = new MyMoveButton(this);
                MyWindow.addButton(upgradeButton);
                MyWindow.addButton(mySellButton);
                MyWindow.addButton(myMoveButton);
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
                    myMoveButton.clickCount = 0;
                    myMoveButton.changeIcon();
                    myMoveButton.setVisible(true);
                    upgradeButton.setVisible(true);
                    mySellButton.setVisible(true);
                }
            } else {
                if (upgradeButton.isVisible()) {
                    upgradeButton.setVisible(false);
                    mySellButton.setVisible(false);
                    myMoveButton.setVisible(false);
                }
            }
        }



    }

    public void rotateTower(double rotate) {
       towerImage = Enemy.rotateImage(towerImage,rotate);
    }

    public boolean isCooldownOver(){
        return clock >= attackSpeed;
    }
    public void resetCooldown(){
        clock = 0;
    }




    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(towerImage, (int) x - 30, (int) y - 30, null);
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
    public boolean collisionWithMouse(){
        if (towerBounds.contains(MyMouseListener.positionX+30, MyMouseListener.positionY+30)){
            return true;
        } else {
            return false;
        }
    }
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
                }
                break;
            case "Canon_1":
                switch (level) {
                    case 1:

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
        this.placeTowerFirst = true;
        this.placeTower = placeTower;
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

    public void moveTower() {
        towerMenu = false;
        placeTower = true;
        update();
        TowerManager.removeTower(this);
        TowerManager.addTower(this.name);
    }
}
