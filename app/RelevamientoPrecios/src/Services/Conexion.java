
/**
 * La clase Conexion proporciona métodos para establecer una conexión con una base de datos MySQL.
 * 
 * Esta clase utiliza JDBC para conectarse a una base de datos MySQL especificada por la URL,
 * el usuario y la contraseña proporcionados. También incluye atributos para manejar sentencias
 * preparadas, sentencias y resultados de consultas.
 * 
 */
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
