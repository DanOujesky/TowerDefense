package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is action listener to wave button
 */
public class MyWaveButtonListener implements ActionListener {

    Waves waves;
    MyWaveButton myWaveButton;

    /**
     * assign values
     * @param waves
     * @param myWaveButton
     */
    public MyWaveButtonListener(Waves waves, MyWaveButton myWaveButton){
        this.waves = waves;
        this.myWaveButton = myWaveButton;
    }

    /**
     * after mouse click it will start wave
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (myWaveButton.visible) {
            myWaveButton.setVisible(false);
            waves.startWave(myWaveButton);
        }

    }
}
