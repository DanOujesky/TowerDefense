import java.awt.*;
import java.util.ArrayList;

public class TowerManager {

    private static ArrayList<Tower> towers;
    public TowerManager(){
        towers = new ArrayList<>();
    }
    public static void addTower(Tower tower){
        towers.add(tower);
    }

    public void update() {
        if (!towers.isEmpty()) {
            for (int i =0; i < towers.size(); i++) {
                towers.get(i).update();
            }
        }
    }
    public void draw(Graphics2D graphics2D) {
        if (!towers.isEmpty()) {
            for (int i = 0; i < towers.size(); i++) {
                towers.get(i).draw(graphics2D);
            }
        }
    }
}
