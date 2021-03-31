import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
//        jdbc:mysql://hostname:port/dbname
        String connectionString = "jdbc:mysql://localhost:3306/employees"; //localhost is an alias to 127.0.0.1 my
        // computer 3306 is the default port numbers

        try (Connection connection = DriverManager.getConnection(connectionString, "root", "password")) {
            System.out.println("We have connected successfully! You rock");
        } catch (SQLException throwables) {
            System.out.println("Error connecting to the database.");
            throwables.printStackTrace();
        }
    }
}
