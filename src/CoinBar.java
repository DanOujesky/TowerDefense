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
        graphics2D.setFont(new Font("Arial",1,15));
        String coins = "COINS: " + COINS;
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(coins, 800, 40);
    }
}
