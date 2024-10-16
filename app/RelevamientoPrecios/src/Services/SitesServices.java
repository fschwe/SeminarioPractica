package Services;

import java.sql.Connection;
import java.util.ArrayList;

import Model.Sites;

public class SitesServices extends Conexion {

    private Connection con = getConnection();

    public ArrayList<Sites> showSites() {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM sites;");
            ArrayList<Sites> sites = new ArrayList<Sites>();
            while (rs.next()) {
                sites.add(
                        new Sites(
                                rs.getInt("id"),
                                rs.getString("number"),
                                rs.getString("description")));
            }
            rs.close();
            stmt.close();
            con.close();
            return sites;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    public void createSite(Sites s) {
        {
            try {

                pstmt = con.prepareStatement(
                        "INSERT INTO sites (number, description) VALUES (?,?);");
                pstmt.setString(1, s.getNumber());
                pstmt.setString(2, s.getDescrption());
                pstmt.executeUpdate();
                System.out.println("Precio creada correctamente");
                pstmt.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
    }

    public void updateSite(Sites s) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE sites SET number=?, description=? WHERE id=?;");
            pstmt.setString(1, s.getNumber());
            pstmt.setString(2, s.getDescrption());

            pstmt.setInt(3, s.getId());
            pstmt.executeUpdate();
            System.out.println("Precio modificada correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void deleteSite(Sites s) {
        try {
            pstmt = con.prepareStatement(
                    "DELETE FROM sites WHERE id=?;");
            pstmt.setInt(1, s.getId());
            pstmt.executeUpdate();
            System.out.println("Precio eliminada correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
