package pl.comarch.it.camp.tomwodz.shop.db;

import pl.comarch.it.camp.tomwodz.shop.model.User;
import pl.comarch.it.camp.tomwodz.shop.product.Product;
import pl.comarch.it.camp.tomwodz.shop.product.Tools;
import pl.comarch.it.camp.tomwodz.shop.product.Writable;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FileLoader {

    private static final FileLoader instance = new FileLoader();
    public FileLoader() {}

    public void readDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("db.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] objectData = line.split(";");
            String[] vars = Arrays.copyOfRange(objectData, 1, objectData.length);
            switch (objectData[0]) {
                case "Product":
                    ProductRepository.getInstance().addProduct(new Product(vars));
                    break;
                case "Tools":
                    ProductRepository.getInstance().addProduct(new Tools(vars));
                    break;
                case "User":
                    UserRepository.getInstance().addUser(new User(vars));
                    break;
                default:
                    System.out.println("Unexpected type during DB loading !!");
                    break;
            }
        }
        reader.close();
    }

    public void saveDataToFile() throws IOException {
        Collection<Writable> entries = new ArrayList<>();
        entries.addAll(ProductRepository.getInstance().getProducts());
        entries.addAll(UserRepository.getInstance().getUser());
            BufferedWriter writer = new BufferedWriter(new FileWriter("db.csv"));
            boolean firstTime = true;
            for (Writable entry : entries) {
                String lineInFile = entry.toCSV();
                if (!firstTime) {
                    writer.newLine();
                }
                firstTime = false;
                writer.write(lineInFile);
            }
            writer.close();
    }

    public static FileLoader getInstance() {
        return instance;
    }
}
