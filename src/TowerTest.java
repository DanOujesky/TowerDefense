import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static java.lang.Math.hypot;
import static org.junit.jupiter.api.Assertions.*;

class TowerTest {

    @org.junit.jupiter.api.Test
    void getDistance() {

        double towerPositionX = 1;
        double enemyPositionX = 0;
        double towerPositionY = 0;
        double enemyPositionY = 5;

        double positions = (int)Math.hypot(towerPositionX - enemyPositionX,towerPositionY - enemyPositionY);
        double result = 5;
        Assertions.assertEquals(result, positions);
    }

    @Test
    void collisionWithMouse() {

        Rectangle towerBounds = new Rectangle(50,50,50,50);
        int mousePositionX = 99;
        int mousePositionY= 99;

        Assertions.assertTrue(towerBounds.contains(mousePositionX,mousePositionY));
    }

    @Test
    void checkTowerRange() {

        int towerRange = 240/2+15;
        int distanceBetweenTowerAndEnemy = 100;
        Assertions.assertTrue(towerRange > distanceBetweenTowerAndEnemy);

    }
}