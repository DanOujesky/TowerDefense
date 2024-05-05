
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseListener implements MouseListener {
    public static double positionX;
    public static double positionY;
    public static boolean letfMousePressed;
    public static boolean rightMousePressed;
    public static boolean leftMouseClicked;
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


    public void updatePositions() {
        positionX = MouseInfo.getPointerInfo().getLocation().getX()-510;
        positionY = MouseInfo.getPointerInfo().getLocation().getY()-83;
    }
}
