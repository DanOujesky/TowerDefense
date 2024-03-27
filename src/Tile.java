import javax.swing.*;
import java.awt.*;

public class Tile {

    final static ImageIcon GRASS = new ImageIcon("pictures/GRASS.png");
    final static ImageIcon DIRT = new ImageIcon("pictures/DIRT.png");


    public static Image getGRASS() {
        return GRASS.getImage();
    }
    public static Image getDIRT() {
        return DIRT.getImage();
    }
}
