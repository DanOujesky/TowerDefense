import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CanonButton_1 extends JButton{
    ImageIcon imageIcon = new ImageIcon("pictures/TowerButtons/TowerButton_2.png");
    public CanonButton_1(){
        setIcon(imageIcon);
        setBounds(235, 750, 120, 120);
        addActionListener(new MyTowerButtonListener("Canon_1"));
    }
}
