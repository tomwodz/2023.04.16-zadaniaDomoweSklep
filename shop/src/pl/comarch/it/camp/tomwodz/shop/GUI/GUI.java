package pl.comarch.it.camp.tomwodz.shop.GUI;


import pl.comarch.it.camp.tomwodz.shop.model.User;
import pl.comarch.it.camp.tomwodz.shop.product.Product;
import java.util.Scanner;
import java.util.EnumSet;

public  class GUI {

    static Scanner scanner = new Scanner(System.in);
    public static int showMenu(){
        for(Menu menu: EnumSet.range(Menu.HEADMENU1, Menu.HEADMENU4)){
            System.out.println(menu);}
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public static int showMenuUser(String userRole){
        if(userRole == "ADMIN") {
            for (Menu menu : EnumSet.range(Menu.USERMENU1, Menu.ADMINMENU2)) {
                System.out.println(menu);
            }}
        else if (userRole == "USER") {
                for (Menu menu : EnumSet.range(Menu.USERMENU1, Menu.USERMENU4)) {
                    System.out.println(menu);
                }
            }
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public static User readLoginAndPassword(){
        System.out.println("Please give your login: ");
        String login = scanner.nextLine().trim();
        System.out.println("Please give your password: ");
        return new User(login, scanner.nextLine().trim());
    }

    public static User readLogin(){
        System.out.println("Please give your login: ");
        return new User(scanner.nextLine().trim());
    }
    public static String savePassword(){
        System.out.println("Please give your password: ");
        return scanner.nextLine().trim();
    }

    public static String saveName(){
        System.out.println("Please give your name: ");
        return scanner.nextLine().trim();
    }

    public static String saveEmail(){
        System.out.println("Please give your e-mail: ");
        return scanner.nextLine().trim();
    }

    public static Product buyProduct(){
        Product product = new Product();
        System.out.println("Podaj kod produktu, ktory chcesz kupic:");
        product.setCode(Integer.parseInt(scanner.nextLine()));
        System.out.println("Podaj ilosc produktu, ktora chcesz kupic:");
        product.setQuantity(Integer.parseInt(scanner.nextLine()));
        return product;
    }

    public static Product exchangeProduct(){
        Product product = new Product();
        System.out.println("Podaj kod produktu, ktory chcesz zmienic:");
        product.setCode(Integer.parseInt(scanner.nextLine()));
        System.out.println("Podaj ilosc produktu, ktora chcesz zmienc:");
        product.setQuantity(Integer.parseInt(scanner.nextLine()));
        return product;
    }

    public static User readLoginChangeUser(){
        User user = new User();
        System.out.println("Please give login user for change: ");
        user.setLogin(scanner.nextLine());
        System.out.println("Please give new role: ");
        user.setRole(scanner.nextLine());
        return user;
    }

}
