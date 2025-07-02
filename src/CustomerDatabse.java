import java.sql.*;
import java.util.HashMap;

public class CustomerDatabse {

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/onlineSysten",
                "root",
                "Dps3!2006"
        );
    }

    public boolean checkUserPassword(String username, String password)
    {
        try(Connection connection = connection())
        {
            if(username.isEmpty() || password.isEmpty()) return false;
            PreparedStatement ps = connection.prepareStatement("SELECT Password FROM Customers WHERE UserName = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(!checkUserName(username)) return false;
            if(rs.next()) {
                if(rs.getString("Password").equals(password)) return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean changePassword (String username, String password1, String password2)
    {
        try(Connection connection = connection())
        {
            if(!password1.equals(password2))
                return false;
            PreparedStatement ps = connection.prepareStatement("Update Customers Set Password = ? Where UserName = ? ;");
            ps.setString(1, password1);
            ps.setString(2, username);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean checkUserName(String username)
    {
        try(Connection connection = connection())
        {
            if(username.isEmpty()) return false;
            PreparedStatement ps = connection.prepareStatement("Select Exists (Select 1 from Customers Where UserName = ?) As Contains");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                if (rs.getInt("Contains") == 0) return false;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public void addUser(String userName, String password)
    {
        try(Connection connection = connection())
        {
            PreparedStatement ps = connection.prepareStatement("Insert Into Customers(UserName, Password, Altair, Ezio, Desmond, Edward, Connor, Arno) Values (?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setInt(5, 0);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
