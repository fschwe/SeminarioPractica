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
    public int hashCode() {
        return Objects.hash(id, username, password, email, first_name, last_name, enabled, is_logged_in);
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
