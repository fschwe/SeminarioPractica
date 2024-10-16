package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/sp_relev";
    private String user = "root";
    private String password = "root";
    private Connection con = null;

    protected PreparedStatement pstmt = null;
    protected Statement stmt = null;
    protected ResultSet rs = null;

    public Connection getConnection() {
        try {
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());

        }
        return con;
    }
}
