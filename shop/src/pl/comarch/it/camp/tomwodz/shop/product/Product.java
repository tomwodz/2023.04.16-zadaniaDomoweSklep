package pl.comarch.it.camp.tomwodz.shop.product;

public class Product {

    private int code;
    private String name;
    private String category;
    private double pricePerItem;
    private int quantity;

    public Product(int code, String name, String category, double pricePerItem, int quantity) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.pricePerItem = pricePerItem;
        this.quantity = quantity;
    }

    public Product(int code, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Product() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Kod: ")
                .append(getCode())
                .append(" Kat.: ")
                .append(getCategory())
                .append(" Nazwa: ")
                .append(getName())
                .append(" Cena PLN/szt: ")
                .append(getPricePerItem())
                .append(" Ilosc: ")
                .append(getQuantity())
                .toString();
    }
}
