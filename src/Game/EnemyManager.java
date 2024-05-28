package Game;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * this class records enemies
 */
public class EnemyManager {
    private static ArrayList<Enemy> enemies;

    /**
     * create new arraylist
     */
    public EnemyManager(){
        enemies = new ArrayList<>();
    }
    public static ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    /**
     * this method will add enemy depends on their name
     * @param name
     */
    public static void addEnemy(String name){
        switch (name) {
            case "enemy1":
                enemies.add(new Enemy(new File("TowerDefense/pictures/Enemies/Enemy_1.png"), 45,1,1, 1));
                break;
            case "enemy2":
                enemies.add(new Enemy(new File("TowerDefense/pictures/Enemies/Enemy_2.png"), 25, 3,1,2));
                break;
            case "enemy3":
                enemies.add(new Enemy(new File("TowerDefense/pictures/Enemies/Enemy_3.png"),  420,0.5,3, 3));
                break;
            case "enemy4":
                enemies.add(new Enemy(new File("TowerDefense/pictures/Enemies/Enemy_4.png"),  2500,0.5,5, 5));
                break;
            case "enemy5":
                enemies.add(new Enemy(new File("TowerDefense/pictures/Enemies/Enemy_5.png"),  6000,0.5,5, 7));
                break;
        }
    }

    public static void removeAllEnemies() {
        enemies.removeAll(enemies);
    }


    /**
     * updates all the enemies
     */
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

    /**
     * draw enemies on the screen
     * @param graphics2D
     */
    public void draw(Graphics2D graphics2D) {
        if (!enemies.isEmpty()) {
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).draw(graphics2D);
            }
        }
    }
}
