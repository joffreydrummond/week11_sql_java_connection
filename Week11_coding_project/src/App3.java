import java.sql.*;

public class App3 {
private static Connection conn;
    public static void main(String[] args) throws SQLException {
        String connString = "jdbc:mysql://localhost:3306/thai_food_db";
        try {
            System.out.println("Establishing DB connection...");
            conn = DriverManager.getConnection(connString, "root", "password");
            System.out.println("Connected to DB successfully!");

//            insertNewThaiFood("Tom Yum Soup", 3, false, false);
            deleteThaiFoodByID(9);
            selectAllThaiFoods();
            updateSpiceLevel(4, 4);
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
                System.out.println("ID #" + rs.getInt("id") + " " + "Name: " + rs.getString("food_name") + " |" +
                        " Spicy " +
                        "Level: " + rs.getString(
                        "spicy_level") + " |" + " Noodle Dish: " + rs.getBoolean(
                        "is_noodles") + " |" + " Curry Dish: " + rs.getBoolean(
                        "is_curry"));
            }
        } catch (SQLException throwables) {
            System.out.println("Error when running selectAllThaiFoods().");
            throwables.printStackTrace();
        }
    }

    public static void insertNewThaiFood(String foodName, Integer spiceLevel, Boolean isNoodles, Boolean isCurry){
        String query = "INSERT INTO name(food_name, spicy_level, is_noodles, is_curry) VALUES(?, ?, ?, ?)";
        try {
            System.out.println("Inserting new thai food into table...");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, foodName);
            ps.setInt(2, spiceLevel);
            ps.setBoolean(3, isNoodles);
            ps.setBoolean(4, isCurry);
            ps.executeUpdate();
            System.out.println("New thai food inserted successfully!");
        } catch (SQLException throwables) {
            System.out.println("Error when running insertNewThaiFood().");
            throwables.printStackTrace();
        }
    }

    public static void updateSpiceLevel(Integer spiceLevel, Integer id){
        String query = "UPDATE name SET spice_level = ? WHERE id = ?";
        try {
            System.out.println("Updating record...");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, spiceLevel);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Record updated successfully!");
        } catch (SQLException throwables) {
            System.out.println("Error when running updateSpiceLevel()");
            throwables.printStackTrace();
        }
    }

    public static void deleteThaiFoodByID(Integer id){
        String query = "DELETE FROM name WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Thai food deleted successfully!");
        } catch (SQLException throwables) {
            System.out.println("Error when running deleteThaiFoodByID()");
            throwables.printStackTrace();
        }

    }
}
