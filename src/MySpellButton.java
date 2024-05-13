import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * this class represents button
 */
public class MySpellButton extends JButton {
    ImageIcon mySpellButton = new ImageIcon("pictures/Spells/Spell_fire.png");
    ImageIcon mySpellButtonClicked = new ImageIcon("pictures/Spells/Spell_fire_clicked.png");
    ImageIcon mySpellButtonLocked = new ImageIcon("pictures/Spells/Spell_freeze_locked.png");
    ImageIcon mySpellButtonLocked_coldown_1 = new ImageIcon("pictures/Spells/Spell_fire_coldown_1.png");
    ImageIcon mySpellButtonLocked_coldown_2 = new ImageIcon("pictures/Spells/Spell_fire_coldown_2.png");
    ImageIcon mySpellButtonLocked_coldown_3 = new ImageIcon("pictures/Spells/Spell_fire_coldown_3.png");
    static BufferedImage fireCircle;

    static {
        try {
            fireCircle = ImageIO.read(new File("pictures/Spells/Spell_fire_circle.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    int clickCount;
    int coldown = 0;
    private static boolean placeSpell = false;
    private static boolean drawFire = false;
    private static boolean spellWasUsed = false;
    static int positionX;
    static int positionY;
    int timer;

    /**
     * assign variables
     */
    public MySpellButton() {
        setIcon(mySpellButton);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setBounds(700,800, 60,60);
        this.addActionListener(new MySpellButtonListener(this));
    }

    /**
     * this method will change icon after click
     */
    public void changeIcon() {
        switch (clickCount) {
            case 0:
                setIcon(mySpellButton);
                placeSpell = false;
                break;
            case 1:
                setIcon(mySpellButtonClicked);
                placeSpell = true;
                break;
            case 3:
                setIcon(mySpellButtonLocked);
                break;
            case 4:
                setIcon(mySpellButtonLocked_coldown_1);
                break;
            case 5:
                setIcon(mySpellButtonLocked_coldown_2);
                break;
            case 6:
                setIcon(mySpellButtonLocked_coldown_3);
                break;

        }
    }

    /**
     * this method will draw button on the screen
     * @param graphics2D
     */
    public void draw(Graphics2D graphics2D) {
        if (!spellWasUsed && !drawFire) {
            graphics2D.setColor(Color.black);
            graphics2D.drawOval((int) MyMouseListener.positionX-100, (int) MyMouseListener.positionY-100, 200,200);
            if (MyMouseListener.letfMousePressed) {
                spellWasUsed = true;
            }
        } else {
            if (!drawFire) {
                positionX = (int) MyMouseListener.positionX-100;
                positionY = (int) MyMouseListener.positionY-100;
                graphics2D.setColor(Color.RED);
                graphics2D.drawImage(fireCircle,positionX,positionY,null);
                drawFire = true;
                spellWasUsed = false;
                timer = 0;
            } else {
                timer++;
                if (timer % (60 * 5) == 0) {
                    drawFire = false;
                    placeSpell = false;
                    clickCount = 3;
                    changeIcon();
                    coldown = 0;
                } else {
                    graphics2D.setColor(Color.RED);
                    graphics2D.drawImage(fireCircle, positionX ,positionY , null);
                }
            }
        }




    }

    /**
     * after click on the wave coldown will reset by one
     */
    public void resetColdDown(){
        if (clickCount >= 3) {
            coldown++;
            switch (coldown) {
                case 1:
                    clickCount = 4;
                    break;
                case 2:
                    clickCount = 5;
                    break;
                case 3:
                    clickCount = 6;
                    break;
                case 4:
                    clickCount = 0;
                    break;
            }
            changeIcon();
            spellWasUsed = false;
            drawFire = false;
        }
    }

    /**
     * if mouse is touching this buton it will return true
     * @return
     */
    public boolean collisionWithMouse() {
        return this.getBounds().contains(MyMouseListener.positionX, MyMouseListener.positionY);
    }

    public static boolean isSpellWasUsed() {
        return spellWasUsed;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }


    public void setPlaceSpell(boolean placeSpell) {
        this.placeSpell = placeSpell;
    }

    public static boolean isPlaceSpell() {
        return placeSpell;
    }

    public static boolean isDrawFire() {
        return drawFire;
    }
}
