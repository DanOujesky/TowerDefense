import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class EnemyManager {
    private static ArrayList<Enemy> enemies;
    public EnemyManager(){
        enemies = new ArrayList<>();
    }
    public static ArrayList<Enemy> getEnemies(){
        return enemies;
    }
    public static void addEnemy(String name){
        switch (name) {
            case "enemy1":
                enemies.add(new Enemy(new File("pictures/Enemies/Enemy_1.png"), 10,2,1, 10));
                break;
            case "enemy2":
                enemies.add(new Enemy(new File("pictures/Enemies/Enemy_2.png"), 20, 3,1,5));
                break;
            case "enemy3":
                enemies.add(new Enemy(new File("pictures/Enemies/Enemy_3.png"), 5, 1,1, 8));
                break;
        }
    }

    public void update() {
        if (!enemies.isEmpty()) {
            for (int i =0; i < enemies.size(); i++) {
                enemies.get(i).update();
                if (enemies.get(i).isDeath()) {
                    enemies.remove(enemies.get(i));
                }
            }
        }
    }

    public void draw(Graphics2D graphics2D) {
        if (!enemies.isEmpty()) {
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).draw(graphics2D);
            }
        }
    }
}
