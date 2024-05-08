import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class BulletManager {
    private static ArrayList<Bullet> bullets;
    public BulletManager(){
        bullets = new ArrayList<>();
    }
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
                bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_1.png")));
            case "Canon_1" :
                bullets.add(new Bullet(t.getX() - 30,t.getY()-30,xSpeed*10,ySpeed*10,t.getDamage(), rotate, new File("pictures/Bullets/Bullet_1.png")));
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
