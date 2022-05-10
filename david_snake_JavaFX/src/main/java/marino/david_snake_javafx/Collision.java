package marino.david_snake_javafx;

import javafx.geometry.Rectangle2D;

public class Collision {
    public static boolean hitbox(int snakeX, int snakeY, int enemyX, int enemyY) {
        Rectangle2D boundSnake = new Rectangle2D(snakeX, snakeY, 20, 20);
        Rectangle2D boundEnemy = new Rectangle2D(enemyX, enemyY, 10, 10);
        if (boundSnake.contains(boundEnemy)) {
            return true;
        } else if (boundEnemy.contains(boundSnake)) {
            return true;
        } else return false;
    }
}
