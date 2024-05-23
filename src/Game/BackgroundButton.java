package Game;

import javax.swing.*;
import java.awt.*;

public class BackgroundButton extends JButton {

    public BackgroundButton(GamePanel gamePanel, String imageIcon){
        this.setText(imageIcon);
        if (imageIcon.equals("MAPA 1")) {
            this.setBounds(new Rectangle(200,175,300,150));
        } else {
            this.setBounds(new Rectangle(500,175,300,150));
        }
        this.addActionListener(new BackgroundButtonListener(gamePanel, imageIcon));
    }

}
