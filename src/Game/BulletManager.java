package Game;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * this class records bullets
 */
public class BulletManager {
    private static ArrayList<Bullet> bullets;

    /**
     * create new arraylist
     */
    public BulletManager(){
        bullets = new ArrayList<>();
    }

    /**
     * this method will calculate speed of the bullet and then create bullet
     * @param t
     */
    public static void newBullet(Tower t){
        int  xDist = (int) (t.getX() - t.getEnemyTarget().getX());
        int  yDist = (int) (t.getY() - t.getEnemyTarget().getY());
        int totalDist = Math.abs(xDist) + Math.abs(yDist);

        double xPer = (double) Math.abs(xDist) / totalDist;

        double xSpeed = xPer * t.getEnemyTarget().getMovementSpeed();
        double ySpeed = t.getEnemyTarget().getMovementSpeed() - xSpeed;


        if (t.getX() > t.getEnemyTarget().getX()) {
            xSpeed *= -1;
        }
        if (t.getY() > t.getEnemyTarget().getY()) {
            ySpeed *= -1;
        }
        double arcValue = Math.atan(yDist / (double) xDist);
        double rotate = Math.toDegrees(arcValue);

        if (xDist < 0) {
            rotate += 180;
        }

        switch (t.getName())
        {
            case "Tower_1":
                switch (t.getLevel()) {
                    case 1:
                        bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_1.png")));
                        break;
                    case 2:
                        bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_2.png")));
                        break;
                    case 3:
                        bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_3.png")));
                        break;
                    case 4:
                        bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_4.png")));
                        break;
                    case 5:
                        bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_5.png")));
                        break;
                }
            case "Canon_1" :
                switch (t.getLevel()) {
                    case 1:
                        bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_1.png")));
                        break;
                    case 2:
                        bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_2.png")));
                        break;
                    case 3:
                        bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_3.png")));
                        break;
                    case 4:
                        bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_4.png")));
                        break;
                    case 5:
                        bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_5.png")));
                        break;
                }
        }


    }

    /**
     * updates all bullets that are in arraylist
     */
    public void update() {
        if (!bullets.isEmpty()) {
            for (int i =0; i < bullets.size(); i++) {
                bullets.get(i).update();
                if (bullets.get(i).isDeath()) {
                    bullets.remove(bullets.get(i));
                }
            }
        }
    }

    /**
     * draw all bullets on the screen
     * @param graphics2D
     */
    public void draw(Graphics2D graphics2D) {
        if (!bullets.isEmpty()) {
            for (int i = 0; i < bullets.size(); i++) {
                bullets.get(i).draw(graphics2D);
            }
        }
    }
}
