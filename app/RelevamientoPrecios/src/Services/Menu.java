
/**
 * La clase Menu proporciona una interfaz de usuario para interactuar con el sistema de relevamiento de precios.
 * Permite a los usuarios iniciar sesión y seleccionar diferentes opciones del menú.
 * 
 * Métodos:
 * - showMenu(): Muestra las opciones del menú en la consola.
 * - loginMenu(): Solicita al usuario su nombre de usuario y contraseña, y realiza el inicio de sesión.
 * - handleMenu(int option): Maneja la opción seleccionada por el usuario y ejecuta la acción correspondiente.
 * 
 * Atributos:
 * - sc: Scanner para leer la entrada del usuario desde la consola.
 * - user: Objeto Users que representa al usuario actualmente autenticado.
 * 
 * Opciones del menú:
 * 1. Nuevo relevamiento
 * 2. Gestión de relevamientos (No forma parte del MVP)
 * 3. Gestión de artículos (No forma parte del MVP)
 * 4. Gestión de marcas (No forma parte del MVP)
 * 5. Gestión de competidores (No forma parte del MVP)
 * 6. Gestión de sitios (No forma parte del MVP)
 * 0. Salir
 * 
 * Nota: Las opciones 2 a 6 no están desarrolladas y no forman parte del MVP (Producto Mínimo Viable).
 */
package Services;

import java.util.Scanner;

import Controller.UsersController;
import Model.Users;
import View.SurveysView;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Users user;

    public void showMenu() {

        System.out.println("1. Nuevo relevamiento");
        System.out.println("2. Gestion de relevamientos - No forma parte del MVP");
        System.out.println("3. Gestion de articulos     - No forma parte del MVP");
        System.out.println("4. Gestion de marcas        - No forma parte del MVP");
        System.out.println("5. Gestion de competidores  - No forma parte del MVP");
        System.out.println("6. Gestion de sitios        - No forma parte del MVP");
        System.out.println("0. Salir");
    }

    public Users loginMenu() {
        String username = "";
        String password = "";
        System.out.println("Ingrese su usuario: ");
        username = sc.nextLine();
        System.out.println("Ingrese su contraseña: ");
        password = sc.nextLine();
        /*
         * Para probar el login con un usuario de prueba, descomentar las siguientes
         * líneas:
         * username = "99999997";
         * password = "password";
         */
        UsersController uc = new UsersController();
        user = uc.login(username, password);
        return user;

    }

    public void handleMenu(int option) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        switch (option) {
            case 1:
                SurveysView sv = new SurveysView();
                sv.newSurvey(this.user);
                break;
            case 2:
                System.out.println("Funcionalidad no desarrollada, elija otra opcion");
                break;
            case 3:
                System.out.println("Funcionalidad no desarrollada, elija otra opcion");
                break;
            case 4:
                System.out.println("Funcionalidad no desarrollada, elija otra opcion");
                break;
            case 5:
                System.out.println("Funcionalidad no desarrollada, elija otra opcion");
                break;
            case 6:
                System.out.println("Funcionalidad no desarrollada, elija otra opcion");
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
}
