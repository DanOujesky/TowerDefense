import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyUpgradeButtonListener implements ActionListener {
    MyUpgradeButton myUpgradeButton;
    public MyUpgradeButtonListener(MyUpgradeButton myUpgradeButton) {
        this.myUpgradeButton = myUpgradeButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        myUpgradeButton.setClickCount(myUpgradeButton.getClickCount() + 1);
        myUpgradeButton.changeIcon();
    }
}
