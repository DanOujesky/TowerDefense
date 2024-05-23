package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


/**
 * this class represents tower button listener
 */
public class MyTowerButtonListener implements ActionListener {

    private String towerName;

    /**
     * assign value
     * @param towerName
     */
    public MyTowerButtonListener(String towerName){
      this.towerName = towerName;
    }

    /**
     * after click on the button it will add tower to be placed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MyMouseListener.leftMouseClicked = false;
        TowerManager.addTower(towerName);

    }
}
