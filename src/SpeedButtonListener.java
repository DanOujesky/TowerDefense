import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpeedButtonListener implements ActionListener {
    static int speed = 1;
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (speed) {
            case 1:
                speed = 2;
                break;
            case 2:
                speed = 4;
                break;
            case 4:
                speed = 1;
                break;
        }
        GamePanel.speedButton.setIcon(new ImageIcon("pictures/Speed_icons/Speed_icon_" + speed + "x.png"));
    }
}
