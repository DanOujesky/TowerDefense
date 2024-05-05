import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySellButtonListener implements ActionListener {
    MySellButton mySellButton;
    public MySellButtonListener(MySellButton mySellButton) {
        this.mySellButton = mySellButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mySellButton.clickCount++;
        mySellButton.changeIcon();

    }

}
