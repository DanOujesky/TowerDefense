
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class MyTowerButtonListener implements ActionListener {
    private double x,y, attackSpeed, damage, prize;
    String name;
    int range;
    File towerFile;
    public MyTowerButtonListener(double x, double y, double attackSpeed, double damage, double prize, File towerFile, String name, int range){
        this.x = x;
        this.y = y;
        this.attackSpeed = attackSpeed;
        this.damage = damage;
        this.prize = prize;
        this.towerFile = towerFile;
        this.name = name;
        this.range = range;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (CoinBar.COINS >= prize) {
            Tower tower = new Tower(x,y,attackSpeed, damage,prize,towerFile, name, range);
            tower.setPlaceTower(true);
        }

    }
}
