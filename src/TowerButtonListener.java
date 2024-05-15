import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is tower button listener
 */
public class TowerButtonListener implements ActionListener {
    Tower tower;

    /**
     * assign values
     * @param tower
     */
    public TowerButtonListener(Tower tower){
        this.tower = tower;
    }

    /**
     * after click on the tower it will open tower menu
     * @param e the event to be processed
     */
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
