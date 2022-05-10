package marino.david_snake_javafx.snakes;

import marino.david_snake_javafx.Corner;

import java.util.ArrayList;

public class BasicSnake {
    public double xDir = 1;
    public double yDir = 0;
    public double xPos = 0;
    public double yPos = 0;
    public int width;
    public int height;
    public int length;
    public double angle;
    public int velocity;
    public double turnSpeed;
    public ArrayList<Corner> parts = new ArrayList<>();

    public BasicSnake() {
        width = 20;
        height = 20;
        length = 1;
        angle = 0;
        velocity = 3;
        turnSpeed = 90;

        parts.add(new Corner(xPos, yPos));
        parts.add(new Corner(xPos, yPos));
    }

    public void update() {
        direction();

        parts.set(1, (new Corner(xPos, yPos)));

        xPos+=(xDir * velocity);
        yPos += (yDir * velocity);

        parts.set(0, (new Corner(xPos / 2, yPos / 2)));

    }

    public void direction() {
        double rad  = Math.toRadians(angle);
        xDir = 1 * Math.cos(rad);
        System.out.println(xDir + " xdir");
        yDir = 1 * Math.sin(rad);
        System.out.println(yDir + " ydir");
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    public int getVelocity () {
        return velocity;
    }

    public void increaseAngle() {
        angle+=turnSpeed;
    }
    public void decreaseAngle() {
        angle-=turnSpeed;
    }
}
