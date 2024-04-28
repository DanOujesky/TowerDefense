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
    public static boolean isPlaceable(Tower t){
        boolean trueFalse = true;
        if (Background.isTowerPlaceable(t)){
            for (Tower tower: towers) {
                if (!tower.equals(t)) {
                    if (t.getX() - tower.getX() <= 60 && t.getX() - tower.getX() >= -60 && t.getY() - tower.getY() <= 60 && t.getY() - tower.getY() >= -60){
                        trueFalse = false;
                        break;
                    }
                }
            }
        } else {
            trueFalse = false;
        }
        return trueFalse;
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
