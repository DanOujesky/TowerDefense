import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySpellButtonListener implements ActionListener {
    MySpellButton mySpellButton;
    public MySpellButtonListener(MySpellButton mySpellButton) {
        this.mySpellButton = mySpellButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!MySpellButton.isPlaceSpell() && mySpellButton.clickCount == 0) {
            mySpellButton.clickCount++;
            mySpellButton.changeIcon();
        }

    }
}
