package marino.david_snake_javafx.enemys;
//s
public class EnemyFactory {
    public Enemy getEnemy(String enemyType) {
        if (enemyType == null) {
            return null;
        } else if (enemyType.equalsIgnoreCase("BASIC")) {
            return new BasicEnemy();
        }
        return null;
    }
}
