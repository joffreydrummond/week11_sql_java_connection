import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App3 {
private static Connection conn;
    public static void main(String[] args) throws SQLException {
        String connString = "jdbc:mysql://localhost:3306/thai_food_db";
        try {
            System.out.println("Establishing DB connection...");
            conn = DriverManager.getConnection(connString, "root", "password");
            System.out.println("Connected to DB successfully!");
        } catch (SQLException throwables) {
            System.out.println("Error connecting to the database.");
            throwables.printStackTrace();
        } finally {
            if (conn != null){
                System.out.println("Closing DB connection...");
                conn.close();
                System.out.println("DB has disconnected successfully.");
            }
        }

    }
}
