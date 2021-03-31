import java.sql.*;

public class App {

    public static void main(String[] args) {
//        jdbc:mysql://hostname:port/dbname
        String connectionString = "jdbc:mysql://localhost:3306/employees"; //localhost is an alias to 127.0.0.1 my
        // computer 3306 is the default port numbers

        final String SELECT_QUERY = "SELECT * FROM employees LIMIT 200";

        try (Connection connection = DriverManager.getConnection(connectionString, "root", "password")) {
            System.out.println("We have connected successfully! You rock");
            try (Statement statement = connection.createStatement()) {
          ResultSet rs =  statement.executeQuery(SELECT_QUERY);
          while(rs.next()){
              System.out.println("emp no: " + rs.getInt(1) + " DOB: " + rs.getString(2) + " First Name: " + rs.getString(3)
              + " Last Name: " + rs.getString(4));
          }
            }
        } catch (SQLException throwables) {
            System.out.println("Error connecting to the database.");
            throwables.printStackTrace();
        }
    }
}
