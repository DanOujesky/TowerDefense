package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class represents upgrade button listener
 */
public class MyUpgradeButtonListener implements ActionListener {
    MyUpgradeButton myUpgradeButton;

    /**
     * assign value
     * @param myUpgradeButton
     */
    public MyUpgradeButtonListener(MyUpgradeButton myUpgradeButton) {
        this.myUpgradeButton = myUpgradeButton;
    }

    /**
     * after mouse click on the button it will change icon of the upgrade button
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        myUpgradeButton.setClickCount(myUpgradeButton.getClickCount() + 1);
        myUpgradeButton.changeIcon();
    }
}
