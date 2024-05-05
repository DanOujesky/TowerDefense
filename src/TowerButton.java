import javax.swing.*;
import java.awt.*;

public class TowerButton extends JButton {
    public TowerButton(Tower tower){
        this.setBounds((int) tower.getX()-30, (int) tower.getY()-30, (int) 60, (int) 60);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.addActionListener(new TowerButtonListener(tower));
    }


}
