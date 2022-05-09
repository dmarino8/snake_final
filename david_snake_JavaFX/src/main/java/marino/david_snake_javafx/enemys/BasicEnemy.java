package marino.david_snake_javafx.enemys;

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

    BasicEnemy() {
        name = "BasicEnemy";
        type = "zigzag";
        speed = 7;
        x = 20;
        y = 20;
        width = 20;
        height = 20;
        dirX = "right";
        dirY = "down";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getSpeed() {
        return speed;
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
        if (x >= (500-width)) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean hitbox(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy){
        return ((ax > dx)||(bx < cx)||(ay > dy)||(by < cy));
    }
}
