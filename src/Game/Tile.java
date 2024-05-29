package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * this class have all the background blocks
 */
public class Tile {

    final static BufferedImage GRASS;
    final static BufferedImage DIRT;

    /**
     * read images
     */
    static {
        try {
            GRASS = ImageIO.read(new File("pictures/Tiles/GRASS.png"));
            DIRT = ImageIO.read(new File("pictures/Tiles/DIRT.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static BufferedImage getGRASS() {
        return GRASS;
    }
    public static BufferedImage getDIRT() {
        return DIRT;
    }
}
