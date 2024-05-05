import javax.swing.*;
import java.awt.*;

public class MySellButton extends JButton {
    ImageIcon sellButtonImage = new ImageIcon("pictures/TowerMenu/sellButton.png");
    ImageIcon sellButtonImageClicked = new ImageIcon("pictures/TowerMenu/sellButton_clicked.png");
    int clickCount;
    Tower tower;

    public MySellButton(Tower tower) {
        this.tower = tower;
        setIcon(sellButtonImage);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setBounds((int) tower.getX()-15, (int) tower.getY()+(tower.getRange()/2)-15, sellButtonImage.getIconWidth()/2,sellButtonImage.getIconHeight()/2);
        this.addActionListener(new MySellButtonListener(this));
    }

    public void changeIcon() {
        switch (clickCount) {
            case 0:
                setIcon(sellButtonImage);
                break;
            case 1:
                setIcon(sellButtonImageClicked);
                break;
            case 2:
                TowerManager.sellTower(tower);
                break;

        }
    }

    public boolean collisionWithMouse() {
        return this.getBounds().contains(MyMouseListener.positionX, MyMouseListener.positionY);
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.black);
        graphics2D.fillRect(425, 10, 170,100);
        graphics2D.setFont(new Font("Arial",1,20));
        graphics2D.setColor(Color.RED);
        drawStringWithEnters(graphics2D, "SELL PRIZE: " + (int)tower.getPrize()/2,445,45);
    }
    private void drawStringWithEnters(Graphics2D graphics2D, String text, int x, int y) {
        for (String line : text.split("\n"))
            graphics2D.drawString(line, x, y += graphics2D.getFontMetrics().getHeight());
    }
}
