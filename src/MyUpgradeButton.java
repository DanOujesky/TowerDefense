import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
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
        this.setBounds((int) tower.getX()-15, (int) tower.getY()-45, upgradeButtonImage.getIconWidth()/2,upgradeButtonImage.getIconHeight()/2);
        this.addActionListener(new MyUpgradeButtonListener(this));
    }
    public void changeIcon(){
        if (tower.level < tower.maxLevel) {
            switch (clickCount) {
                case 0:
                    setIcon(upgradeButtonImage);
                    break;
                case 1:
                    setIcon(upgradeButtonImageClicked);
                    break;
                case 2:
                    if (CoinBar.COINS >= tower.getUpgradeValues()[2]) {
                        CoinBar.COINS -= tower.getUpgradeValues()[2];
                        tower.upgrade();
                    }
                    setIcon(upgradeButtonImage);
                    clickCount = 0;

                    break;

            }
        }

    }
    public boolean collisionWithMouse(){
        return this.getBounds().contains(MyMouseListener.positionX, MyMouseListener.positionY);
    }


    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.black);
        graphics2D.fillRect(320, 10, 170,100);
        graphics2D.fillRect(530, 10, 170,100);
        graphics2D.setFont(new Font("Arial",1,15));
        graphics2D.setColor(Color.white);
        drawStringWithEnters(graphics2D,"Damage: " + (int)tower.getDamage() + "\n" + "Attack Speed: " + 60/(int)tower.getAttackSpeed() + "shots/s" + "\n" + "Prize: " + (int)tower.getPrize() + "coins" + "\n" + "Range: " + tower.getRange() , 330, 20);
        if (tower.level < tower.maxLevel) {
            graphics2D.setColor(Color.GREEN);
            drawStringWithEnters(graphics2D,"Damage: " + tower.getUpgradeValues()[0] + "\n" + "Attack Speed: " + 60/tower.getUpgradeValues()[1] + "shots/s" + "\n" + "Prize: " + tower.getUpgradeValues()[2] + "coins" + "\n" + "Range: " + tower.getUpgradeValues()[3] , 540, 20);
        } else {
            graphics2D.setFont(new Font("Arial",1,30));
            drawStringWithEnters(graphics2D, "MAX" + "\n"+ "LEVEL",570,20);
        }


    }
    private void drawStringWithEnters(Graphics2D graphics2D, String text, int x, int y) {
        for (String line : text.split("\n"))
            graphics2D.drawString(line, x, y += graphics2D.getFontMetrics().getHeight());
    }
}
