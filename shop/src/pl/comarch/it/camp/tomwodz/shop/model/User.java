package pl.comarch.it.camp.tomwodz.shop.model;

public class User {
    private String login;
    private String password;
    private String role;
    private String name;
    private String emial;

    private boolean available;

    public User(String login, String password, String role, String name, String emial, boolean available) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.emial = emial;
        this.available = available;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login) {
        this.login = login;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return new StringBuilder().
                append(getLogin()).
                append(" ").
                append(getRole()).
                append("         ").
                append(getName()).
                append(" ").
                append(getEmial()).
                toString();
    }
}
