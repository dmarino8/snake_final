package marino.david_snake_javafx;

import javafx.geometry.Rectangle2D;

public class Collision {
    public static boolean hitbox(int snakeX, int snakeY, int enemyX, int enemyY) {
        Rectangle2D bound = new Rectangle2D(snakeX, snakeY, 20, 20);
        if (bound.contains(enemyX, enemyY)) {
            return true;
        } else return false;
    }
}
