import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HealthBar {
    public static int HEALTH;
    public HealthBar(int HEALTH) {
        this.HEALTH = HEALTH;
    }

    public void draw(Graphics2D graphics2D) {
        try {
            graphics2D.drawImage(ImageIO.read(new File("pictures/Health_Bar/Health_Bar_" + HEALTH + ".png")), -40, -80, 240, 240, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}