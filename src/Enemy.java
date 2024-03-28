import javax.swing.*;
import java.awt.*;

public class Enemy {
    private int x,y;
    private int direction;
    final static ImageIcon ENEMY_1 = new ImageIcon("pictures/Enemies/Enemy_1.png");
    public Enemy(){
        x = 0;
        y = Background.positionOfFirstTile();
        direction = 1;
    }
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(ENEMY_1.getImage(), x,y, null);
    }

    public void update() {
        switch (direction) {
            case 1:
                x += 1;
                break;
            case 2:
                y -= 1;
                break;
            case 3:
                x -= 1;
                break;
            case 4:
                y += 1;
                break;
        }
        if (!Background.isNextDirt(x, y, direction) && x % 60 == 0 && y % 60 == 0) {
            chooseDirection();
        }
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
