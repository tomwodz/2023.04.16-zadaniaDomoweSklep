package pl.comarch.it.camp.tomwodz.shop.core;
import pl.comarch.it.camp.tomwodz.shop.GUI.GUI;
import pl.comarch.it.camp.tomwodz.shop.db.ProductRepository;

public class Core {

    public static void start() {

        ProductRepository productsDatabase = new ProductRepository();

        while (true) {
            switch (GUI.showMenu()) {
                case 1:
                    boolean runMenuUser = true;
                    String userRole = Authenticator.authenticate();
                    if(userRole == "ADMIN" || userRole == "USER") {
                        while (runMenuUser) {
                            switch (GUI.showMenuUser(userRole)) {
                                case 1:
                                    productsDatabase.showProduct(userRole);
                                    break;
                                case 2:
                                    System.out.println(productsDatabase.buyProducts(GUI.buyProduct()));
                                    break;
                                case 3:
                                    runMenuUser = false;
                                    System.out.println("Correct logout!");
                                    break;
                                case 4:
                                    if (userRole == "ADMIN") {
                                        productsDatabase.exchangeProducts(GUI.exchangeProduct());
                                    }
                                    break;
                                case 5:
                                    if (userRole == "ADMIN") {
                                        Authenticator.showUser();
                                        Authenticator.changeUserRole(GUI.readLoginChangeUser());
                                    }
                                    break;
                                default:
                            }
                        }
                    }
                    break;
                case 2:
                    Authenticator.registration();
                    break;
                case 3:
                    System.out.println("Thank you for using our GardenShop! See you later!");
                    return;
                default:
            }
        }
    }
}