package ExterníZdroje;

// source: https://www.youtube.com/watch?v=_HhIvNIlEqM&list=PL4rzdwizLaxb0-TajNIp5DOoT_PAxhx0T&index=25
public class createBullet {

    /**
     * this method will create speedX and speedY for bullet
     * @param towerX
     * @param towerY
     * @param enemyX
     * @param enemyY
     * @param enemyMovementSpeed
     * @return
     */
    public static double[] createBulletValues(double towerX, double towerY, double enemyX, double enemyY, double enemyMovementSpeed){
        int  xDist = (int) (towerX - enemyX);
        int  yDist = (int) (towerY - enemyY);
        int totalDist = Math.abs(xDist) + Math.abs(yDist);

        double xPer = (double) Math.abs(xDist) / totalDist;

        double xSpeed = xPer * enemyMovementSpeed;
        double ySpeed = enemyMovementSpeed - xSpeed;


        if (towerX > enemyX) {
            xSpeed *= -1;
        }
        if (towerY > enemyY) {
            ySpeed *= -1;
        }
        double arcValue = Math.atan(yDist / (double) xDist);
        double rotate = Math.toDegrees(arcValue);

        if (xDist < 0) {
            rotate += 180;
        }
        return new double[]{xSpeed, ySpeed, rotate};
    }
}
