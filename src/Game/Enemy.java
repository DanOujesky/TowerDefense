package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * this class represents enemy
 */
public class Enemy {
    private double x,y;
    private boolean death = false;
    double movementSpeed;
    private Rectangle enemyBounds;
    private int direction;
    private BufferedImage enemy;
    private double currentEnemyHealth, maxEnemyHealth;
    private int damage;
    private int earnings;
    private int freezeTime = 0;

    /**
     * assign all variables
     * @param file
     * @param maxEnemyHealth
     * @param movementSpeed
     * @param damage
     * @param earnings
     */
    public Enemy(File file, double maxEnemyHealth, double movementSpeed, int damage, int earnings){
        try {
            enemy = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        enemyBounds = new Rectangle((int) x-30, (int) y-30,60, 60);
        this.currentEnemyHealth = maxEnemyHealth;
        this.maxEnemyHealth = maxEnemyHealth;
        this.movementSpeed = movementSpeed;
        this.damage = damage;
        this.earnings = earnings;
        x = -Background.TILESIZE + enemy.getWidth()/2;
        y = Background.positionOfFirstTile() + enemy.getHeight()/2;
        direction = 1;
    }

    /**
     * draw enemy on the screen
     * @param graphics2D
     */
    public void draw(Graphics2D graphics2D) {
        drawHealthBar(graphics2D);
        switch (direction) {
            case 1:
                graphics2D.drawImage(rotateImage(enemy, 0), (int) x - enemy.getWidth()/2, (int) y -  enemy.getHeight()/2 , null);
                break;
            case 2:
                graphics2D.drawImage(rotateImage(enemy, 270), (int) x - enemy.getWidth()/2, (int) y -  enemy.getHeight()/2  , null);
                break;
            case 3:
                graphics2D.drawImage(rotateImage(enemy, 180),(int) x - enemy.getWidth()/2, (int) y -  enemy.getHeight()/2  , null);
                break;
            case 4:
                graphics2D.drawImage(rotateImage(enemy, 90), (int) x - enemy.getWidth()/2, (int) y -  enemy.getHeight()/2  , null);
                break;
        }
    }

    /**
     * update enemy positions
     */
    public void update() {
        if (x > MySpellButton.positionX && x < MySpellButton.positionX+200 && y > MySpellButton.positionY && y < MySpellButton.positionY + 200 && MySpellButton.isDrawFire()) {
            currentEnemyHealth--;
        }
        switch (direction) {
            case 1:
                x += movementSpeed;
                break;
            case 2:
                y -= movementSpeed;
                break;
            case 3:
                x -= movementSpeed;
                break;
            case 4:
                y += movementSpeed;
                break;

        }
        if (x > 0 && x < GamePanel.WIDTH - Background.TILESIZE * 1.5) {
            if (!Background.isNextDirt(x-30, y-30, direction) && (x -30)% Background.TILESIZE == 0 && (y-30) % Background.TILESIZE == 0) {
                chooseDirection();
            }
        }
        if (x > (GamePanel.WIDTH + enemy.getWidth()/2+ 60)) {
            death = true;
            HealthBar.HEALTH -= damage;
        }
        if (currentEnemyHealth < 1) {
            death = true;
            CoinBar.COINS += earnings;
        }
        updateHitBox();
    }

    /**
     * update hit box of the enemy
     */
    private void updateHitBox() {
        enemyBounds.x = (int) x;
        enemyBounds.y = (int) y;
    }

    /**
     * draw enemy health bar
     * @param graphics2D
     */
    public void drawHealthBar(Graphics2D graphics2D){
        graphics2D.setColor(Color.RED);
        graphics2D.fillRect((int) x-22, (int) y-27, (int) (currentEnemyHealth/maxEnemyHealth*44),3);
    }

    /**
     * return rotated enemy image
     * @param buffImage
     * @param angle
     * @return
     */
    public static BufferedImage rotateImage(BufferedImage buffImage, double angle) {
        double radian = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(radian));
        double cos = Math.abs(Math.cos(radian));

        int width = buffImage.getWidth();
        int height = buffImage.getHeight();

        int nWidth = (int) Math.floor((double) width * cos + (double) height * sin);
        int nHeight = (int) Math.floor((double) height * cos + (double) width * sin);

        BufferedImage rotatedImage = new BufferedImage(
                nWidth, nHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = rotatedImage.createGraphics();

        graphics.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        graphics.translate((nWidth - width) / 2, (nHeight - height) / 2);
        graphics.rotate(radian, (double) (width / 2), (double) (height / 2));
        graphics.drawImage(buffImage, 0, 0, null);
        graphics.dispose();

        return rotatedImage;
    }

    public boolean isDeath() {
        return death;
    }

    /**
     * checks if enemy can go straight if not then choose direction where he can go
     */
    public void chooseDirection(){
        int pastDirection = direction;
        switch (direction) {
            case 1:
                direction = 2;
                if (!Background.isNextDirt(x,y,direction)) {
                    direction = 3;
                    if (pastDirection == 1) {
                        direction = 4;
                    }
                }
                break;
            case 2:
                direction = 3;
                if (!Background.isNextDirt(x,y,direction)) {
                    direction = 4;
                    if (pastDirection == 2) {
                        direction = 1;
                    }
                }
                break;
            case 3:
                direction = 4;
                if (!Background.isNextDirt(x,y,direction)) {
                    direction = 1;
                    if (pastDirection == 3) {
                        direction = 2;
                    }
                }
                break;
            case 4:
                direction = 1;
                if (!Background.isNextDirt(x,y,direction)) {
                    direction = 2;
                    if (pastDirection == 4) {
                        direction = 3;
                    }
                }
                break;
        }

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public BufferedImage getEnemyImage() {
        return enemy;
    }

    public void setEnemyHealth(double currentEnemyHealth) {
        this.currentEnemyHealth = currentEnemyHealth;
    }

    public Rectangle getBounds() {
        return enemyBounds;
    }

    public double getEnemyHealth() {
        return currentEnemyHealth;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }
}
