import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonListener implements ActionListener {
    GamePanel gamePanel;
    PlayButton playButton;
    public PlayButtonListener(GamePanel gamePanel, PlayButton playButton){
        this.gamePanel = gamePanel;
        this.playButton = playButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gamePanel.launchGame();
        playButton.setVisible(false);
    }
}
