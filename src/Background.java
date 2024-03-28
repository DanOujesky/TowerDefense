import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    private static final int TILESIZE = 60;
    private static final int columnLenght = TILESIZE / 4;
    public void draw(Graphics2D graphics2D) {

        for (int x = 0; x < columnLenght; x++) {
            for (int y = 0; y < columnLenght; y++) {
                switch (backgroundEditor[y][x]) {
                    case 1:
                        graphics2D.drawImage(Tile.getGRASS(), TILESIZE*x, TILESIZE*y, null);
                        break;
                    case 2:
                        graphics2D.drawImage(Tile.getDIRT(), TILESIZE*x, TILESIZE*y, null);
                        break;
                }

            }
        }
    }
    static int[][] backgroundEditor = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1},
            {1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1},
            {1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1},
            {1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 2, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 2, 2, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };
    public static int positionOfFirstTile(){
        int tilePosition;
        for (tilePosition = 0; tilePosition < columnLenght; tilePosition++) {
            if (backgroundEditor[tilePosition][0] == 2) {
                break;
            }
        }
        return tilePosition * TILESIZE;
    }
    public static boolean isNextDirt(int x, int y, int direction){
        boolean trueFalse = true;
        int tileX = y/TILESIZE;
        int tileY = x/TILESIZE;
        switch (direction) {
            case 1:
                if (backgroundEditor[tileX][tileY+1] != 2) {
                    trueFalse = false;
                }
                break;
            case 2:
                if (backgroundEditor[tileX-1][tileY] != 2) {
                    trueFalse = false;
                }
                break;
            case 3:
                if (backgroundEditor[tileX][tileY-1] != 2) {
                    trueFalse = false;
                }
                break;
            case 4:
                if (backgroundEditor[tileX+1][tileY] != 2) {
                    trueFalse = false;
                }
                break;
        }
        return trueFalse;
    }




}
