package marino.david_snake_javafx.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SnakeDB", "root", "1l0veSEPPI");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from USER");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
