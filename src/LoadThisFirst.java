import java.sql.*;

public class LoadThisFirst {

    private static Connection connection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/onlineSystem",
                "root",
                "Dps3!2006"
        );
    }

    public static void addCustomer(String username, String password) {
        try (Connection conn = connection()) {
            String sql = "INSERT INTO Customers (UserName, Password, Altair, Ezio, Desmond, Edward, Connor, Arno) VALUES (?, ?, 0, 0, 0, 0, 0, 0)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println("Customer added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addItem(String itemName, int qty, double price) {
        try (Connection conn = connection()) {
            String sql = "INSERT INTO Items (ItemName, Qty, UnitPrice) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, itemName);
            ps.setInt(2, qty);
            ps.setDouble(3, price);
            ps.executeUpdate();
            System.out.println("Item added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        addCustomer("user2", "mypassword");
        addItem("Arno", 5, 9.99);
    }
}