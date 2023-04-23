package pl.comarch.it.camp.tomwodz.shop.db;

import pl.comarch.it.camp.tomwodz.shop.model.User;

import java.util.UUID;

public class UserRepository {

    private User[] users = new User[10];

    public UserRepository() {
        this.users[0] = new User("admin", "76a0219bf06f2ebcb96a0334b4814e8c", "ADMIN", "Tomek", "twodzinski@op.pl", true);
        this.users[1] = new User("Tomek", "76a0219bf06f2ebcb96a0334b4814e8c", "USER", "Tomek", "twodzinski@op.pl", true);
        for(int i = 2; i <10; i ++){
            this.users[i] = new User( "", "", "USER", "", "", false);
        }
    }

    public User[] getUser() {
        return users;
    }

    public User findUserByLogin(String login) {
        for(User user : this.users){
            if(login.equals(user.getLogin())){
                return user;
            }
        }
        return null;
    }

    public void createNewUser(User user) {
        for(User aUser : this.users)
            if (aUser.isAvailable() == false) {
                aUser.setAvailable(true);
                aUser.setLogin(user.getLogin());
                aUser.setPassword(user.getPassword());
                aUser.setName(user.getName());
                aUser.setEmial(user.getEmial());
                System.out.println("Success. Uzytkownik zostal utworzony.");
                break;
            }
    }


}
