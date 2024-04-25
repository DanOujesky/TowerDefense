import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class BulletManager {
    private static ArrayList<Bullet> bullets;
    public BulletManager(){
        bullets = new ArrayList<>();
    }
    public static void newBullet(Tower t){
        int  xDist = (int) Math.abs(t.getX() - t.getEnemyTarget().getX());
        int  yDist = (int) Math.abs(t.getY() - t.getEnemyTarget().getY());
        int totalDist = xDist + yDist;

        double xPer = (double) xDist / totalDist;

        double xSpeed = xPer * t.getEnemyTarget().getMovementSpeed();
        double ySpeed = t.getEnemyTarget().getMovementSpeed() - xSpeed;


        if (t.getX() > t.getEnemyTarget().getX()) {
            xSpeed *= -1;
        }
        if (t.getY() > t.getEnemyTarget().getY()) {
            ySpeed *= -1;
        }

        switch (t.getName())
        {
            case "Tower_1":
                bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), new File("pictures/Bullets/Bullet_1.png")));
        }


    }

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

    public void draw(Graphics2D graphics2D) {
        if (!bullets.isEmpty()) {
            for (int i = 0; i < bullets.size(); i++) {
                bullets.get(i).draw(graphics2D);
            }
        }
    }
}
