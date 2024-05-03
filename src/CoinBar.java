import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CoinBar {
    public static int COINS;
    public CoinBar(int COINS) {
        this.COINS = COINS;
    }

    public void draw(Graphics2D graphics2D) {
        String coins = "COINS: " + COINS;
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(coins, 800, 40);
    }
}
