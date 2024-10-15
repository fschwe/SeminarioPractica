package Controller;

import java.io.IOException;

import Model.Users;
import Services.UsersServices;

public class UsersController {

    private Users user;
    private UsersServices us = new UsersServices();

    public UsersController() {
    }

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
