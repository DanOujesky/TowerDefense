package Game;

import javax.swing.*;
import java.awt.*;

/**
 * this class represents play button
 */
public class PlayButton extends JButton {

    ImageIcon playButton = new ImageIcon("pictures/GameMenu/PlayButton.png");

    /**
     * assign values
     * @param gamePanel
     */
    public PlayButton(GamePanel gamePanel){
        this.setIcon(playButton);
        this.setBounds(new Rectangle(300,175,300,150));
        this.addActionListener(new PlayButtonListener(gamePanel, this));
    }
}
