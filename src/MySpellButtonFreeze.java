import javax.swing.*;
import java.awt.*;

public class MySpellButtonFreeze extends JButton {



    ImageIcon mySpellButtonFreeze = new ImageIcon("pictures/Spells/Spell_freeze.png");
    ImageIcon mySpellButtonFreezeClicked = new ImageIcon("pictures/Spells/Spell_freeze_clicked.png");
    ImageIcon mySpellButtonFreezeLocked = new ImageIcon("pictures/Spells/Spell_freeze_locked.png");
    ImageIcon mySpellButtonFreezeLockedColdown = new ImageIcon("pictures/Spells/Spell_freeze_locked_coldown.png");
    int clickCount;
    int timer;
    private boolean freezeWasUsed;
    private int slow = 2;
    private int slowForSeconds = 240;
    private int coldown = 0;

    public MySpellButtonFreeze() {
        setIcon(mySpellButtonFreeze);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setBounds(620,800, 60,60);
        this.addActionListener(new MySpellButtonFreezeListener(this));
    }
    public void startTimer(){
        timer = 0;
        freezeWasUsed = true;
    }
    public void decreaseTimer(){
        timer++;
        if (timer % slowForSeconds == 0) {
            freezeWasUsed = false;
            coldown = 0;
            clickCount = 3;
            changeIcon();
        }
    }
    public void resetColdDown(){
        if (clickCount >= 3) {
            coldown++;
            switch (coldown) {
                case 1:
                    clickCount = 4;
                    break;
                case 2:
                    clickCount = 0;
                    break;
            }
            changeIcon();
            freezeWasUsed = false;
        }

    }
    public boolean run(){
        return timer % slow == 0;
    }

    public void changeIcon() {
        switch (clickCount) {
            case 0:
                setIcon(mySpellButtonFreeze);
                break;
            case 1:
                setIcon(mySpellButtonFreezeClicked);
                break;
            case 3:
                setIcon(mySpellButtonFreezeLocked);
                break;
            case 4:
                setIcon(mySpellButtonFreezeLockedColdown);
                break;

        }
    }

    public boolean collisionWithMouse() {
        return this.getBounds().contains(MyMouseListener.positionX, MyMouseListener.positionY);
    }

    public boolean isFreezeWasUsed() {
        return freezeWasUsed;
    }

    public void setFreezeWasUsed(boolean freezeWasUsed) {
        this.freezeWasUsed = freezeWasUsed;
    }
}
