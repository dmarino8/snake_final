package marino.david_snake_javafx;

public class FruitFactory {

    public Fruit getFruit(String fruitType) {
        if (fruitType == null) {
            return null;
        }
        if (fruitType.equalsIgnoreCase("SPEED")){
            return new SpeedFruit();
        }

        return null;
    }
}
