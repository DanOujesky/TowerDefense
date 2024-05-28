package Game;

import javax.swing.*;

/**
 * this class represents freeze button
 */
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

    /**
     * assign variables
     */
    public MySpellButtonFreeze() {
        setIcon(mySpellButtonFreeze);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setBounds(620,800, 60,60);
        this.addActionListener(new MySpellButtonFreezeListener(this));
    }

    /**
     * this method start the timer
     */
    public void startTimer(){
        timer = 0;
        freezeWasUsed = true;
    }

    /**
     * this method will decrease the timer
     */
    public void decreaseTimer(){
        timer++;
        if (timer % slowForSeconds == 0) {
            freezeWasUsed = false;
            coldown = 0;
            clickCount = 3;
            changeIcon();
        }
    }

    /**
     * this method will reset coldown
     */
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

    /**
     *
     * @return
     */
    public boolean run(){
        return timer % slow == 0;
    }

    /**
     * this method will change the button icon after click count
     */
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

    /**
     * this method will return true if mouse is touching button
     * @return
     */
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
