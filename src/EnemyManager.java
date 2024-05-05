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
                enemies.add(new Enemy(new File("pictures/Enemies/Enemy_1.png"), 40,1,1, 1));
                break;
            case "enemy2":
                enemies.add(new Enemy(new File("pictures/Enemies/Enemy_2.png"), 20, 3,1,2));
                break;
            case "enemy3":
                enemies.add(new Enemy(new File("pictures/Enemies/Enemy_3.png"),  400,0.5,3, 3));
                break;
            case "enemy4":
                enemies.add(new Enemy(new File("pictures/Enemies/Enemy_4.png"),  2300,0.5,5, 5));
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
