package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShoopProduct {
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("which product are you interested in?");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            crud(reader, select);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want to add a product name enter 1");
        System.out.println("If you want to search product enter 2");
        System.out.println("If you want delete product, please enter 3");
        System.out.println("If you want find all product , please enter 4");
        System.out.println("If you want close application, please enter 5");
        System.out.println();
    }

    private void crud(BufferedReader reader, String choice) throws IOException {
        switch (choice) {
            case "1" : create(reader);
            case "2" : productID(reader);
            case "3" : deleteProductName(reader);
            case "4" : findAll(); break;
            case "5" : stop(); break;
        }
        menu();
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Create user");
        System.out.println("Please enter product name");

        System.out.println("Please enter product ID");

        System.out.println("Please enter unit Price");

        System.out.println("Please enter ideal Stock");

        Shoop productName = new Shoop();
        ShoopStorege.addProductName(productName);
    }

    private void productID(BufferedReader reader) throws IOException {
        System.out.println("Find product by ID");
        String productID = reader.readLine();
        System.out.println("productName = " + productID);
    }

    private void deleteProductName(BufferedReader reader) throws IOException {
        System.out.println("Delete user by email");
        String email = reader.readLine();
        ShoopStorege.deleteProductName("name");
    }

    private void findAll() {
        System.out.println("Find all product");
        System.out.println("productNames = " + toString());
    }

    private void stop() {
        System.exit(0);
    }
}

