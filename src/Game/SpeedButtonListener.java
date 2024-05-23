package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is listener for the speed button
 */
public class SpeedButtonListener implements ActionListener {
    public static int speed = 1;

    /**
     * after mouse click it will change game speed
     * @param e the event to be processed
     */
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
