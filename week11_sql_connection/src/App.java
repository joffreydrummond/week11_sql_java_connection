import java.sql.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
//        jdbc:mysql://hostname:port/dbname
        String connectionString = "jdbc:mysql://localhost:3306/employees"; //localhost is an alias to 127.0.0.1 my
        // computer 3306 is the default port numbers

        String SELECT_QUERY = "SELECT * FROM employees WHERE emp_no = ?";

        Scanner scanner = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection(connectionString, "root", "password")) {
            System.out.println("We have connected successfully! You rock");
            System.out.println("Enter the employee number: ");
            String empNo = scanner.nextLine();
            PreparedStatement ps = connection.prepareStatement(SELECT_QUERY); ps.setString(1, empNo);
             {
          ResultSet rs =  ps.executeQuery();
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
