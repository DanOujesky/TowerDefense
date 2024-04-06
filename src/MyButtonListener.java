
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class MyButtonListener implements ActionListener {
    private double x,y, attackSpeed, damage, prize;
    File towerFile;
    public MyButtonListener(double x, double y, double attackSpeed, double damage, double prize, File towerFile){
        this.x = x;
        this.y = y;
        this.attackSpeed = attackSpeed;
        this.damage = damage;
        this.prize = prize;
        this.towerFile = towerFile;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Tower tower = new Tower(x,y,attackSpeed,damage,prize,towerFile);
        tower.setPlaceTower(true);
    }
}
