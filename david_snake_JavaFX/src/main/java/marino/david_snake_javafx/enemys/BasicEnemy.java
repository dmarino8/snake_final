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
        x = 100;
        y = 100;
        width = 20;
        height = 20;
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

    @Override
    public boolean hitbox(int snakeX, int snakeY, int enemyX, int enemyY) {

        //snakeA
        int snakeAX = snakeX;
        int snakeAY = snakeY;
        //snakeB
        int snakeBX = snakeAX + 25;
        int snakeBY = snakeAY;
        //snakeC
        int snakeCX = snakeAX;
        int snakeCY = snakeAY + 25;
        //snakeD
        int snakeDX = snakeAX + 25;
        int snakeDY = snakeAY + 25;

        //enemyA
        int enemyAX = enemyX;
        int enemyAY = enemyY;
        //enemyB
        int enemyBX = enemyAX + width;
        int enemyBY = enemyAY;
        //enemyC
        int enemyCX = enemyAX;
        int enemyCY = enemyAY + height;
        //enemyD
        int enemyDX = enemyAX + width;
        int enemyDY = enemyAY + height;

        boolean snakeAenemyD = false;
        boolean snakeBenemyC = false;
        boolean snakeCenemyB = false;
        boolean snakeDenemyA = false;

        //compare snakeA to enemyD
        if ((snakeAX < enemyDX) && (snakeAY < enemyDY)) {
            snakeAenemyD = true;
            System.out.println(snakeAenemyD + " snakeAenemyD");
        } else {
            snakeAenemyD = false;
        }
        //compare snakeB to enemyC
        if (snakeBX > enemyCX && snakeBY < enemyCY) {

            snakeBenemyC = true;
            System.out.println(snakeBenemyC + " snakeBenemyC");
        } else {
            snakeBenemyC = false;
        }
        //compare snakeC to enemyB
        if (snakeCX < enemyBX && snakeCY > enemyBY) {

            snakeCenemyB = true;
            System.out.println(snakeCenemyB + " snakeCenemyB");
        } else {
            snakeCenemyB = false;
        }
        //compare snakeD to enemyA
        if (snakeDX > enemyAX && snakeDY > enemyAY) {

            snakeDenemyA = true;
            System.out.println(snakeDenemyA + " snakeDenemyA");
        } else {
            snakeDenemyA = false;
        }
        if (snakeAenemyD == true && snakeDenemyA == false) {
            System.out.println("contact snakeA -- enemyD");
            return true;
        } else if (snakeDenemyA == true && snakeAenemyD == false) {
            System.out.println("contact snakeD -- enemyA");
            return true;
        } else if (snakeBenemyC == true && snakeCenemyB == false) {
            System.out.println("contact snakeB -- enemyC");
            return true;
        } else if (snakeCenemyB == true && snakeBenemyC == false) {
            System.out.println("contact snakeC -- enemyB");
            return true;
        } else {
            return false;
        }
    }
}
