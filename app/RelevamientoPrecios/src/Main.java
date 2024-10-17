
import Model.Competitors;
import Model.Sites;
import Model.Users;
import Services.Menu;
import Services.SitesServices;
import View.CompetitorsView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        SitesServices sites = new SitesServices();
        Sites site = sites.getSite("3");
        if (site == null) {
            System.err.println("nulo");
        }
        CompetitorsView cv = new CompetitorsView();
        Competitors competitor = cv.selectCompetitor(site);
        System.out.println(competitor.toString());

        // -------------------------------------------------------------------------

        int option = -1;
        Menu menu = new Menu();
        Users user;
        System.out.println("eliminar el logueo auto");
        System.out.println("Ingrese como usuario 99999997 y password como usuario de prueba");
        user = menu.loginMenu();
        if (user.isIs_logged_in() && option != 0) {
            menu.showMenu();
            option = sc.nextInt();
            menu.handleMenu(option);
        }

    }
}