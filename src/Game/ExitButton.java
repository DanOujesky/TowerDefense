package Game;

import javax.swing.*;
import java.awt.*;

/**
 * this class represents exit button
 */
public class ExitButton extends JButton {
    ImageIcon exitButton = new ImageIcon("pictures/GameMenu/Game.ExitButton.png");

    /**
     * assign variables
     * @param gamePanel
     */
    public ExitButton(GamePanel gamePanel){
        this.setIcon(exitButton);
        this.setBounds(new Rectangle(300,575,300,150));
        this.addActionListener(new ExitButtonListener(gamePanel, this));
    }
}
