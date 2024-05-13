import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class represents freeze button listener
 */
public class MySpellButtonFreezeListener implements ActionListener {
    MySpellButtonFreeze mySpellButtonFreeze;

    /**
     * assign variables
     * @param mySpellButtonFreeze
     */
    public MySpellButtonFreezeListener(MySpellButtonFreeze mySpellButtonFreeze){
        this.mySpellButtonFreeze = mySpellButtonFreeze;
    }

    /**
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!mySpellButtonFreeze.isFreezeWasUsed() && mySpellButtonFreeze.clickCount == 0) {
            mySpellButtonFreeze.clickCount++;
            mySpellButtonFreeze.changeIcon();
            mySpellButtonFreeze.startTimer();
        }
    }
}
