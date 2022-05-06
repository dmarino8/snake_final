package marino.david_snake_javafx.enemys;

public interface Enemy {
    public String getName();
    public String getType();
    public int getSpeed();
    public int getX();
    public int getY();
    public void update();
}
