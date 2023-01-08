package ua.com.alevel;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProducShooptInterface {

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
        System.out.println("2. If you would like to add a shoop name, please enter - 2");
        System.out.println("3. If you want find product, please enter id - 3");
        System.out.println("4. If you want find shoop, please enter id - 4");
        System.out.println("5. If You want to update a product, please enter - 5");
        System.out.println("6. If You want to update a shoop, please enter - 6");
        System.out.println("7. If You want to attach a product to the shoop, please enter - 7");
        System.out.println("8. If You want to delete product to shoop - 8");
        System.out.println("9. If you want delete product, please enter id - 9");
        System.out.println("10. If you want delete shoop, please enter id - 10");
        System.out.println("11. If you want find all product and product, please enter - 11");
        System.out.println("12. If you want find all product and shoop, please enter - 12");
        System.out.println("13. Press to exit the offer - 13");
        System.out.println();
    }

    private static void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1":
                createProduct(reader);
                break;
            case "2":
                createShoop(reader);
                break;
            case "3":
                findProduct(reader);
                break;
            case "4":
                findShoop(reader);
                break;
            case "5":
                updateProduct(reader);
                break;
            case "6":
                updateShoop(reader);
                break;
            case "7":
                attachShoopToProduct(reader);
                break;
            case "8":
                deleteProductToShoop(reader);
                break;
            case "9":
                deleteProduct(reader);
                break;
            case "10":
                deleteShoop(reader);
                break;
            case "11":
                findAllProduct();
                break;
            case "12":
                findAllShoop();
                break;
            case "13":
                exit();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + select);
        }
        menu();
    }

    private static void createProduct(BufferedReader reader) throws IOException {
        System.out.println("to add a new product.");
        System.out.println("Please enter product name.");
        String name = reader.readLine();
        System.out.println("Please enter product price.");
        String price = reader.readLine();
        System.out.println("Please enter country of origin.");
        String country = reader.readLine();
        Product product = new Product();
        product.setProductName(name);
        product.setPrice(price);
        product.setCountry(country);
        DbStorage.addProduct(product);
    }

    private static void createShoop(BufferedReader reader) throws IOException {
        System.out.println("Create shoop");
        System.out.println("Please enter name");
        String name = reader.readLine();
        System.out.println("Please enter country");
        String country = reader.readLine();
        Shoop shoop = new Shoop();
        shoop.setShoopName(name);
        shoop.setCountry(country);
        DbStorage.addShoop(shoop);
    }

    private static void findProduct(BufferedReader reader) throws IOException {
        System.out.println("Find product by id");
        String id = reader.readLine();
        Product product = DbStorage.getProduct(id);
        System.out.println("product = " + product);
    }

    private static void findShoop(BufferedReader reader) throws IOException {
        System.out.println("Find shoop by id");
        String id = reader.readLine();
        Shoop shoop = DbStorage.getShoop(id);
        System.out.println("shoop = " + shoop);
    }

    private static void updateProduct(BufferedReader reader) throws IOException {
        System.out.println("Let's update product's information. To start, please enter product's ID:");
        String productId = reader.readLine();
        Product product = DbStorage.getProduct(productId);
        if (product == null) {
            System.out.println("This product does not exist.");
        } else {
            System.out.println("Please enter product's new name:");
            String productName = reader.readLine();
            product.setProductName(productName);
            System.out.println("Please enter product's price:");
            String price = reader.readLine();
            product.setPrice(price);
            System.out.println("Please enter product's country:");
            String country = reader.readLine();
            product.setCountry(country);
            System.out.println("Thank you, the product's information is updated.");
        }
    }

    private static void updateShoop(BufferedReader reader) throws IOException {
        System.out.println("Let's update shoop's information. To start, please enter shoop's ID:");
        String shoopId = reader.readLine();
        Shoop shoop = DbStorage.getShoop(shoopId);
        if (shoop == null) {
            System.out.println("This shoop does not exist.");
        } else {
            System.out.println("Please enter shoop's name:");
            String shoopName = reader.readLine();
            shoop.setShoopName(shoopName);
            System.out.println("Please enter product's country:");
            String country = reader.readLine();
            shoop.setCountry(country);
            System.out.println("Thank you, the shoop's information is updated.");
        }
    }

    private static void attachShoopToProduct(BufferedReader reader) throws IOException {
        System.out.println("Let's attach the product to shoop. To start, please enter shoop's ID:");
        String productId = reader.readLine();
        System.out.println("Then please enter product's ID:");
        String shoopId = reader.readLine();
        if (productId == null || shoopId == null) {
            System.out.println("This ID does not exist.");
        } else {
            DbStorage.attach(productId, shoopId);
            System.out.println("Attachment is successful.");
        }


    }

    private static void deleteProductToShoop(BufferedReader reader) throws IOException {
        System.out.println("Delete product to shoop");
        System.out.println("Please enter shoop id");
        String shoopId = reader.readLine();
        System.out.println("Please enter product id");
        String productId = reader.readLine();
        DbStorage.deleteProductToShoop(productId, shoopId);
    }

    private static void deleteProduct(BufferedReader reader) throws IOException {
        System.out.println("Delete by product id");
        String id = reader.readLine();
        DbStorage.deleteProduct(id);
    }

    private static void deleteShoop(BufferedReader reader) throws IOException {
        System.out.println("Delete by shoop id");
        String id = reader.readLine();
        DbStorage.deleteShoop(id);
    }


    private static void findAllProduct() {
        System.out.println("Find all product");
        Product[] products = DbStorage.getProduct();
        System.out.println(Arrays.toString(products));
    }

    private static void findAllShoop() {
        System.out.println("Find all shoop");
        Shoop[] shoops = DbStorage.getShoop();
        System.out.println(Arrays.toString(shoops));

    }

    private static void exit() {
        System.exit(0);
    }
}
