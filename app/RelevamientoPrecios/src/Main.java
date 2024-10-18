
import Model.Users;
import Services.Menu;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Menu menu = new Menu();
    private static Users user;

    /**
     * Método principal que inicia la aplicación de Relevamiento de Precios.
     * 
     * Este método muestra un mensaje inicial para eliminar el logueo automático y
     * proporciona instrucciones para ingresar como usuario de prueba. Luego,
     * entra en un bucle que muestra el menú principal y maneja las opciones
     * seleccionadas por el usuario mientras el usuario esté logueado y la opción
     * seleccionada no sea 0.
     * 
     */
    public static void main(String[] args) {
        int option = -1;
        System.out.println("Ingrese como usuario 99999997 y password como usuario de prueba");
        user = menu.loginMenu();
        while (user.getIs_logged_in() && option != 0 && user != null) {
            menu.showMenu();
            option = sc.nextInt();
            menu.handleMenu(option);
        }

    }
}