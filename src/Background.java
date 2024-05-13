import java.awt.*;

/**
 * this class will generate a background
 */
public class Background {
    public static final int TILESIZE = 60;
    private static final int columnLenght = TILESIZE/4;

    /**
     * this method will draw all the tiles of the array on the screen
     * @param graphics2D
     */
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
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    /**
     * return position of first tile in first column
     * @return
     */
    public static int positionOfFirstTile(){
        int tilePosition;
        for (tilePosition = 0; tilePosition < columnLenght; tilePosition++) {
            if (backgroundEditor[tilePosition][0] == 2) {
                break;
            }
        }
        return tilePosition * TILESIZE;
    }

    /**
     * return true if next block is dirt
     * @param x
     * @param y
     * @param direction
     * @return
     */
    public static boolean isNextDirt(double x, double y, int direction){
        boolean trueFalse = true;
        int tileX = (int) (y/TILESIZE);
        int tileY = (int) (x/TILESIZE);
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

    /**
     * return true if tower is not touching dirt
     * @param t
     * @return
     */
    public static boolean isTowerPlaceable(Tower t){
        int tileX = (int) ((t.getY())/TILESIZE);
        int tileY = (int) ((t.getX())/TILESIZE);
        int tileX2 = (int) ((t.getY()-30)/TILESIZE);
        int tileY2 = (int) ((t.getX()+15)/TILESIZE);
        int tileX3 = (int) ((t.getY()-30)/TILESIZE);
        int tileY3 = (int) ((t.getX()-30)/TILESIZE);
        int tileX4 = (int) ((t.getY()+15)/TILESIZE);
        int tileY4 = (int) ((t.getX()-30)/TILESIZE);
        int tileX5 = (int) ((t.getY()+15)/TILESIZE);
        int tileY5 = (int) ((t.getX()+15)/TILESIZE);
        if (backgroundEditor[tileX][tileY] != 2 && backgroundEditor[tileX2][tileY2] != 2 && backgroundEditor[tileX3][tileY3] != 2 &&  backgroundEditor[tileX4][tileY4] != 2 &&  backgroundEditor[tileX5][tileY5] != 2 ) {
            return true;
        } else {
            return false;
        }
    }
}
