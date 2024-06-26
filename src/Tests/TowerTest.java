package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Game.Tower;

import java.awt.*;

/**
 * this class is used to test Tower class methods
 */

class TowerTest {
    /**
     * this method checks distance between tower and enemy
     */

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

    /**
     * this method checks collision between tower and mouse
     */
    @Test
    void collisionWithMouse() {

        Rectangle towerBounds = new Rectangle(50,50,50,50);
        int mousePositionX = 99;
        int mousePositionY= 99;

        Assertions.assertTrue(towerBounds.contains(mousePositionX,mousePositionY));
    }

    /**
     * this method will check if tower range is smaller than distance between tower and enemy
     */

    @Test
    void checkTowerRange() {

        double towerPositionX = 1;
        double enemyPositionX = 0;
        double towerPositionY = 0;
        double enemyPositionY = 5;

        int towerRange = 240/2+15;
        double distanceBetweenTowerAndEnemy = Tower.getDistance(towerPositionX,towerPositionY,enemyPositionX,enemyPositionY);
        Assertions.assertTrue(towerRange > distanceBetweenTowerAndEnemy);

    }
}