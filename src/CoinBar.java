import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * this class represents coin bar
 */
public class CoinBar {
    public static int COINS;

    /**
     * assing coins
     * @param COINS
     */
    public CoinBar(int COINS) {
        this.COINS = COINS;
    }

    /**
     * draw coins on the screen
     * @param graphics2D
     */
    public void draw(Graphics2D graphics2D) {
        graphics2D.setFont(new Font("Arial",1,15));
        String coins = "COINS: " + COINS;
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(coins, 800, 40);
    }
}
