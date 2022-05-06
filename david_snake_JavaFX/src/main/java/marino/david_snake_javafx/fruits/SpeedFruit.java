package marino.david_snake_javafx.fruits;

public class SpeedFruit implements Fruit {

    //properties
    public int posX;
    public int posY;
    public String color;
    public int speed;

    //constructors
    SpeedFruit () {
        posX = 0;
        posY = 0;
        color = "green";
        speed = 7;//s
    }

    //getters
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    public int getSpeed() {
        return speed;
    }

    //setters
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }



}
