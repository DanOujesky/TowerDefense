import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * bullet
 */
public class Bullet {

    private double x,y, Xspeed, Yspeed, damage, rotation;
    private boolean isDeath;
    BufferedImage bulletImage;

    /**
     * assign all variables
     * @param x
     * @param y
     * @param Xspeed
     * @param Yspeed
     * @param damage
     * @param rotation
     * @param bulletFile
     */
    public Bullet(double x, double y, double Xspeed, double Yspeed,double damage, double rotation, File bulletFile) {
        this.x = x;
        this.y = y;
        this.Xspeed = Xspeed;
        this.Yspeed = Yspeed;
        this.damage = damage;
        this.rotation = rotation;
        isDeath = false;
        try {
            this.bulletImage = ImageIO.read(bulletFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * updates position of bullet
     */
    public void update() {
        x += Xspeed;
        y += Yspeed;
        if (checkCollisionWithEnemy()){
           isDeath = true;
        }
    }

    /**
     * checks if enemy is touching bullet
     * @return
     */
    private boolean checkCollisionWithEnemy() {
        boolean trueFalse = false;
        for (int i =0; i < EnemyManager.getEnemies().size(); i++) {
            if (EnemyManager.getEnemies().get(i).getBounds().contains(x+60,y+60)){
                trueFalse = true;
                EnemyManager.getEnemies().get(i).setEnemyHealth(EnemyManager.getEnemies().get(i).getEnemyHealth() - damage);
                break;
            }
        }
       return trueFalse;
    }

    public boolean isDeath(){
        return isDeath;
    }


    /**
     * draw bullet on screen
     * @param graphics2D
     */
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(bulletImage, (int)x,(int)y,null);
    }
}
