package Game;

import ExterníZdroje.createBullet;

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

        double []values = createBullet.createBulletValues(t.getX(), t.getY(),t.getEnemyTarget().getX(), t.getEnemyTarget().getY(), t.getEnemyTarget().getMovementSpeed());
        double xSpeed = values[0];
        double ySpeed = values[1];
        double rotate = values[2];

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
