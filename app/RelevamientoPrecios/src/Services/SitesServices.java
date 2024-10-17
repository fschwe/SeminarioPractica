
/**
 * La clase SitesServices proporciona servicios para interactuar con la base de datos de sitios.
 * Extiende la clase Conexion para obtener la conexión a la base de datos.
 * 
 * Métodos:
 * 
 * - showSites(): Devuelve una lista de todos los sitios en la base de datos.
 * - getSite(String number): Devuelve un sitio específico basado en su número.
 * - createSite(Sites s): Crea un nuevo sitio en la base de datos.
 * - updateSite(Sites s): Actualiza un sitio existente en la base de datos.
 * - deleteSite(Sites s): Elimina un sitio de la base de datos.
 * 
 * Atributos:
 * 
 * - con: Conexión a la base de datos.
 * 
 * Manejo de Excepciones:
 * 
 * Cada método maneja las excepciones imprimiendo un mensaje de error en la consola y, en algunos casos, devolviendo null.
 * 
 */
package Services;

import java.sql.Connection;
import java.util.ArrayList;

import Model.Sites;

public class SitesServices extends Conexion {

    private Connection con = getConnection();

    /**
     * Método para obtener una lista de sitios desde la base de datos.
     *
     * @return ArrayList<Sites> Una lista de objetos Sites que contiene todos los
     *         sitios obtenidos de la base de datos.
     *         Devuelve null en caso de que ocurra una excepción.
     */
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

    /**
     * Obtiene un sitio a partir de su número.
     *
     * @param number El número del sitio que se desea obtener.
     * @return Un objeto Sites que representa el sitio encontrado, o null si no se
     *         encuentra ningún sitio.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     * @throws Exception    Si ocurre cualquier otro error durante la ejecución del
     *                      método.
     */
    public Sites getSite(String number) {
        Sites site = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM sites where number=?;");
            pstmt.setString(1, number);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                site = new Sites(
                        rs.getInt("id"),
                        rs.getString("number"),
                        rs.getString("description"));
            }
            rs.close();
            pstmt.close();
            con.close();
            return site;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    /**
     * Crea un nuevo sitio en la base de datos.
     *
     * @param s El objeto Sites que contiene la información del sitio a crear.
     * @throws SQLException         Si ocurre un error al interactuar con la base de
     *                              datos.
     * @throws NullPointerException Si el objeto Sites proporcionado es nulo.
     * 
     *                              Este método prepara una declaración SQL para
     *                              insertar un nuevo registro en la tabla "sites"
     *                              con el número y la descripción proporcionados
     *                              por el objeto Sites. Si la operación es exitosa,
     *                              se imprime un mensaje de confirmación en la
     *                              consola. En caso de error, se captura la
     *                              excepción
     *                              y se imprime un mensaje de error en la consola.
     */
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

    /**
     * Elimina un sitio de la base de datos.
     *
     * @param s El objeto Sites que se desea eliminar.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     * @throws Exception    Si ocurre cualquier otro error durante la operación.
     */
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
