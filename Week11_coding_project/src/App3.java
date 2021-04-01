import java.sql.*;

public class App3 {
private static Connection conn;
    public static void main(String[] args) throws SQLException {
        String connString = "jdbc:mysql://localhost:3306/thai_food_db";
        try {
            System.out.println("Establishing DB connection...");
            conn = DriverManager.getConnection(connString, "root", "password");
            System.out.println("Connected to DB successfully!");
            selectAllThaiFoods();
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

    public static void selectAllThaiFoods(){
        String query = "SELECT * FROM name";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("food_name") + " |" + " Spicy Level: " + rs.getString(
                        "spicy_level") + " |" + " Noodle Dish: " + rs.getBoolean(
                        "is_noodles") + " |" + " Curry Dish: " + rs.getBoolean(
                        "is_curry"));
            }

        } catch (SQLException throwables) {
            System.out.println("Error when running SelectAllThaiFoods().");
            throwables.printStackTrace();
        }
    }
}
