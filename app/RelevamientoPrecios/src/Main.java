import Model.Users;
import Services.Menu;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option = -1;
        Menu menu = new Menu();
        Users user;
        user = menu.loginMenu();
        if (user.isIs_logged_in() && option != 0) {
            menu.showMenu();
            option = sc.nextInt();
            menu.handleMenu(option);
        }
    }
}