import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    private static final int TILESIZE = 60;
    Tile tile = new Tile();
    public void draw(Graphics2D graphics2D) {

        for (int x = 0; x < TILESIZE/4; x++) {
            for (int y = 0; y < TILESIZE/4; y++) {
                switch (backgroundEditor[x][y]) {
                    case 1:
                        graphics2D.drawImage(tile.getGRASS(), TILESIZE*y, TILESIZE*x, null);
                        break;
                    case 2:
                        graphics2D.drawImage(tile.getDIRT(), TILESIZE*y, TILESIZE*x, null);
                        break;
                }

            }
        }
    }
    int[][] backgroundEditor = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1},
            {1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2},
            {1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };



}
