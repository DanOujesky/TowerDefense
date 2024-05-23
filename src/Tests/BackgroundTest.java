package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Game.Background;

class BackgroundTest {

    @Test
    void isNextDirt() {
        double enemyPositionX = 600;
        double enemyPositionY = 0;
        int tileSize = 60;

        int tileX = (int) enemyPositionX/tileSize;
        int tileY  = (int) enemyPositionY/tileSize;


        Assertions.assertEquals(Background.backgroundEditor[tileX][tileY], 2);


    }

    @Test
    void positionOfFirstTile() {
        int columnLenght = 15;
        int tilePosition;
        int result;
        int tileSize = 60;

        for (tilePosition = 0; tilePosition < columnLenght; tilePosition++) {
            if (Background.backgroundEditor[tilePosition][0] == 2) {
                break;
            }
        }
        result = tilePosition * tileSize;
        Assertions.assertEquals(result, 600);

    }
}