package pl.comarch.it.camp.tomwodz.shop.core;

import org.apache.commons.codec.digest.DigestUtils;
import pl.comarch.it.camp.tomwodz.shop.GUI.GUI;
import pl.comarch.it.camp.tomwodz.shop.db.UserRepository;
import pl.comarch.it.camp.tomwodz.shop.model.User;

import java.util.Random;

public class Authenticator {

    static private UserRepository usersDataBase = new UserRepository();
    private static final String seed = "uxU9xUQWQMbZQm6rmtHd";

    public static String authenticate() {
        int counter = 0;
        while (counter < 3) {

            User userFromGUI = GUI.readLoginAndPassword();
            User userFromDb = usersDataBase.findUserByLogin(userFromGUI.getLogin());
            if (userFromDb != null && userFromDb.getPassword().equals(DigestUtils.md5Hex(userFromGUI.getPassword() + seed))) {
                System.out.println("Correct login!");
                return userFromDb.getRole();
            }
            System.out.println("Incorrect login and password! Try again!");
            counter++;
        }
        return null;
    }

    public static void registration() {
        int counter =0;
        while (counter < 3) {
            User userFromGUI = GUI.readLogin();
            User userFromDb = usersDataBase.findUserByLogin(userFromGUI.getLogin());
            if (userFromDb == null) {
                System.out.println("Podany login jest wolny.");
                userFromGUI.setPassword(DigestUtils.md5Hex(GUI.savePassword() + seed));
                userFromGUI.setName(GUI.saveName());
                userFromGUI.setEmial(GUI.saveEmail());
                usersDataBase.createNewUser(userFromGUI);
               break;
            } else {
                System.out.println("Podany login jest zajety. Sprobuj ponownie.");
                counter++;
            }
        }
    }

    public static void showUser() {
        System.out.println("Login: / Role:");
        for (User aUser : usersDataBase.getUser()) {
            if (aUser.isAvailable() != false) System.out.println(aUser);
        }
    }

    public static void changeUserRole(User user) {
        for (User aUser : usersDataBase.getUser())
            if (aUser.getLogin().equals(user.getLogin()) && aUser.isAvailable() == true) {
                aUser.setRole(user.getRole());
                System.out.println("Success!");
            }
    }

}
