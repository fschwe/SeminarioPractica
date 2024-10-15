package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.Users;

public class UsersServices extends Conexion {

    private Connection con = getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void showUsers() {
        try {
            stmt = this.con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users;");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("email") + " "
                        + rs.getString("password"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void createUser(Users u) {
        {
            try {

                pstmt = con.prepareStatement(
                        "INSERT INTO users (username, password, email, first_name, last_name, enabled) VALUES (?,?,?,?,?,?);");
                pstmt.setString(1, u.getUsername());
                pstmt.setString(2, u.getPassword());
                pstmt.setString(3, u.getEmail());
                pstmt.setString(4, u.getFirst_name());
                pstmt.setString(5, u.getLast_name());
                pstmt.setInt(6, u.getEnabled());
                pstmt.executeUpdate();
                System.out.println("Usuario creado correctamente");
                pstmt.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
    }

    public void updateUser(Users u) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE users SET username = ?, password = ?, email ?, first_name=?, last_name=?, enabled=? WHERE id=?;");
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getFirst_name());
            pstmt.setString(5, u.getLast_name());
            pstmt.setInt(6, u.getEnabled());
            pstmt.setInt(7, u.getId());
            pstmt.executeUpdate();
            System.out.println("Usuario creado correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void deleteUser(Users u) {
        try {
            pstmt = con.prepareStatement(
                    "DELETE FROM users WHERE id=?;");
            pstmt.setInt(1, u.getId());
            pstmt.executeUpdate();
            System.out.println("Usuario creado correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public Users getUser(String username) {
        try {

            pstmt = con.prepareStatement("SELECT  * FROM users WHERE username = ? LIMIT 1;");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Users u = new Users(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("email"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getInt("enabled"),
                        false);
                return u;
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

}
