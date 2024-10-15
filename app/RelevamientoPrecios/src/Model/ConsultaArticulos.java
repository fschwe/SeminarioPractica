package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Services.Conexion;

public class ConsultaArticulos extends Conexion {
    public void getArticulos() {
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = getConnection();
        try {
            String query = "SELECT * FROM articles;";
            st = con.prepareStatement(query);
            // st.setInt(1, p.id);
            rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
