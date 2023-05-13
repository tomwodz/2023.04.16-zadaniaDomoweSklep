package pl.comarch.it.camp.tomwodz.shop;

import org.apache.commons.codec.digest.DigestUtils;
import pl.comarch.it.camp.tomwodz.shop.core.Core;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome in our GardenShop!");
        Core.getInstance().start();
    }
}
