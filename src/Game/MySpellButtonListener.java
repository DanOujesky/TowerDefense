package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class represents spell button listener
 */
public class MySpellButtonListener implements ActionListener {
    MySpellButton mySpellButton;

    /**
     * assign values
     * @param mySpellButton
     */
    public MySpellButtonListener(MySpellButton mySpellButton) {
        this.mySpellButton = mySpellButton;
    }

    /**
     * if mouse has clicked on the button it will change icon of the spell button
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!MySpellButton.isPlaceSpell() && mySpellButton.clickCount == 0) {
            mySpellButton.clickCount++;
            mySpellButton.changeIcon();
        }

    }
}
