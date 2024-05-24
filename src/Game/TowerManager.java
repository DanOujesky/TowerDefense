package Game;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * this class records towers
 */
public class TowerManager {

    private static ArrayList<Tower> towers;

    /**
     * this method will create new arrayList
     */
    public TowerManager(){
        towers = new ArrayList<>();
    }

    /**
     * this method will add tower to the arrayList
     * @param name
     */
    public static void addTower(String name){
        if (!towers.isEmpty() ) {
            if (towers.get(towers.size()-1).isPlaceTower()) towers.remove(towers.size()-1);
        }
        switch (name) {
            case "Tower_1":
                towers.add(new Tower(0,0,12,1,10,5, new File("pictures/Towers/Tower_1.png"), "Tower_1", 200));
                break;
            case "Canon_1":
                towers.add(new Tower(0,0,5,1,22,5, new File("pictures/Towers/Canon_1.png"), "Canon_1", 280));
                break;
        }
        if (towers.get(towers.size()-1).getPrize() <=  CoinBar.COINS) {
            towers.get(towers.size()-1).setPlaceTower(true);
        } else {
            towers.remove(towers.size()-1);
        }
    }

    /**
     * this method will draw rect around every tower if tower is placing
     * @param graphics2D
     */
    public static void drawCollisionRect(Graphics2D graphics2D) {
        for (Tower t: towers) {
            graphics2D.setColor(Color.RED);
            graphics2D.drawRect((int) (t.getX()-30), (int) (t.getY()-30),60,60);
        }
    }

    /**
     * if tower is on the grass and tower is not touching other tower it will return true
     * @param t
     * @return
     */
    public static boolean isPlaceable(Tower t){
        if (Background.isTowerPlaceable(t)){
            for (int i = 0; i < towers.size(); i++) {
                if (towers.indexOf(t) != i) {
                    if (t.getX() - towers.get(i).getX() <= 45 && t.getX() - towers.get(i).getX() >= -45 && t.getY() - towers.get(i).getY() <= 45 && t.getY() - towers.get(i).getY() >= -45){
                       return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * this method will sell the tower
     * @param tower
     */
    public static void sellTower(Tower tower){
        CoinBar.COINS += (int)tower.getPrize()/2;
        MyWindow.removeButton(tower.getMySellButton());
        MyWindow.removeButton(tower.getUpgradeButton());
        removeTower(tower);
    }

    /**
     * this method will remove tower form the arrayList
     * @param t
     */
    public static void removeTower(Tower t) {
        towers.remove(t);
    }

    /**
     * this method will return true if there is not more than one tower that has tower menu set on true
     * @param tower
     * @return
     */
    public static boolean checkTowerMenu(Tower tower) {
        for (Tower t: towers) {
            if (!t.equals(tower) && t.isTowerMenu()) {
                return false;
            }
        }
        return true;
    }

    /**
     * return true if none of the towers have place tower set on true
     * @return
     */
    public static boolean checkTowerPlacing() {
        for (Tower t: towers) {
            if (t.isPlaceTower()) {
                return false;
            }
        }
        return true;
    }

    /**
     * updates all the towers
     */
    public void update() {
        if (!towers.isEmpty()) {
            for (int i =0; i < towers.size(); i++) {
                towers.get(i).update();
            }
        }
    }

    /**
     * draw all the towers
     * @param graphics2D
     */
    public void draw(Graphics2D graphics2D) {
        if (!towers.isEmpty()) {
            for (int i = 0; i < towers.size(); i++) {
                towers.get(i).draw(graphics2D);
            }
        }
    }
}
