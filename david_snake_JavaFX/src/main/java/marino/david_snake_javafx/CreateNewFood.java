package marino.david_snake_javafx;

import static marino.david_snake_javafx.Main_Snake.*;

public class CreateNewFood {//s
    public static void newFood() {
        start:
        while (true) {
            foodX = rand.nextInt(width);
            foodY = rand.nextInt(height);

            for (Corner c : snake) {
                if(c.x == foodX && c.y == foodY) {
                    continue start;
                }
            }
            break;
        }
    }
}
