import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMoveButtonListener implements ActionListener {
    MyMoveButton myMoveButton;
    public MyMoveButtonListener(MyMoveButton myMoveButton) {
        this.myMoveButton = myMoveButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        myMoveButton.clickCount++;
        myMoveButton.changeIcon();

    }
}
