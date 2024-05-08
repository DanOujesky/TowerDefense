import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWaveButtonListener implements ActionListener {

    Waves waves;
    MyWaveButton myWaveButton;
    public MyWaveButtonListener(Waves waves, MyWaveButton myWaveButton){
        this.waves = waves;
        this.myWaveButton = myWaveButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (myWaveButton.visible) {
            myWaveButton.setVisible(false);
            waves.startWave(myWaveButton);
        }

    }
}
