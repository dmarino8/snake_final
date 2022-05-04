package marino.david_snake_javafx;

public class FruitFactory {

    public Fruit getFruit(String fruitType) {
        if (fruitType == null) {
            return null;
        } else if (fruitType.equalsIgnoreCase("SPEED")) {
            return new SpeedFruit();
        } else if (fruitType.equalsIgnoreCase("SLOW")) {
            return new SlowFruit();
        }


        return null;
    }
}
