package pl.comarch.it.camp.tomwodz.shop.core;
import pl.comarch.it.camp.tomwodz.shop.GUI.GUI;
import pl.comarch.it.camp.tomwodz.shop.db.FileLoader;
import pl.comarch.it.camp.tomwodz.shop.db.ProductRepository;

import java.io.IOException;

public class Core {
    private static final Core instance = new Core();
    private Core() {}
    private final FileLoader fileLoader = FileLoader.getInstance();
    private final Authenticator authenticator = Authenticator.getInstance();
    private final ProductRepository productsDataBase = ProductRepository.getInstance();
    private final GUI gui = GUI.getInstance();


    public void start() {
       try {
            fileLoader.readDataFromFile();
        } catch (IOException e) {
            System.out.println("Database is malformed !!");
            return;
        }

        while (true) {
            switch (gui.showMenu()) {
                case 1:
                    boolean runMenuUser = true;
                    String userRole = authenticator.authenticate();
                    if(userRole.equals("ADMIN")  || userRole.equals("USER")) {
                        while (runMenuUser) {
                            switch (gui.showMenuUser(userRole)) {
                                case 1:
                                    productsDataBase.showProduct(userRole);
                                    break;
                                case 2:
                                    System.out.println(productsDataBase.buyProducts(gui.buyProduct()));
                                    break;
                                case 3:
                                    runMenuUser = false;
                                    System.out.println("Correct logout!");
                                    break;
                                case 4:
                                    if (userRole.equals("ADMIN")) {
                                        productsDataBase.exchangeProducts(gui.exchangeProduct());
                                    }
                                    break;
                                case 5:
                                    if (userRole.equals("ADMIN")) {
                                        authenticator.showUser();
                                        authenticator.changeUserRole(gui.readLoginChangeUser());
                                    }
                                    break;
                                default:
                            }
                        }
                    }
                    break;
                case 2:
                    authenticator.registration();
                    break;
                case 3:
                    System.out.println("Waiting...");
                    try {
                     fileLoader.saveDataToFile();
                    }
                    catch(IOException e){
                        System.out.println("Error database!! Please contact with admin");
                    }
                    System.out.println("Thank you for using our GardenShop! See you later!");
                    return;
                default:
            }
        }
    }

    public static Core getInstance() {
        return instance;
    }
}