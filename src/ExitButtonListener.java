import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonListener implements ActionListener {
    GamePanel gamePanel;
    ExitButton exitButton;
    public ExitButtonListener(GamePanel gamePanel, ExitButton exitButton) {
        this.exitButton = exitButton;
        this.gamePanel = gamePanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
