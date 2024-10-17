
/**
 * La clase Users representa un usuario en el sistema.
 * 
 * Esta clase contiene información relevante sobre un usuario, incluyendo su
 * identificador, nombre de usuario, contraseña, correo electrónico, nombre,
 * apellido, estado de habilitación y estado de sesión.
 * 
 * Proporciona métodos para obtener y establecer estos valores, así como
 * métodos para comparar objetos de esta clase y generar una representación
 * en cadena de texto del objeto.
 * 
 * 
 * Métodos disponibles:
 * 
 *   getId(): Obtiene el identificador del usuario.
 *   setId(int): Establece el identificador del usuario.
 *   getUsername(): Obtiene el nombre de usuario.
 *   setUsername(String): Establece el nombre de usuario.
 *   getPassword(): Obtiene la contraseña del usuario.
 *   setPassword(String): Establece la contraseña del usuario.
 *   getEmail(): Obtiene el correo electrónico del usuario.
 *   setEmail(String): Establece el correo electrónico del usuario.
 *   getFirst_name(): Obtiene el primer nombre del usuario.
 *   setFirst_name(String): Establece el primer nombre del usuario.
 *   getLast_name(): Obtiene el apellido del usuario.
 *   setLast_name(String): Establece el apellido del usuario.
 *   getEnabled(): Obtiene el estado de habilitación del usuario.
 *   setEnabled(int): Establece el estado de habilitación del usuario.
 *   isIs_logged_in(): Verifica si el usuario está conectado.
 *   getIs_logged_in(): Obtiene el estado de conexión del usuario.
 *   setIs_logged_in(boolean): Establece el estado de conexión del usuario.
 *   equals(Object): Compara este usuario con otro objeto.
 *   hashCode(): Devuelve un código hash para este usuario.
 *   toString(): Devuelve una representación en cadena de texto de este usuario.
 * 
 * 
 * Constructores:
 * 
 *   Users(int, String, String, String, String, String, int, boolean): Crea un nuevo usuario con los valores especificados.
 * 
 * 
 * Métodos de construcción:
 * 
 *   id(int): Establece el identificador del usuario y devuelve el objeto Users.
 *   username(String): Establece el nombre de usuario y devuelve el objeto Users.
 *   password(String): Establece la contraseña y devuelve el objeto Users.
 *   email(String): Establece el correo electrónico y devuelve el objeto Users.
 *   first_name(String): Establece el primer nombre y devuelve el objeto Users.
 *   last_name(String): Establece el apellido y devuelve el objeto Users.
 *   enabled(int): Establece el estado de habilitación y devuelve el objeto Users.
 *   is_logged_in(boolean): Establece el estado de conexión y devuelve el objeto Users.
 * 
 */
package Model;

import java.util.Objects;

public class Users {
    private int id;
    private String username;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private int enabled;
    private boolean is_logged_in;

    public Users(int id, String username, String password, String email, String first_name, String last_name,
            int enabled, boolean is_logged_in) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.enabled = enabled;
        this.is_logged_in = is_logged_in;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getEnabled() {
        return this.enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public boolean isIs_logged_in() {
        return this.is_logged_in;
    }

    public boolean getIs_logged_in() {
        return this.is_logged_in;
    }

    public void setIs_logged_in(boolean is_logged_in) {
        this.is_logged_in = is_logged_in;
    }

    public Users id(int id) {
        setId(id);
        return this;
    }

    public Users username(String username) {
        setUsername(username);
        return this;
    }

    public Users password(String password) {
        setPassword(password);
        return this;
    }

    public Users email(String email) {
        setEmail(email);
        return this;
    }

    public Users first_name(String first_name) {
        setFirst_name(first_name);
        return this;
    }

    public Users last_name(String last_name) {
        setLast_name(last_name);
        return this;
    }

    public Users enabled(int enabled) {
        setEnabled(enabled);
        return this;
    }

    public Users is_logged_in(boolean is_logged_in) {
        setIs_logged_in(is_logged_in);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Users)) {
            return false;
        }
        Users users = (Users) o;
        return id == users.id && Objects.equals(username, users.username) && Objects.equals(password, users.password)
                && Objects.equals(email, users.email) && Objects.equals(first_name, users.first_name)
                && Objects.equals(last_name, users.last_name) && enabled == users.enabled
                && is_logged_in == users.is_logged_in;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", email='" + getEmail() + "'" +
                ", first_name='" + getFirst_name() + "'" +
                ", last_name='" + getLast_name() + "'" +
                ", enabled='" + getEnabled() + "'" +
                ", is_logged_in='" + isIs_logged_in() + "'" +
                "}";
    }

}
