
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class MyTowerButtonListener implements ActionListener {

    private String towerName;
    public MyTowerButtonListener(String towerName){
      this.towerName = towerName;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        TowerManager.addTower(towerName);

    }
}
