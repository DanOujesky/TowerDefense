import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class MyUpgradeButton extends JButton {
    ImageIcon upgradeButtonImage = new ImageIcon("pictures/TowerMenu/upgradeButton.png");
    ImageIcon upgradeButtonImageClicked = new ImageIcon("pictures/TowerMenu/upgradeButton_clicked.png");
    int clickCount;
    Tower tower;

    public MyUpgradeButton(Tower tower) {
        this.tower = tower;
        setIcon(upgradeButtonImage);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setBounds((int) tower.getX()-30, (int) tower.getY()-30-(tower.getRange()/2), upgradeButtonImage.getIconWidth(),upgradeButtonImage.getIconHeight());
        this.addActionListener(new MyUpgradeButtonListener(this));
    }
    public void changeIcon(){
        switch (clickCount) {
            case 0:
                setIcon(upgradeButtonImage);
                break;
            case 1:
                setIcon(upgradeButtonImageClicked);
                break;
            case 2:
                clickCount = 0;
                setIcon(upgradeButtonImage);
                tower.upgrade();
                break;

        }
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }
}
