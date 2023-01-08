package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProductInterface {

    public static void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your options");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            crud(reader, select);
        }
    }

    private static void menu() {
        System.out.println();
        System.out.println("1. If you would like to add a product name, please enter - 1");
        System.out.println("2. If you want find product, please enter name - 2");
        System.out.println("3. If you want delete product, please enter name - 3");
        System.out.println("4. If you want find all product, please enter - 4 ");
        System.out.println("5. If you want close application, please enter -5");
        System.out.println();
    }

    private static void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1":
                create(reader);
                break;
            case "2":
                findProductName(reader);
                break;
            case "3":
                deleteName(reader);
                break;
            case "4":
                findAll();
                break;
            case "5":
                exit();
                break;
        }
        menu();
    }

    private static void create(BufferedReader reader) throws IOException {
        System.out.println("to add a new product.");
        System.out.println("Please enter product id.");
        String id = reader.readLine();
        System.out.println("Please enter product name.");
        String name = reader.readLine();
        System.out.println("Please enter product price.");
        String price = reader.readLine();
        System.out.println("Please enter country of origin.");
        String country = reader.readLine();
        Product product = new Product();
        product.setId(id);
        product.setProductName(name);
        product.setPrice(price);
        product.setCountry(country);
        ProductStorage.addProduct(product);
    }

    private static void findProductName(BufferedReader reader) throws IOException {
        System.out.println("Find product by name");
        String name = reader.readLine();
        Product product = ProductStorage.getProduct(name);
        System.out.println("product = " + product);

    }

    private static void deleteName(BufferedReader reader) throws IOException {
        System.out.println("Delete by product name");
        String name = reader.readLine();
        ProductStorage.deleteProduct(name);
    }

    private static void findAll() {
        System.out.println("Find all product");
        Product[] products = ProductStorage.getProduct();
        System.out.println("products = " + Arrays.toString(products));
    }

    private static void exit() {
        System.exit(0);

    }
}
