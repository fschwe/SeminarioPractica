
/**
 * La clase BrandsServices proporciona servicios para gestionar las marcas en la base de datos.
 * Extiende la clase Conexion para obtener la conexión a la base de datos.
 * 
 * Métodos:
 * 
 * - showBrands(): Devuelve una lista de todas las marcas en la base de datos.
 * - createBrand(Brands b): Crea una nueva marca en la base de datos.
 * - updateBrand(Brands b): Actualiza una marca existente en la base de datos.
 * - deleteBrand(Brands b): Elimina una marca de la base de datos.
 * 
 * Atributos:
 * 
 * - con: Conexión a la base de datos.
 * 
 * Excepciones:
 * 
 * - En caso de error en la conexión o en la ejecución de las consultas SQL, se captura la excepción y se imprime un mensaje de error.
 * 
 * Ejemplo de uso:
 * 
 * BrandsServices service = new BrandsServices();
 * ArrayList<Brands> brands = service.showBrands();
 * 
 */
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
