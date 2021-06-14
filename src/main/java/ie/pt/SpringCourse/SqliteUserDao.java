package ie.pt.SpringCourse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqliteUserDao implements UserDao {

    protected String connectionString = "jdbc:sqlite:C:/data/SpringCourse/UserDb.db";
    protected Connection conn;

    public SqliteUserDao() {

        try {
            // load jdbc driver into memory
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(connectionString);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    public void close() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User getUser(int id) {
        String sql = "select * from users where id = ?";
        User user = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getBoolean("active")
                );
            }
            rs.close();
            pstmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        String sql = "select * from users";
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getBoolean("active")
                );
                users.add(user);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
