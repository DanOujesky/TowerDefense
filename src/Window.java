import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    static JFrame window;
    static GamePanel gamePanel;
    public Window(){

        window = new JFrame("Tower Defense");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.launchGame();
    }
    public static void addButton(JButton jButton){
        gamePanel.add(jButton);
    }
    public static void removeButton(JButton jButton){gamePanel.remove(jButton);}

}
