import javax.swing.*;

public class MyMoveButton extends JButton {
    ImageIcon myMoveButton = new ImageIcon("pictures/TowerMenu/sellButton.png");
    ImageIcon myMoveButtonClicked = new ImageIcon("pictures/TowerMenu/sellButton_clicked.png");
    int clickCount;
    Tower tower;

    public MyMoveButton(Tower tower) {
        this.tower = tower;
        setIcon(myMoveButton);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setBounds((int) tower.getX()-15+60, (int) tower.getY()+(tower.getRange()/2)-15-20, myMoveButton.getIconWidth()/2,myMoveButton.getIconHeight()/2);
        this.addActionListener(new MyMoveButtonListener(this));
    }

    public void changeIcon() {
        switch (clickCount) {
            case 0:
                setIcon(myMoveButton);
                break;
            case 1:
                setIcon(myMoveButtonClicked);
                break;
            case 2:
                setIcon(myMoveButton);
                tower.moveTower();
                break;

        }
    }

    public boolean collisionWithMouse() {
        return this.getBounds().contains(MyMouseListener.positionX, MyMouseListener.positionY);
    }
}
