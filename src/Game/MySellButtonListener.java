package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is checking if someone clicked on the button
 */
public class MySellButtonListener implements ActionListener {
    MySellButton mySellButton;

    /**
     * assign variables
     * @param mySellButton
     */
    public MySellButtonListener(MySellButton mySellButton) {
        this.mySellButton = mySellButton;
    }

    /**
     * checks if someone clicked on the button
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        mySellButton.clickCount++;
        mySellButton.changeIcon();

    }

}
