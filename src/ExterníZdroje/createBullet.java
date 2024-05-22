package ExterníZdroje;

public class createBullet {

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
