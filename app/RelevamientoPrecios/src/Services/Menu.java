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
        username = "99999997";
        password = "password";
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
                System.out.println("hola");
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
