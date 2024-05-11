import javax.swing.*;
import java.awt.*;

public class ExitButton extends JButton {
    ImageIcon exitButton = new ImageIcon("pictures/GameMenu/ExitButton.png");
    public ExitButton(GamePanel gamePanel){
        this.setIcon(exitButton);
        this.setBounds(new Rectangle(300,575,300,150));
        this.addActionListener(new ExitButtonListener(gamePanel, this));
    }
}
