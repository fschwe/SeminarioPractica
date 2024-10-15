package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/sp_relev";
    private String user = "root";
    private String password = "root";
    private Connection con = null;

    public Connection getConnection() {
        try {
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());

        }
        return con;
    }
}
