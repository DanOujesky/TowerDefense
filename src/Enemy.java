import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Enemy {
    private double x,y;
    private boolean death = false;
    double movementSpeed;
    private int direction;
    private BufferedImage enemy;
    private int enemyHealth;
    private int damage;
    private int earnings;
    public Enemy(File file, int enemyHealth, int movementSpeed, int damage, int earnings){
        try {
            enemy = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.enemyHealth = enemyHealth;
        this.movementSpeed = movementSpeed;
        this.damage = damage;
        this.earnings = earnings;
        x = -Background.TILESIZE;
        y = Background.positionOfFirstTile();
        direction = 1;
    }
    public void draw(Graphics2D graphics2D) {
        switch (direction) {
            case 1:
                graphics2D.drawImage(rotateImage(enemy, 0), (int) x, (int) y, null);
                break;
            case 2:
                graphics2D.drawImage(rotateImage(enemy, 270), (int) x, (int) y, null);
                break;
            case 3:
                graphics2D.drawImage(rotateImage(enemy, 180), (int) x, (int) y, null);
                break;
            case 4:
                graphics2D.drawImage(rotateImage(enemy, 90), (int) x, (int) y, null);
                break;
        }
    }

    public void update() {
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
        if (x > -1 && x < GamePanel.WIDTH - Background.TILESIZE * 1.5) {
            if (!Background.isNextDirt(x, y, direction) && x % Background.TILESIZE == 0 && y % Background.TILESIZE == 0) {
                chooseDirection();
            }
        } else if (x > (GamePanel.WIDTH - enemy.getWidth() + Background.TILESIZE)) {
            death = true;
            GamePanel.HEALTH -= damage;
            System.out.println(GamePanel.HEALTH);
        } else if (enemyHealth < 1) {
            death = true;
            GamePanel.COINS += earnings;
        }
    }
    private static BufferedImage rotateImage(BufferedImage buffImage, double angle) {
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



}
