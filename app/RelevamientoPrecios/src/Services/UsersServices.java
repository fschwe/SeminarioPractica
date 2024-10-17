
/**
 * Clase UsersServices que extiende de Conexion y proporciona servicios para la gestión de usuarios.
 * 
 * Métodos:
 * 
 * - showUsers(): Muestra todos los usuarios de la base de datos.
 * - createUser(Users u): Crea un nuevo usuario en la base de datos.
 * - updateUser(Users u): Actualiza un usuario existente en la base de datos.
 * - deleteUser(Users u): Elimina un usuario de la base de datos.
 * - getUser(String username): Obtiene un usuario de la base de datos por su nombre de usuario.
 * 
 * Atributos:
 * 
 * - con: Conexión a la base de datos.
 * - pstmt: PreparedStatement para ejecutar consultas SQL.
 * - stmt: Statement para ejecutar consultas SQL.
 * - rs: ResultSet para almacenar los resultados de las consultas SQL.
 * 
 * Excepciones:
 * 
 * - En caso de error en la ejecución de cualquier método, se captura la excepción y se imprime un mensaje de error en la consola.
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Users;

public class UsersServices extends Conexion {

    private Connection con = getConnection();
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    /**
     * Método para mostrar todos los usuarios.
     * 
     * Este método se conecta a la base de datos, ejecuta una consulta para obtener
     * todos los registros de la tabla "users" y los almacena en una lista de
     * objetos
     * de tipo Users. Luego, cierra los recursos utilizados para la conexión a la
     * base
     * de datos.
     * 
     * En caso de que ocurra una excepción durante la ejecución, se captura y se
     * imprime
     * un mensaje de error en la consola.
     * 
     * @throws SQLException si ocurre un error al interactuar con la base de datos.
     */
    public void showUsers() {
        try {
            stmt = this.con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users;");
            ArrayList<Users> users = new ArrayList<Users>();
            while (rs.next()) {
                users.add(new Users(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("email"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getInt("enabled"),
                        false));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Crea un nuevo usuario en la base de datos.
     *
     * @param u El objeto Users que contiene la información del usuario a crear.
     * 
     *          Este método inserta un nuevo registro en la tabla 'users' con los
     *          datos proporcionados
     *          en el objeto Users. Los campos que se insertan son: username,
     *          password, email, first_name,
     *          last_name y enabled. Si la operación es exitosa, se imprime un
     *          mensaje de confirmación.
     *          En caso de error, se captura la excepción y se imprime un mensaje de
     *          error.
     *
     *          Ejemplo de uso:
     * 
     *          Users nuevoUsuario = new Users("username", "password",
     *          "email@example.com", "Nombre", "Apellido", 1);
     *          usersServices.createUser(nuevoUsuario);
     * 
     */
    public void createUser(Users u) {
        {
            try {

                pstmt = con.prepareStatement(
                        "INSERT INTO users (username, password, email, first_name, last_name, enabled) VALUES (?,?,?,?,?,?);");
                pstmt.setString(1, u.getUsername());
                pstmt.setString(2, u.getPassword());
                pstmt.setString(3, u.getEmail());
                pstmt.setString(4, u.getFirst_name());
                pstmt.setString(5, u.getLast_name());
                pstmt.setInt(6, u.getEnabled());
                pstmt.executeUpdate();
                System.out.println("Usuario creado correctamente");
                pstmt.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        }
    }

    /**
     * Actualiza la información de un usuario en la base de datos.
     *
     * @param u El objeto Users que contiene la información actualizada del usuario.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     * @throws Exception    Si ocurre cualquier otro error durante la actualización
     *                      del usuario.
     *
     *                      Este método actualiza los siguientes campos del usuario
     *                      en la base de datos:
     * 
     *                      username - El nombre de usuario.
     *                      password - La contraseña del usuario.
     *                      email - El correo electrónico del usuario.
     *                      first_name - El primer nombre del usuario.
     *                      last_name - El apellido del usuario.
     *                      enabled - El estado de habilitación del usuario.
     * 
     * 
     *
     *                      El método cierra la conexión y el PreparedStatement
     *                      después de ejecutar la actualización.
     *
     *                      En caso de error, se imprime un mensaje de error en la
     *                      consola.
     */
    public void updateUser(Users u) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE users SET username = ?, password = ?, email ?, first_name=?, last_name=?, enabled=? WHERE id=?;");
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getFirst_name());
            pstmt.setString(5, u.getLast_name());
            pstmt.setInt(6, u.getEnabled());
            pstmt.setInt(7, u.getId());
            pstmt.executeUpdate();
            System.out.println("Usuario modificado correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param u El objeto Users que representa al usuario a eliminar.
     * @throws SQLException         Si ocurre un error al ejecutar la consulta SQL.
     * @throws NullPointerException Si la conexión a la base de datos es nula.
     */
    public void deleteUser(Users u) {
        try {
            pstmt = con.prepareStatement(
                    "DELETE FROM users WHERE id=?;");
            pstmt.setInt(1, u.getId());
            pstmt.executeUpdate();
            System.out.println("Usuario eliminado correctamente");
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Obtiene un usuario de la base de datos basado en el nombre de usuario
     * proporcionado.
     *
     * @param username El nombre de usuario del usuario que se desea obtener.
     * @return Un objeto de tipo Users que contiene la información del usuario si se
     *         encuentra,
     *         de lo contrario, retorna null.
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL.
     */
    public Users getUser(String username) {
        try {

            pstmt = con.prepareStatement("SELECT  * FROM users WHERE username = ? LIMIT 1;");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Users u = new Users(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("email"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getInt("enabled"),
                        false);
                return u;
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

}
