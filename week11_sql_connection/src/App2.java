import java.sql.*;

public class App2 {
    private static Connection conn;
    public static void main(String[] args) throws SQLException {

        final String connString = "jdbc:mysql://localhost:3306/employees";
        //localhost is an alias to 127.0.0.1 my computer 3306 is the default port numbers

        try {
            System.out.println("Attempting DB connection....");
            conn = DriverManager.getConnection(connString,"root", "password");
            System.out.println("We have connected successfully! You rock");
//            selectAllEmployees();
            selectEmployee(10023);
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

    public static void selectAllEmployees(){
        String query = "SELECT * FROM employees LIMIT 250";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                System.out.println("emp no: " + rs.getInt(1) + " DOB: " + rs.getString("birth_date") + " First Name: " + rs.getString(3)
              + " Last Name: " + rs.getString(4));
            }
        } catch (SQLException throwables) {
            System.out.println("Error when running SelectAllEmployees().");
            throwables.printStackTrace();
        }
    }

    public static void selectEmployee(Integer employeeNum){
        String query = "SELECT * FROM employees WHERE emp_no = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, employeeNum);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("emp no: " + rs.getInt(1) + " DOB: " + rs.getString("birth_date") + " First Name: " + rs.getString(3)
                        + " Last Name: " + rs.getString(4));            }
        } catch (SQLException throwables) {
            System.out.println("Error when running SelectEmployee().");
            throwables.printStackTrace();
        }

    }


}
