package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is checking if someone clicked on the button
 */
public class ExitButtonListener implements ActionListener {
    GamePanel gamePanel;
    ExitButton exitButton;

    /**
     * assign variables
     * @param gamePanel
     * @param exitButton
     */
    public ExitButtonListener(GamePanel gamePanel, ExitButton exitButton) {
        this.exitButton = exitButton;
        this.gamePanel = gamePanel;
    }

    /**
     * if someone clicked on the button it will close the game
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
