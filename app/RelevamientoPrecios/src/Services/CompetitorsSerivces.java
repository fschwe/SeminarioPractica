package Services;

import java.sql.Connection;
import java.util.ArrayList;

import Model.Competitors;

public class CompetitorsSerivces extends Conexion {

    private Connection con = getConnection();

    public ArrayList<Competitors> showCompetitors() {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM competitors;");
            ArrayList<Competitors> competitors = new ArrayList<Competitors>();
            while (rs.next()) {
                competitors.add(
                        new Competitors(
                                rs.getInt("id"),
                                rs.getInt("sites_id"),
                                rs.getInt("brands_id"),
                                rs.getString("name"),
                                rs.getString("address"),
                                rs.getString("latitude"),
                                rs.getString("longitude")));
            }
            rs.close();
            stmt.close();
            con.close();
            return competitors;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    public void createCompetitor(Competitors c) {
        {
            try {

                pstmt = con.prepareStatement(
                        "INSERT INTO competitors (sites_id, brands_id, name, address, latitude, longitude) VALUES (?,?,?,?,?,?);");
                pstmt.setInt(1, c.getSites_id());
                pstmt.setInt(2, c.getBrands_id());
                pstmt.setString(3, c.getName());
                pstmt.setString(4, c.getAddress());
                pstmt.setString(5, c.getLatitude());
                pstmt.setString(6, c.getLongitude());
                pstmt.executeUpdate();
                System.out.println("Competidor creado correctamente");
                pstmt.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
    }

    public void updateCompetitor(Competitors c) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE competitors SET sites_id=?, brands_id=?, name=?, address=?, latitude=?, longitude=? WHERE id=?;");
            pstmt.setInt(1, c.getSites_id());
            pstmt.setInt(2, c.getBrands_id());
            pstmt.setString(3, c.getName());
            pstmt.setString(4, c.getAddress());
            pstmt.setString(5, c.getLatitude());
            pstmt.setString(6, c.getLongitude());
            pstmt.setInt(7, c.getId());
            pstmt.executeUpdate();
            System.out.println("Competidor modificado correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void deleteCompetitor(Competitors c) {
        try {
            pstmt = con.prepareStatement(
                    "DELETE FROM competitors WHERE id=?;");
            pstmt.setInt(1, c.getId());
            pstmt.executeUpdate();
            System.out.println("Competidor eliminado correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}