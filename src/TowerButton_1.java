import javax.swing.*;
import java.awt.*;

public class TowerButton_1 extends JButton {

    ImageIcon imageIcon = new ImageIcon("pictures/TowerButtons/TowerButton_1.png");
    public TowerButton_1(){
        setIcon(imageIcon);
        setBounds(100, 750, 120, 120);
        addActionListener(new MyTowerButtonListener("Tower_1"));
    }
}
