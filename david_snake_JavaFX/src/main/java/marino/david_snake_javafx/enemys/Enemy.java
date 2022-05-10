package marino.david_snake_javafx.enemys;
//s
public interface Enemy {
    public String getName();
    public String getType();
    public int getSpeed();
    public int getX();
    public int getY();
    public int getWidth();
    public int getHeight();
    public void update();
    public boolean hitbox(int snakeX, int snakeY, int enemyX, int enemyY);

}
