package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundButtonListener implements ActionListener {

    GamePanel gamePanel;
    String imageIcon;

    public BackgroundButtonListener(GamePanel gamePanel, String imageIcon) {
        this.gamePanel= gamePanel;
        this.imageIcon = imageIcon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gamePanel.launchGame(imageIcon);
        gamePanel.hideBackgroundSelectionMenu();
    }
}
