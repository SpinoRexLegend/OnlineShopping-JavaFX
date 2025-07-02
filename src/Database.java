import java.sql.*;
import java.util.HashMap;

public class Database {


    private Connection connection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/onlineSysten",
                "root",
                "Dps3!2006"
        );
    }

    public void addList(HashMap<String, Integer> hash, String userName) {
        try (Connection connection = connection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE Customers SET Altair = ?, Ezio = ?, Desmond = ?, Edward = ?, Connor = ?, Arno = ? where userName = ?");
            ps.setInt(1, getCustomerQty("Altair", userName)+hash.get("Altair"));
            ps.setInt(2, getCustomerQty("Ezio", userName)+hash.get("Ezio"));
            ps.setInt(3, getCustomerQty("Desmond", userName)+hash.get("Desmond"));
            ps.setInt(4, getCustomerQty("Edward", userName)+hash.get("Edward"));
            ps.setInt(5, getCustomerQty("Connor", userName)+hash.get("Connor"));
            ps.setInt(6, getCustomerQty("Arno", userName)+hash.get("Arno"));
            ps.setString(7, userName);
            ps.executeUpdate();
            System.out.println(userName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double getPrice(String item) {
        try (Connection connection = connection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT UnitPrice from Items where ItemName = ?");
            ps.setString(1, item);
            ResultSet rs = ps.executeQuery();
            return ((rs.next())?rs.getDouble("UnitPrice"): 0.0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeData(HashMap<String, Integer> hash)
    {
        try (Connection connection = connection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE Items SET Qty = ? WHERE ItemName = ?");
            for(String key: hash.keySet())
            {
                ps.setInt(1, Math.max(getQty(key) - hash.get(key), 0));
                ps.setString(2, key);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getCustomerQty(String prod, String userName)
    {
        try (Connection connection = connection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT "+prod+" from Customers where UserName = ?");
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            return ((rs.next())?rs.getInt(prod): 0);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getQty(String name)
    {
        try (Connection connection = connection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT Qty from Items where ItemName = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            return ((rs.next())?rs.getInt("Qty"): 0);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

