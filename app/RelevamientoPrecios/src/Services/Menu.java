package Services;

import java.util.Scanner;

import Controller.UsersController;
import Model.Users;
import View.SurveysView;

public class Menu {
    private Scanner sc = new Scanner(System.in);

    public void showMenu() {
        System.out.println("1. Nuevo relevamiento");
        System.out.println("2. Gestion de relevamientos ");
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
        return uc.login(username, password);

    }

    public void handleMenu(int option) {
        switch (option) {
            case 1:
                SurveysView sv = new SurveysView();
                sv.newSurvey();
                break;
            case 2:
                break;
            case 3:

                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
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
