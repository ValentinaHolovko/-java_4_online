package ua.com.alevel.controller;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shop;
import ua.com.alevel.service.ProductShopService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

public class ProductShopController {

    private ProductShopService productShopService = new ProductShopService();

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
        switch (select) {
            case "1":
                createProduct(reader);
                break;
            case "2":
                createShop(reader);
                break;
            case "3":
                findProduct(reader);
                break;
            case "4":
                findShop(reader);
                break;
            case "5":
                updateProduct(reader);
                break;
            case "6":
                updateShop(reader);
                break;
            case "7":
                deleteProduct(reader);
                break;
            case "8":
                deleteShop(reader);
                break;
            case "9":
                findAllProduct();
                break;
            case "10":
                findAllShop();
                break;
            case "11":
                exit();
                break;
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
        productShopService.createProduct(product);
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
        productShopService.createShop(shop);
    }

    private void findProduct(BufferedReader reader) throws IOException {
        System.out.println("You want to find product");
        System.out.println("Please enter product Id");
        String productId = reader.readLine();
        Optional<Product> product = productShopService.getProduct(productId);
        if (product == null) {
            System.out.println("Wrong ID");
        } else {
            System.out.println(product);
        }

    }

    private void findShop(BufferedReader reader) throws IOException {
        System.out.println("You want to find shop");
        System.out.println("Please enter shop Id");
        String shopId = reader.readLine();
        Optional<Shop> shop = productShopService.getShop(shopId);
        if (shop == null) {
            System.out.println("Wrong ID");
        } else {
            System.out.println(shop);
        }

    }

    private void updateProduct(BufferedReader reader) throws IOException {
        System.out.println("Let's update product's information. To start, please enter product's ID:");
        String productId = reader.readLine();
        Optional<Product> product1 = DbStorage.getInstance().getProduct(productId);
        if (product1.isEmpty()) {
            System.out.println("This product does not exist.");
        } else {
            Product product = product1.get();
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

    private void updateShop(BufferedReader reader) throws IOException {
        System.out.println("Let's update shop's information. To start, please enter shop's ID:");
        String shopId = reader.readLine();
        Optional<Shop> shop1 = DbStorage.getInstance().getShop(shopId);
        if (shop1.isEmpty()) {
            System.out.println("This shop does not exist.");
        } else {
            Shop shop = shop1.get();
            System.out.println("Please enter shop's name:");
            String shopName = reader.readLine();
            shop.setShopName(shopName);
            System.out.println("Please enter product's country:");
            String country = reader.readLine();
            shop.setCountry(country);
            System.out.println("Thank you, the shop's information is updated.");
        }
    }

    private void deleteProduct(BufferedReader reader) throws IOException {
        System.out.println("Delete by product id");
        String Id = reader.readLine();
        productShopService.deleteProduct(Id);
    }

    private void deleteShop(BufferedReader reader) throws IOException {
        System.out.println("Delete by shop id");
        String Id = reader.readLine();
        productShopService.deleteShop(Id);
    }


    private void findAllProduct() {
        System.out.println("Find all product");
        List<Product> products = productShopService.findAllProduct();
        System.out.println("products " + products);
    }

    private void findAllShop() {
        System.out.println("Find all shop");
        List<Shop> shops = productShopService.findAllShop();
        System.out.println("shops " + shops);

    }

    private void exit() {
        System.exit(0);
    }
}
