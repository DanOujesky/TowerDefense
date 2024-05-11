import javax.swing.*;
import java.awt.*;

public class SettingsButton extends JButton{
    ImageIcon settingsButton = new ImageIcon("pictures/GameMenu/SettingsButton.png");
    public SettingsButton(GamePanel gamePanel){
        this.setIcon(settingsButton);
        this.setBounds(new Rectangle(300,375,300,150));
        this.addActionListener(new SettingsButtonListener(gamePanel, this));
    }
}
