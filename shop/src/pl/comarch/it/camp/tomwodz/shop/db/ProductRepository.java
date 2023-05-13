package pl.comarch.it.camp.tomwodz.shop.db;

import pl.comarch.it.camp.tomwodz.shop.model.User;
import pl.comarch.it.camp.tomwodz.shop.product.*;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

   private Map<String, Product> products = new HashMap<>();

   public static final ProductRepository instance = new ProductRepository();

    private ProductRepository() {
    }

    public Collection<Product> getProducts() {
        return this.products.values();
    }

    public  String buyProducts(Product product) {
        Product aProduct = this.products.get(product.getCode());
            if (aProduct.getCode().equals(product.getCode())){
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
        return "Podano zly kod produktu";
    }

    public void exchangeProducts(Product product) {
        Product aProduct = this.products.get(product.getCode());
        aProduct.setQuantity(product.getQuantity());
    }

    public void showProduct(String userRole) {
        for (Product product : this.products.values()) {
            if (userRole.equals("ADMIN")) {
                    System.out.println(product);
            } else {
                if (product.getQuantity() != 0) {
                    System.out.println(product);
                }
            }
        }
    }

    public void addProduct(Product product) {
        this.products.put(product.getCode(), product);
    }

    public static ProductRepository getInstance(){
        return instance;
    }

}
