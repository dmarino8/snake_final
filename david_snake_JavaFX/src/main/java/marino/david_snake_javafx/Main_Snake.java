package marino.david_snake_javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import marino.david_snake_javafx.database.DatabaseConnection;
import marino.david_snake_javafx.enemys.Enemy;
import marino.david_snake_javafx.enemys.EnemyFactory;
import marino.david_snake_javafx.fruits.Fruit;
import marino.david_snake_javafx.fruits.FruitFactory;
import marino.david_snake_javafx.snakes.BasicSnake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static marino.david_snake_javafx.Collision.hitbox;
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
    static boolean gameOver = false;
    static Random rand = new Random();
    static FruitFactory fruitFactory = new FruitFactory();
    static EnemyFactory factory = new EnemyFactory();
    static Enemy enemy = factory.getEnemy("BASIC");
    static int count = 0;
    static int score = 0;
    static BasicSnake snake = new BasicSnake();

    public void start(Stage primaryStage) {
        try {
            newFood();
            VBox root = new VBox();
            Canvas c = new Canvas(width * 25, height * 25);
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
                    if (now - lastTick > 1) { //fix this so it's not weird
                        lastTick = now;
                        tick(gc);
                    }
                }
            }.start();
            Scene scene = new Scene(root, width * 25, height * 25);
            //Input Listener
            KeyCombination left = new KeyCodeCombination(KeyCode.LEFT);
            KeyCombination right = new KeyCodeCombination(KeyCode.RIGHT);
            KeyCombination up = new KeyCodeCombination(KeyCode.UP);
            KeyCombination down = new KeyCodeCombination(KeyCode.DOWN);

            scene.setOnKeyPressed(key -> {
                if (left.match(key)) {
                    snake.decreaseAngle();
                }
                if (right.match(key)) {
                    snake.increaseAngle();
                }
                if (up.match(key)) {
                    snake.setVelocity(5);
                }
                if (down.match(key)) {
                    snake.setVelocity(1);
                }
            });
            scene.setOnKeyReleased(key -> {
                if (up.match(key)) {
                    snake.setVelocity(3);
                }
                if (down.match(key)) {
                    snake.setVelocity(3);
                }
            });
            primaryStage.setScene(scene);
            primaryStage.setTitle("SNAKE GAME");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tick(GraphicsContext gc) {
        count++;
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width * 25, height * 25);

        if (gameOver) {
            gc.setFill(Color.RED);
            gc.setFont(new Font("", 50));
            gc.fillText("GAME OVER", 100, 250);
            return;
        }

        //snake movement
        gc.setFill(Color.YELLOW);
        gc.fillRect(snake.parts.get(1).x, snake.parts.get(1).y, 25-2, 25-2);
        gc.setFill(Color.RED);
        gc.fillRect(snake.parts.get(0).x, snake.parts.get(0).y, 25-2, 25-2);

        snake.update();
        //food hit detection

        //enemy hit condition

        //set score
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("", 30));
        gc.fillText("Score:" + score, 10, 30);

        //set food color and image
        Color cc = Color.WHITE;
        switch (foodcolor.toLowerCase()) {
            case "purple":
                cc = Color.PURPLE;
                break;
            case "green":
                cc = Color.GREEN;
                break;
            case "yellow":
                cc = Color.YELLOW;
                break;
        }
        gc.setFill(cc);
        gc.fillOval(foodX * 25, foodY * 25, 25, 25);

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
