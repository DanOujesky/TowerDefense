import javax.swing.*;
import java.awt.*;

public class PlayButton extends JButton {

    public PlayButton(GamePanel gamePanel){
        this.setBounds(new Rectangle(200,200,200,200));
        this.addActionListener(new PlayButtonListener(gamePanel, this));
    }
}
