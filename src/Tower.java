import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Year;

public class Tower {
    private double x,y, attackSpeed, damage, prize;
    private int range;
    private BufferedImage towerImage;
    String name;
    private boolean placeTower = false;
    private Enemy enemyTarget = null;
    private int clock;
    private Rectangle towerBounds;

    public Tower(double x, double y, double attackSpeed,  double damage, double prize, File towerFile, String name, int range) {
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
        towerBounds = new Rectangle((int) x, (int) y,towerImage.getWidth(), towerImage.getHeight());
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
            if (range < this.range / 2 ) {
                trueFalse = true;
                break;
            }
        }
        return trueFalse;

    }
    private boolean checkEnemyTarget(){
        int range = getDistance(x , y,enemyTarget.getX(), enemyTarget.getY());
        return range < this.range/2;
    }
    public void setEnemyTarget(){
        for (int i =0; i < EnemyManager.getEnemies().size(); i++) {
            double range = getDistance(x, y,EnemyManager.getEnemies().get(i).getX(), EnemyManager.getEnemies().get(i).getY());
            if (range < this.range / 2) {
                enemyTarget = EnemyManager.getEnemies().get(i);
                break;
            }
        }
    }
    public void shoot(){
        if (enemyTarget == null) {
            setEnemyTarget();
        } else {
            if (!checkEnemyTarget()) {
                setEnemyTarget();
            }
        }
        BulletManager.newBullet(this);

    }

    public void update() {
        if (placeTower) {
            x = MyMouseListener.positionX+30   - MyMouseListener.positionX%60;
            y =  MyMouseListener.positionY+30  - MyMouseListener.positionY%60;
            updateHitBox();
            if (MyMouseListener.mousePressed) {
                placeTower = false;
            }
        } else {
            if (!isCooldownOver()) {
                clock++;
            } else {
                if (isThereEnemy()) {
                    shoot();
                    resetCooldown();
                }
            }
        }

    }
    public boolean isCooldownOver(){
        return clock >= attackSpeed;
    }
    public void resetCooldown(){
        clock = 0;
    }



    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(towerImage, (int) x - 30, (int) y - 30, null);
        if (towerBounds.contains(MyMouseListener.positionX+30, MyMouseListener.positionY+30)){
            graphics2D.drawOval((int) x - range/2, (int) y - range/2, this.range, this.range);
        }

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
        TowerManager.addTower(this);
        CoinBar.COINS -= prize;
    }
}
