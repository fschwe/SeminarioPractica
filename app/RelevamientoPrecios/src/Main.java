
import Model.Competitors;
import Model.Sites;
import Model.Users;
import Services.Menu;
import Services.SitesServices;
import View.CompetitorsView;
import View.PricesView;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.UsersController;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Menu menu = new Menu();
    private static Users user;

    public static void main(String[] args) {
        int option = -1;
        System.out.println("eliminar el logueo auto");
        System.out.println("Ingrese como usuario 99999997 y password como usuario de prueba");
        user = menu.loginMenu();
        while (user.getIs_logged_in() && option != 0) {
            menu.showMenu();
            option = sc.nextInt();
            menu.handleMenu(option);

        }

    }
}