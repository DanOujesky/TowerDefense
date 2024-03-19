import javax.swing.*;
import java.awt.*;

public class Tile {

    final ImageIcon GRASS = new ImageIcon("pictures/GRASS.png");
    final ImageIcon DIRT = new ImageIcon("pictures/DIRT.png");


    public Image getGRASS() {
        return GRASS.getImage();
    }
    public Image getDIRT() {
        return DIRT.getImage();
    }
}
