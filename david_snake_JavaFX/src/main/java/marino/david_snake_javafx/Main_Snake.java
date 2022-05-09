package marino.david_snake_javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import marino.david_snake_javafx.enemys.Enemy;
import marino.david_snake_javafx.enemys.EnemyFactory;
import marino.david_snake_javafx.fruits.Fruit;
import marino.david_snake_javafx.fruits.FruitFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static marino.david_snake_javafx.CreateNewFood.newFood;

public class Main_Snake extends Application {
    static int speed = 0;
    static int speedTemp = 5;
    static String foodcolor = "white";
    static String colorTemp = "white";
    static int width = 20;
    static int height = 20;
    static int foodX = 0;
    static int foodY = 0;
    static int cornersize = 25;
    static List<Corner> snake = new ArrayList<>();
    static Dir direction = Dir.left;
    static boolean gameOver = false;
    static Random rand = new Random();
    static FruitFactory fruitFactory = new FruitFactory();
    static EnemyFactory factory = new EnemyFactory();
    static Enemy enemy = factory.getEnemy("BASIC");
    static int count = 0;

    public void start(Stage primaryStage) {
        try {
            newFood();

            VBox root = new VBox();
            Canvas c = new Canvas(width * cornersize, height * cornersize);
            GraphicsContext gc = c.getGraphicsContext2D();
            root.getChildren().add(c);

            new AnimationTimer() {
                long lastTick = 0;

                public void handle(long now) {
                    if (lastTick == 0) {
                        lastTick = now;
                        tick(gc);
                        return;
                    }
                    if (now - lastTick > 1000000000 / 1000000000) { //fix this so it's not weird
                        lastTick = now;
                        tick(gc);
                    }
                }
            }.start();
            Scene scene = new Scene(root, width * cornersize, height * cornersize);
            //Input Listener
            scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
                if (key.getCode() == KeyCode.W) {
                    direction = Dir.up;
                }
                if (key.getCode() == KeyCode.A) {
                    direction = Dir.left;
                }
                if (key.getCode() == KeyCode.S) {
                    direction = Dir.down;
                }
                if (key.getCode() == KeyCode.D) {
                    direction = Dir.right;
                }
            });

            snake.add(new Corner(width / 2, height / 2));
            snake.add(new Corner(width / 2, height / 2));
            primaryStage.setScene(scene);
            primaryStage.setTitle("SNAKE GAME");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tick(GraphicsContext gc) {
        count++;//s
        if (gameOver) {
            gc.setFill(Color.RED);
            gc.setFont(new Font("", 50));
            gc.fillText("GAME OVER", 100, 250);
            return;
        }
        //set snake image snake speed
        if (count % (10-speed) == 0) {
        for (int i = snake.size() - 1; i >= 1; i--) {
            snake.get(i).x = snake.get(i - 1).x;
            snake.get(i).y = snake.get(i - 1).y;
        }

        //boundary end condition
            switch (direction) {
                case up:
                    snake.get(0).y--;
                    if (snake.get(0).y > height) {
                        gameOver = true;
                    }
                    break;
                case down:
                    snake.get(0).y++;
                    if (snake.get(0).y > height) {
                        gameOver = true;
                    }
                    break;
                case left:
                    snake.get(0).x--;
                    if (snake.get(0).x < 0) {
                        gameOver = true;
                    }
                    break;
                case right:
                    snake.get(0).x++;
                    if (snake.get(0).x > width) {
                        gameOver = true;
                    }
                    break;
            }
        }

        //food hit detection
        if (foodX == snake.get(0).x && foodY == snake.get(0).y) {
            Fruit fruit = fruitFactory.getFruit(randFruit());

            speed = speedTemp;
            foodcolor = colorTemp;

            snake.add(new Corner(-1, -1));
            newFood();


            speedTemp = fruit.getSpeed();
            foodcolor = fruit.getColor();
        }
        //self death condition
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                gameOver = false;
            }
        }
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width * cornersize, height * cornersize);

        //enemy hit condition
        System.out.println(count);
        if (enemy.hitbox(snake.get(0).x * 25, snake.get(0).y * 25, enemy.getX(), enemy.getY())) { //int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy
            System.out.println("Hit");
            //System.exit(1);
        }

        //set score
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("", 30));
        gc.fillText("Score:" + count, 10, 30);

        //set food color and image
        Color cc = Color.WHITE;
        switch (foodcolor.toLowerCase()) {
            case "purple":
                cc = Color.PURPLE;
                break;
            case "green":
                cc = Color.GREEN;
                break;
        }
        gc.setFill(cc);
        gc.fillOval(foodX * cornersize, foodY * cornersize, cornersize, cornersize);

        //set snake image
        for (Corner c : snake) {
            gc.setFill(Color.GREEN);
            gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 2, cornersize - 2);
        }

        //set enemy image
        gc.setFill(Color.RED);
        gc.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());

        //enemy speed
        if (count % (10 - enemy.getSpeed()) == 0) {
            enemy.update();
        }


    }

    public static String randFruit() {
        int randNum = rand.nextInt(2);
        switch (randNum) {
            case 0:
                return "SPEED";
            case 1:
                return "SLOW";
            case 2:
                return "SPEED";
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
