import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App2 {
    private static Connection conn;
    public static void main(String[] args) throws SQLException {

        final String connString = "jdbc:mysql://localhost:3306/employees";
        //localhost is an alias to 127.0.0.1 my computer 3306 is the default port numbers

        try {
            System.out.println("Attempting DB connection....");
            conn = DriverManager.getConnection(connString,"root", "password");
            System.out.println("We have connected successfully! You rock");
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
