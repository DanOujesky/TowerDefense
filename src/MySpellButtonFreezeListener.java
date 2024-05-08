import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySpellButtonFreezeListener implements ActionListener {
    MySpellButtonFreeze mySpellButtonFreeze;
    public MySpellButtonFreezeListener(MySpellButtonFreeze mySpellButtonFreeze){
        this.mySpellButtonFreeze = mySpellButtonFreeze;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!mySpellButtonFreeze.isFreezeWasUsed() && mySpellButtonFreeze.clickCount == 0) {
            mySpellButtonFreeze.clickCount++;
            mySpellButtonFreeze.changeIcon();
            mySpellButtonFreeze.startTimer();
        }
    }
}
