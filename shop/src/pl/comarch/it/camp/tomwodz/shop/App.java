package pl.comarch.it.camp.tomwodz.shop;

import org.apache.commons.codec.digest.DigestUtils;
import pl.comarch.it.camp.tomwodz.shop.core.Core;

public class App {
    public static void main(String[] args) {

    /*    String password = "TomekuxU9xUQWQMbZQm6rmtHd";
        String hash = DigestUtils.md5Hex(password);
        System.out.println(hash);*/

        System.out.println("Welcome in our GardenShop!");
        Core.start();
    }
}
