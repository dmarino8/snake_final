package marino.david_snake_javafx.enemys;

import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;

//s
public class BasicEnemy implements Enemy {
    public String name;
    public String type;
    public int speed;
    public int x;
    public int y;
    public String dirX;
    public String dirY;
    public int width;
    public int height;
    public Rectangle2D bound;

    BasicEnemy() {
        name = "BasicEnemy";
        type = "zigzag";
        speed = 7;
        x = 100;
        y = 100;
        width = 10;
        height = 10;
        dirX = "right";
        dirY = "down";
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void update() {
        if (x >= (500 - width)) {
            dirX = "left";
        } else if (x <= 0) {
            dirX = "right";
        }
        if (y <= 0) {
            dirY = "down";
        } else if (y >= (500 - height)) {
            dirY = "up";
        }

        if (dirX.equalsIgnoreCase("right")) {
            this.x += 10;
        } else if (dirX.equalsIgnoreCase("left")) {
            this.x -= 10;
        }
        if (dirY.equalsIgnoreCase("up")) {
            this.y -= 3;
        } else if (dirY.equalsIgnoreCase("down")) {
            this.y += 3;
        }


    }
}
