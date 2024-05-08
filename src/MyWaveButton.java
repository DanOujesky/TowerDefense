import javax.swing.*;
import java.awt.*;

public class MyWaveButton extends JButton {
    Waves waves;
    boolean visible;
    public MyWaveButton(Waves waves){
        this.waves = waves;
        this.setBounds(0,Background.positionOfFirstTile(), 75,60);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.addActionListener(new MyWaveButtonListener(waves, this));
        this.visible = true;
    }
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawOval(1,Background.positionOfFirstTile()+10, 70, 40);
        graphics2D.setColor(Color.red);
        graphics2D.drawString("Wave " + (waves.waveCount+1), 6,Background.positionOfFirstTile()+35);
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
