
/**
 * Clase PricesServices que extiende de Conexion y proporciona servicios para 
 * gestionar los precios en la base de datos.
 */
package Services;

import java.sql.Connection;
import java.util.ArrayList;
import Model.Prices;

public class PricesServices extends Conexion {

    private Connection con = getConnection();

    /**
     * Método para obtener todos los precios de la base de datos.
     * 
     * @return ArrayList<Prices> Lista de precios obtenidos de la base de datos.
     */
    public ArrayList<Prices> showPrices() {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM prices;");
            ArrayList<Prices> prices = new ArrayList<Prices>();
            while (rs.next()) {
                prices.add(
                        new Prices(
                                rs.getInt("id"),
                                rs.getInt("articles_id"),
                                rs.getInt("surveys_id"),
                                rs.getDouble("price")));
            }
            rs.close();
            stmt.close();
            con.close();
            return prices;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    /**
     * Método para crear un nuevo precio en la base de datos.
     * 
     * @param p Objeto Prices que contiene los datos del nuevo precio.
     */
    public void createPrice(Prices p) {
        {
            try {

                pstmt = con.prepareStatement(
                        "INSERT INTO prices (articles_id, surveys_id, price) VALUES (?,?,?);");
                pstmt.setInt(1, p.getArticles_id());
                pstmt.setInt(2, p.getSurveys_id());
                pstmt.setDouble(3, p.getPrice());
                pstmt.executeUpdate();
                pstmt.close();
                con.close();
            } catch (Exception e) {

                System.out.println("Error al guardar el precio del articulo " + p.getArticles_id() + " Causa: " + e);

            }

        }
    }

    /**
     * Método para actualizar un precio existente en la base de datos.
     * 
     * @param p Objeto Prices que contiene los datos actualizados del precio.
     */
    public void updatePrice(Prices p) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE prices SET articles_id=?, surveys_id=?, price=? WHERE id=?;");
            pstmt.setInt(1, p.getArticles_id());
            pstmt.setInt(2, p.getSurveys_id());
            pstmt.setDouble(3, p.getPrice());
            pstmt.setInt(4, p.getId());
            pstmt.executeUpdate();
            System.out.println("Precio modificada correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Método para eliminar un precio de la base de datos.
     * 
     * @param p Objeto Prices que contiene el ID del precio a eliminar.
     */
    public void deletePrice(Prices p) {
        try {
            pstmt = con.prepareStatement(
                    "DELETE FROM prices WHERE id=?;");
            pstmt.setInt(1, p.getId());
            pstmt.executeUpdate();
            System.out.println("Precio eliminada correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
