package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is listener for the BackgroundButton
 */

public class BackgroundButtonListener implements ActionListener {

    GamePanel gamePanel;
    String imageIcon;

    /**
     * assign variables
     * @param gamePanel
     * @param imageIcon
     */

    public BackgroundButtonListener(GamePanel gamePanel, String imageIcon) {
        this.gamePanel= gamePanel;
        this.imageIcon = imageIcon;
    }

    /**
     * after click on the button it will launch a game
     * @param e the event to be processed
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        gamePanel.launchGame(imageIcon);
        gamePanel.hideBackgroundSelectionMenu();
    }
}
