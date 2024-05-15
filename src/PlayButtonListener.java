import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is listener for the play button
 */
public class PlayButtonListener implements ActionListener {
    GamePanel gamePanel;
    PlayButton playButton;

    /**
     * assign values
     * @param gamePanel
     * @param playButton
     */
    public PlayButtonListener(GamePanel gamePanel, PlayButton playButton){
        this.gamePanel = gamePanel;
        this.playButton = playButton;
    }

    /**
     * after mouse click it will launch a game
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        gamePanel.launchGame();
        gamePanel.hideGameMenu();
    }
}
