import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy {
    private double x,y;
    private boolean death = false;
    final static double movementSpeed = 5;
    private int direction;
    final static BufferedImage ENEMY_1;

    static {
        try {
            ENEMY_1 = ImageIO.read(new File("pictures/Enemies/Enemy_1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Enemy(){
        x = -Background.TILESIZE;
        y = Background.positionOfFirstTile();
        direction = 1;
        spawn();
    }
    public void spawn(){
        while (x == 0) {
            update();
        }
    }
    public void draw(Graphics2D graphics2D) {
        switch (direction) {
            case 1:
                graphics2D.drawImage(rotateImage(ENEMY_1, 0), (int) x, (int) y, null);
                break;
            case 2:
                graphics2D.drawImage(rotateImage(ENEMY_1, 270), (int) x, (int) y, null);
                break;
            case 3:
                graphics2D.drawImage(rotateImage(ENEMY_1, 180),(int) x, (int) y, null);
                break;
            case 4:
                graphics2D.drawImage(rotateImage(ENEMY_1, 90), (int) x, (int) y, null);
                break;
        }
    }

    public void update() {
        switch (direction) {
            case 1:
                x += movementSpeed;
                break;
            case 2:
                y -= movementSpeed;
                break;
            case 3:
                x -= movementSpeed;
                break;
            case 4:
                y += movementSpeed;
                break;
        }
        if (x < GamePanel.WIDTH - Background.TILESIZE * 1.5) {
            if (!Background.isNextDirt(x, y, direction) && x % Background.TILESIZE == 0 && y % Background.TILESIZE == 0) {
                chooseDirection();
            }
        } else if (x > (GamePanel.WIDTH - ENEMY_1.getWidth() + Background.TILESIZE)) {
            death = true;
        }
    }
    private static BufferedImage rotateImage(BufferedImage buffImage, double angle) {
        double radian = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(radian));
        double cos = Math.abs(Math.cos(radian));

        int width = buffImage.getWidth();
        int height = buffImage.getHeight();

        int nWidth = (int) Math.floor((double) width * cos + (double) height * sin);
        int nHeight = (int) Math.floor((double) height * cos + (double) width * sin);

        BufferedImage rotatedImage = new BufferedImage(
                nWidth, nHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = rotatedImage.createGraphics();

        graphics.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        graphics.translate((nWidth - width) / 2, (nHeight - height) / 2);
        graphics.rotate(radian, (double) (width / 2), (double) (height / 2));
        graphics.drawImage(buffImage, 0, 0, null);
        graphics.dispose();

        return rotatedImage;
    }

    public boolean isDeath() {
        return death;
    }

    public void chooseDirection(){
        int pastDirection = direction;
        switch (direction) {
            case 1:
                direction = 2;
                if (!Background.isNextDirt(x,y,direction)) {
                    direction = 3;
                    if (pastDirection == 1) {
                        direction = 4;
                    }
                }
                break;
            case 2:
                direction = 3;
                if (!Background.isNextDirt(x,y,direction)) {
                    direction = 4;
                    if (pastDirection == 2) {
                        direction = 1;
                    }
                }
                break;
            case 3:
                direction = 4;
                if (!Background.isNextDirt(x,y,direction)) {
                    direction = 1;
                    if (pastDirection == 3) {
                        direction = 2;
                    }
                }
                break;
            case 4:
                direction = 1;
                if (!Background.isNextDirt(x,y,direction)) {
                    direction = 2;
                    if (pastDirection == 4) {
                        direction = 3;
                    }
                }
                break;
        }

    }

}
