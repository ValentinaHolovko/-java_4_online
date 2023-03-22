package ua.com.alevel.controller;

import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shop;
import ua.com.alevel.service.ProductShopService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class ProductShopController {

    private final ProductShopService productShopService = new ProductShopService();

    public ProductShopController() throws IOException { // а зачем этот конструктор?
    }

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your options");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            crud(reader, select);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("1. If you want to add a product, enter- 1");
        System.out.println("2. If you want to add a shop, enter - 2");
        System.out.println("3. If you want find product, please enter id - 3");
        System.out.println("4. If you want find shop, please enter id - 4");
        System.out.println("5. If You want to update a product, please enter - 5");
        System.out.println("6. If You want to update a shop, please enter - 6");
        System.out.println("7. If you want delete product, please enter id - 7");
        System.out.println("8. If you want delete shop, please enter id - 8");
        System.out.println("9. If you want find all product and product, please enter - 9");
        System.out.println("10. If you want find all product and shop, please enter - 10");
        System.out.println("11. Press to exit the offer - 11");
        System.out.println();
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) { // лучше уже используй фишки 17 java
            case "1" -> createProduct(reader);
            case "2" -> createShop(reader);
            case "3" -> findProductById(reader);
            case "4" -> findShopById(reader);
            case "5" -> updateProduct(reader);
            case "6" -> updateShop(reader);
            case "7" -> deleteProduct(reader);
            case "8" -> deleteShop(reader);
            case "9" -> findAllProducts();
            case "10" -> findAllShops();
            case "11" -> exit();
        }
        menu();
    }

    private void createProduct(BufferedReader reader) throws IOException {
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
        productShopService.addProduct(product);
    }

    private void createShop(BufferedReader reader) throws IOException {
        System.out.println("Create shop");
        System.out.println("Please enter name");
        String name = reader.readLine();
        System.out.println("Please enter country");
        String country = reader.readLine();
        Shop shop = new Shop();
        shop.setShopName(name);
        shop.setCountry(country);
        productShopService.addShop(shop);
    }

    private void findProductById(BufferedReader reader) throws IOException {
        System.out.println("Find employee by id");
        System.out.println("Please enter id");
        String productId = reader.readLine();
        if (productId.equals("")) {
            System.out.println("You do not enter employee id");
            return;
        }
        Product product = productShopService.findProductById(productId);
        System.out.println("product = " + product);
    }

    private void findShopById(BufferedReader reader) throws IOException {
        System.out.println("Find employee by id");
        System.out.println("Please enter id");
        String shopId = reader.readLine();
        if (shopId.equals("")) {
            System.out.println("You do not enter employee id");
            return;
        }
        Shop shop = productShopService.findShopById(shopId);
        System.out.println("shop = " + shop);
    }

    private void updateProduct(BufferedReader reader) throws IOException {
        System.out.println("Update information about a project");
        System.out.println("Please enter project id");
        String productId = reader.readLine();
        Product product = productShopService.findProductById(productId);
        if (product == null) {
            System.out.println("Project id does not exist\n");
        } else {
            System.out.println("Please enter new project's name");
            String productName = reader.readLine();
            product.setProductName(productName);
            System.out.println("Please enter a new project manager name");
            String price = reader.readLine();
            product.setPrice(price);
            String country = reader.readLine();
            product.setCountry(country);
            System.out.println("Please enter a new project location");

            productShopService.updateProduct(product);
        }

    }


    private void updateShop(BufferedReader reader) throws IOException {
        System.out.println("Update information about a project");
        System.out.println("Please enter project id");
        String shopId = reader.readLine();
        Shop shop = productShopService.findShopById(shopId);
        if (shop == null) {
            System.out.println("Project id does not exist\n");
        } else {
            System.out.println("Please enter new project's name");
            String ShopName = reader.readLine();
            shop.setShopName(ShopName);
            System.out.println("Please enter a new project manager name");
            String country = reader.readLine();
            shop.setCountry(country);
            System.out.println("Please enter a new project location");
            String shopIdList = reader.readLine();
            shop.setShopIdList(Collections.singleton(shopIdList));
            productShopService.updateShop(shop);
        }
    }


    private void deleteProduct(BufferedReader reader) throws IOException {
        System.out.println("Delete by product id");
        String productId = reader.readLine();
        if (productShopService.getProduct(productId).isPresent()) {
            productShopService.deleteProduct(productId);
        } else {
            System.out.println("This id does not exist");
        }
    }

    private void deleteShop(BufferedReader reader) throws IOException {
        System.out.println("Delete by shop id");
        String shopId = reader.readLine();
        if (productShopService.getShop(shopId).isPresent()) {
            productShopService.deleteShop(shopId);
        } else {
            System.out.println("This id does not exist");
        }
    }


    private void findAllProducts() {
        System.out.println("Find all product");
        List<Product> products = productShopService.findAllProducts();
        if (products.isEmpty()) {
            System.out.println("There are nothing to find!");
        } else {
            products.forEach(System.out::println);
        }
    }

    private void findAllShops() {
        System.out.println("Find all shop");
        List<Shop> shops = productShopService.findAllShops();
        if (shops.isEmpty()) {
            System.out.println("There are nothing to find!");
        } else {
            shops.forEach(System.out::println);
        }
    }

    private void exit() {
        System.exit(0);
    }
}
