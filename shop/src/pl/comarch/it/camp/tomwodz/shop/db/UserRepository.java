package pl.comarch.it.camp.tomwodz.shop.db;

import pl.comarch.it.camp.tomwodz.shop.model.User;

import java.util.*;

public class UserRepository {
    private Map<String, User> users = new HashMap<>();

    private static final UserRepository instance = new UserRepository();

    private UserRepository() {
        /*this.users.put("admin", new User("admin", "76a0219bf06f2ebcb96a0334b4814e8c", "ADMIN", "Tomek", "twodzinski@op.pl", true));
        this.users.put("Tomek", new User("Tomek", "76a0219bf06f2ebcb96a0334b4814e8c", "USER", "Tomek", "twodzinski@op.pl", true));*/
    }

    public Collection<User> getUser() {
        return this.users.values();
    }

    public User findUserByLogin(String login) {
        return this.users.get(login);
    }

    public void createNewUser(User user) {
        this.users.put(user.getLogin(), new User(user.getLogin(), user.getPassword(), "USER", user.getName(), user.getEmial(), true));
        System.out.println("Success. Uzytkownik zostal utworzony.");
    }

    public void addUser(User user) {
        this.users.put(user.getLogin(), user);
    }

    public static UserRepository getInstance(){
        return instance;
    }

}
