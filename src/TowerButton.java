import javax.swing.*;
import java.awt.*;

public class TowerButton extends JButton {
    public TowerButton(Tower tower){
        this.setBounds((int) tower.getX()-15, (int) tower.getY()-15, (int) tower.getTowerImage().getWidth()/2, (int) tower.getTowerImage().getHeight()/2);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.addActionListener(new TowerButtonListener(tower));
    }


}
