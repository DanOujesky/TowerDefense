import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class TowerManager {

    private static ArrayList<Tower> towers;
    public TowerManager(){
        towers = new ArrayList<>();
    }
    public static void addTower(String name){
        if (!towers.isEmpty() ) {
            if (towers.get(towers.size()-1).isPlaceTower()) towers.remove(towers.size()-1);
        }
        switch (name) {
            case "Tower_1":
                towers.add(new Tower(0,0,12,1,10,3, new File("pictures/Towers/Tower_1.png"), "Tower_1", 200));
                break;
            case "Canon_1":
                towers.add(new Tower(0,0,5,1,22,1, new File("pictures/Towers/Canon_1.png"), "Canon", 280));
                break;
        }
        if (towers.get(towers.size()-1).getPrize() <=  CoinBar.COINS) {
            towers.get(towers.size()-1).setPlaceTower(true);
        } else {
            towers.remove(towers.size()-1);
        }
    }
    public static void drawCollisionRect(Graphics2D graphics2D) {
        for (Tower t: towers) {
            graphics2D.setColor(Color.RED);
            graphics2D.drawRect((int) (t.getX()-30), (int) (t.getY()-30),60,60);
        }
    }
    public static boolean touchingTower(){
        for (Tower t : towers) {
            if (t.getTowerBounds().contains(MyMouseListener.positionX+30, MyMouseListener.positionY+30)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isPlaceable(Tower t){
        boolean trueFalse = true;
        if (Background.isTowerPlaceable(t)){
            for (Tower tower: towers) {
                if (!tower.equals(t)) {
                    if (t.getX() - tower.getX() <= 45 && t.getX() - tower.getX() >= -45 && t.getY() - tower.getY() <= 45 && t.getY() - tower.getY() >= -45){
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
    public static void sellTower(Tower tower){
        CoinBar.COINS += (int)tower.getPrize()/2;
        MyWindow.removeButton(tower.getMySellButton());
        MyWindow.removeButton(tower.getUpgradeButton());
        removeTower(tower);
    }
    public static void removeTower(Tower t) {
        towers.remove(t);
    }

    public static boolean checkTowerMenu(Tower tower) {
        for (Tower t: towers) {
            if (!t.equals(tower) && t.isTowerMenu()) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkTowerPlacing() {
        for (Tower t: towers) {
            if (t.isPlaceTower()) {
                return false;
            }
        }
        return true;
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
