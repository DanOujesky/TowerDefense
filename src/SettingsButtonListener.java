import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is listener for the setting button
 */
public class SettingsButtonListener implements ActionListener {
    GamePanel gamePanel;
    SettingsButton settingsButton;

    /**
     * assign values
     * @param gamePanel
     * @param settingsButton
     */
    public SettingsButtonListener(GamePanel gamePanel, SettingsButton settingsButton) {
        this.settingsButton = settingsButton;
        this.gamePanel = gamePanel;
    }

    /**
     * after mouse click it will hide game menu
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        gamePanel.hideGameMenu();
    }
}
