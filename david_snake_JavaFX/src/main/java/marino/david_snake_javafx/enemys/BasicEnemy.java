package marino.david_snake_javafx.enemys;

public class BasicEnemy implements Enemy {
    public String name;
    public String type;
    public int speed;
    public int x;
    public int y;
    public String dirX;
    public String dirY;

    BasicEnemy() {
        name = "BasicEnemy";
        type = "zigzag";
        speed =7;
        x = 20;
        y = 20;
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
    public void update() {
        if (x >= 490) {
            dirX = "left";
            System.out.println("this got hit");
        } else if (x <= 0) {
            dirX = "right";
        }
        if (y <= 0) {
            dirY = "down";
        } else if (y >= 490) {
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
}
