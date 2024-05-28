package Game;

import javax.swing.*;
import java.awt.*;

/**
 * this clas represents setting button
 */
public class SettingsButton extends JButton{
    ImageIcon settingsButton = new ImageIcon("TowerDefense/pictures/GameMenu/SettingsButton.png");

    /**
     * assign values
     * @param gamePanel
     */
    public SettingsButton(GamePanel gamePanel){
        this.setIcon(settingsButton);
        this.setBounds(new Rectangle(300,375,300,150));
        this.addActionListener(new SettingsButtonListener(gamePanel, this));
    }
}
