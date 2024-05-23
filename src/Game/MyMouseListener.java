package Game;

import javax.management.monitor.Monitor;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.management.MonitorInfo;

/**
 * this class have all the information about mouse
 */
public class MyMouseListener implements MouseListener {
    public static double positionX;
    public static double positionY;
    public static boolean letfMousePressed;
    public static boolean rightMousePressed;
    public static boolean leftMouseClicked;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double myWidth = screenSize.getWidth();
    double myHeight = screenSize.getHeight();
    private final int marginX = (int) ((myWidth)/2 - 450);
    private final int marginY = (int) ((myHeight)/2 - 450)-7;


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            letfMousePressed = true;
        }

        if (e.getButton() == MouseEvent.BUTTON3){
            rightMousePressed = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            letfMousePressed = false;
            if (leftMouseClicked) {
                leftMouseClicked = false;
            }
        }
        if (e.getButton() == MouseEvent.BUTTON3){
            rightMousePressed = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    /**
     * update mouse positions
     */
    public void updatePositions() {
        positionX = MouseInfo.getPointerInfo().getLocation().getX()-marginX;
        positionY = MouseInfo.getPointerInfo().getLocation().getY()-marginY;
    }
}
