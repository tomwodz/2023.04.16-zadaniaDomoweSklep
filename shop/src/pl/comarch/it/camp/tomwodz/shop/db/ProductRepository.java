package pl.comarch.it.camp.tomwodz.shop.db;

import pl.comarch.it.camp.tomwodz.shop.product.*;

import java.text.NumberFormat;

public class ProductRepository {

   private Product[] products = new Product[4];

    public ProductRepository() {
        this.products[0] = new Product(4000, "Magnolia 60 cm", "Tree", 60, 10);
        this.products[1] = new Product(5000, "Tamryszek 80 cm", "Krzew", 13, 0);
        this.products[2] = new Product(6000, "Tulipan celuka", "Kwiat", 1, 1000);
        this.products[3] = new Tools(7000, "Kosiarka 43 cm", "Narzedzia", 1000, 10, "Makkita");
    }

    public  Product[] getProducts() {
        return products;
    }

    public  String buyProducts(Product product) {
        for (Product aProduct : products) {
            if (aProduct.getCode() == product.getCode()) {
                if (product.getQuantity() <= aProduct.getQuantity()) {
                    aProduct.setQuantity(aProduct.getQuantity() - product.getQuantity());
                    System.out.println("Łaczna cena wynosi:");
                    return NumberFormat.getCurrencyInstance().format(product.getQuantity() * aProduct.getPricePerItem());
                } else {
                    return new StringBuilder().append("Podales za duza ilosc produktu.")
                            .append(" Maksymana dostepna ilość to: ")
                            .append(aProduct.getQuantity())
                            .append(" dla ")
                            .append(aProduct.getCode())
                            .append(" ")
                            .append(aProduct.getName())
                            .toString();
                }
            }
        }
        return "Podano zly kod produktu";
    }

    public void exchangeProducts(Product product) {
        for (Product aProduct : products) {
            if (aProduct.getCode() == product.getCode()) {
                aProduct.setQuantity(aProduct.getQuantity() + Math.abs(product.getQuantity()));
            }
        }
    }

    public void showProduct(String userRole) {
        for (Product product : products) {
            if (userRole == "ADMIN") {
                System.out.println(product);
            } else {
                if (product.getQuantity() != 0) {
                    System.out.println(product);
                }
            }
        }
    }

}
