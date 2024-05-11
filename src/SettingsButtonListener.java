import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsButtonListener implements ActionListener {
    GamePanel gamePanel;
    SettingsButton settingsButton;
    public SettingsButtonListener(GamePanel gamePanel, SettingsButton settingsButton) {
        this.settingsButton = settingsButton;
        this.gamePanel = gamePanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gamePanel.hideGameMenu();
    }
}
