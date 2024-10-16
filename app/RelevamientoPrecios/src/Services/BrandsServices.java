package Services;

import java.sql.Connection;
import java.util.ArrayList;

import Model.Brands;

public class BrandsServices extends Conexion {

    private Connection con = getConnection();

    public ArrayList<Brands> showBrands() {
        try {
            stmt = this.con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM brands;");
            ArrayList<Brands> brands = new ArrayList<Brands>();
            while (rs.next()) {
                brands.add(
                        new Brands(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("type")));
            }
            rs.close();
            stmt.close();
            con.close();
            return brands;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    public void createBrand(Brands b) {
        {
            try {

                pstmt = con.prepareStatement(
                        "INSERT INTO brands (sku, type) VALUES (?,?);");
                pstmt.setString(1, b.getName());
                pstmt.setString(2, b.getType());
                pstmt.executeUpdate();
                System.out.println("Marca creada correctamente");
                pstmt.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
    }

    public void updateBrand(Brands b) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE brands SET name = ?, type = ? WHERE id=?;");
            pstmt.setString(1, b.getName());
            pstmt.setString(2, b.getType());
            pstmt.setInt(3, b.getId());
            pstmt.executeUpdate();
            System.out.println("Marca modificada correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void deleteBrand(Brands b) {
        try {
            pstmt = con.prepareStatement(
                    "DELETE FROM brands WHERE id=?;");
            pstmt.setInt(1, b.getId());
            pstmt.executeUpdate();
            System.out.println("Articulo eliminado correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
