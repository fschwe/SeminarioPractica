package Services;

import java.util.Scanner;

import Controller.UsersController;
import Model.Users;

public class Menu {
    private Scanner sc = new Scanner(System.in);

    public void showMenu() {
        System.out.println("1. Gestion de articulos");
        System.out.println("2. Gestion de marcas");
        System.out.println("3. Gestion de competidores");
        System.out.println("4. Gestion de relevamientos");
        System.out.println("5. Gestion de sitios");
        System.out.println("6. Nuevo relevamiento");
        System.out.println("0. Salir");
    }

    public void showArticulosMenu() {
        System.out.println("1. Listar articulos");
        System.out.println("2. Agregar articulo");
        System.out.println("3. Modificar articulo");
        System.out.println("4. Eliminar articulo");
        System.out.println("0. Volver");
    }

    public Users loginMenu() {
        String username = "";
        String password = "";
        System.out.println("Ingrese su usuario: ");
        username = sc.nextLine();
        System.out.println("Ingrese su contraseña: ");
        password = sc.nextLine();
        UsersController uc = new UsersController();
        return uc.login(username, password);

    }

    public void handleMenu(int option) {
        switch (option) {
            case 1:
                showArticulosMenu();
                break;
            case 2:
                System.out.println("Gestion de marcas - en construccion");
                break;
            case 3:
                System.out.println("Gestion de competidores - en construccion");
                break;
            case 4:
                System.out.println("Gestion de relevamientos - en construccion");
                break;
            case 5:
                System.out.println("Gestion de sitios - en construccion");
                break;
            case 6:
                System.out.println("Nuevo relevamiento");
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
