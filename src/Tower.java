import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tower {
    private double x,y, attackSpeed, damage, prize;
    private BufferedImage towerImage;
    private boolean placeTower = false;

    public Tower(double x, double y, double attackSpeed, double damage, double prize, File towerFile) {
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
    }

    public void update() {
        if (placeTower) {
            x = MyMouseListener.positionX - towerImage.getWidth()/2;
            y = MyMouseListener.positionY - towerImage.getHeight()/2;
            if (MyMouseListener.mousePressed) {
                placeTower = false;
            }
        } else {

        }

    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(towerImage, (int)x,(int)y,null);
    }

    public void setPlaceTower(boolean placeTower) {
        this.placeTower = placeTower;
        GamePanel.addTower(this);
    }
}
