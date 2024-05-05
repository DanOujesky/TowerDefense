import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TowerButtonListener implements ActionListener {
    Tower tower;
    public TowerButtonListener(Tower tower){
        this.tower = tower;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (tower.isTowerMenu()) {
            MyMouseListener.leftMouseClicked = false;
        } else {
            if (!(tower.isTowerMenu())) {
                if (TowerManager.checkTowerMenu(tower) ) {
                    if (TowerManager.checkTowerPlacing()) {
                        tower.setTowerMenu(true);
                        MyMouseListener.leftMouseClicked = true;
                    }
                } else {
                    MyMouseListener.leftMouseClicked = false;
                }
            }
        }

    }
}
