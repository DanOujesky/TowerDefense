package Game;

import javax.swing.*;
import java.awt.*;

/**
 * this class represents Background button
 */

public class BackgroundButton extends JButton {

    /**
     * assign variables
     * @param gamePanel
     * @param imageIcon
     */
    public BackgroundButton(GamePanel gamePanel, String imageIcon){
        this.setText(imageIcon);
        if (imageIcon.equals("MAPA 1")) {
            this.setBounds(100,375,300,150);
        } else {
            this.setBounds(500,375,300,150);
        }
        this.addActionListener(new BackgroundButtonListener(gamePanel, imageIcon));
        MyWindow.addButton(this);
    }

}
