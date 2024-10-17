package Controller;

import Model.Users;
import Services.UsersServices;

public class UsersController {

    private Users user;
    private UsersServices us = new UsersServices();

    /**
     * Controlador para gestionar las operaciones relacionadas con los usuarios.
     * Esta clase proporciona los métodos necesarios para manejar las solicitudes
     * y respuestas relacionadas con los usuarios en la aplicación.
     */
    public UsersController() {
    }

    /**
     * Método para iniciar sesión de un usuario.
     *
     * @param username El nombre de usuario del usuario que intenta iniciar sesión.
     * @param password La contraseña del usuario que intenta iniciar sesión.
     * @return El objeto Users si el inicio de sesión es exitoso, de lo contrario,
     *         retorna null.
     * 
     *         Este método verifica si el nombre de usuario existe y si la
     *         contraseña proporcionada
     *         coincide con la almacenada. Si las credenciales son correctas, se
     *         limpia la consola,
     *         se muestra un mensaje de bienvenida y se marca al usuario como
     *         conectado.
     *         Si las credenciales son incorrectas, se muestra un mensaje de error
     *         correspondiente.
     */
    public Users login(String username, String password) {
        System.out.println("Login");
        user = us.getUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {

                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Bienvenido " + user.getFirst_name() + " " + user.getLast_name());
                user.setIs_logged_in(true);
                return user;
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } else {
            System.out.println("Usuario no encontrado");
        }
        return user;
    }

}
