import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWaveButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        GamePanel.myWaveButton.setVisible(false);
        Waves.startWave();
    }
}
