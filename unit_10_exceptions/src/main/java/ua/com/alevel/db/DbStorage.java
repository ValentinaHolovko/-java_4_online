package ua.com.alevel.db;

import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DbStorage {

    private static final File SHOPS_FILE = new File("files/shops.csv");
    private static final File PRODUCTS_FILE = new File("files/products.csv");
    private static DbStorage instance;

    private DbStorage() {
    }

    public static DbStorage getInstance() {
        if (instance == null) {
            instance = new DbStorage();
        }
        try {
            createDir("files");
            createFile(SHOPS_FILE.getAbsolutePath());
            createFile(PRODUCTS_FILE.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    private static void createFile(String path) throws IOException {
        File file = new File(path).getAbsoluteFile();
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    private static void createDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public void addShop(Shop shop) {
        shop.setId(generateShopId());
        saveShops(shop);
    }

    public void addProduct(Product product) {
        product.setId(generateProductId());
        saveProducts(product);
    }

    public Optional<Shop> getShop(String shopId) {
        return readShops()
                .stream()
                .filter(shop -> shop.getId().equals(shopId))
                .findFirst();
    }


    public Optional<Product> getProduct(String productId) {
        return readProducts()
                .stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst();
    }

    private String generateProductId() {
        String productId = UUID.randomUUID().toString();
        if (readProducts().stream().anyMatch(product -> product.getId().equals(productId))) {
            return generateProductId();
        }
        return productId;
    }

    private String generateShopId() {
        String shopId = UUID.randomUUID().toString();
        if (readShops().stream().anyMatch(shop -> shop.getId().equals(shopId))) {
            return generateShopId();
        }
        return shopId;
    }

    public void deleteShop(String shopId) {
        List<Shop> shops = readShops();
        List<Product> products = readProducts();
        shops.stream().map(Shop::getShopIdList).forEach(shop -> shop.remove(shopId));
        shops.removeIf(shop -> shop.getId().equals(shopId));
        updateProductsCsv(products);
        updateShopsCsv(shops);

    }

    public void deleteProduct(String productId) {
        List<Product> products = readProducts();
        List<Shop> shops = readShops();
        products.stream().map(Product::getProductIdList).forEach(product -> product.remove(productId));
        products.removeIf(product -> product.getId().equals(productId));
        updateProductsCsv(products);
        updateShopsCsv(shops);
    }

    public void updateShop(String shopId, String shopName) {
        List<Shop> shops = readShops();
        for (int i = 0; i < shops.size(); i++) {
            Shop shop = shops.get(i);
            if (shop.getId().equals(shopId)) {
                shop.setShopName(shopName);
                break;
            }
        }
        updateShopsCsv(shops);
    }

    public void updateProduct(String productId, String productName) {
        List<Product> products = readProducts();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId().equals(productId)) {
                product.setProductName(productName);
                break;
            }
        }
        updateProductsCsv(products);
    }


    private List<Shop> readShops() {
        List<Shop> shops = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(String.valueOf(SHOPS_FILE)));
            for (String line : lines) {
                String[] values = line.split(",");
                if (values.length < 5) {
                    continue;
                }
                Shop shop = new Shop();
                shop.setShopName(values[1]);
                shop.setCountry(values[2]);
                shop.setShopIdList(new HashSet<>(Arrays.asList(values[3].split(";"))));
                shop.setId(values[4]);
                shops.add(shop);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shops;
    }


    private List<Product> readProducts() {
        List<Product> products = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(String.valueOf(PRODUCTS_FILE)));
            for (String line : lines) {
                String[] values = line.split(",");
                if (values.length < 5) {
                    continue;
                }
                Product product = new Product();
                product.setProductName(values[1]);
                product.setPrice(values[2]);
                product.setCountry(values[3]);
                product.setProductIdList(new HashSet<>(Arrays.asList(values[4].split(";"))));
                product.setId(values[5]);
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    private void updateShopsCsv(List<Shop> shops) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SHOPS_FILE))) {
            for (Shop shop : shops) {
                String line = String.format("%s,%s,%s",
                        shop.getCountry(),
                        shop.getShopName(),
                        shop.getShopIdList().stream()
                                .map(id -> id.replace(",", "\\,"))
                                .collect(Collectors.joining(";")),
                        shop.getId());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error updating shop in CSV file: " + e.getMessage());
        }
    }

    private void updateProductsCsv(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCTS_FILE))) {
            for (Product product : products) {
                String line = String.format("%s,%s,%s,%s",
                        product.getProductName(),
                        product.getPrice(),
                        product.getCountry(),
                        product.getProductIdList().stream()
                                .map(id -> id.replace(",", "\\,"))
                                .collect(Collectors.joining(";")),
                        product.getId());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {

        }
    }

    private void saveShops(Shop shop) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SHOPS_FILE, true))) {
            String line = String.format("%s,%s,%s",
                    shop.getCountry(),
                    shop.getShopName(),
                    shop.getShopIdList().stream().map(shopId -> shopId.replace(",", "\\,"))
                            .collect(Collectors.joining(";")),
                    shop.getId());
            writer.append(line).append("\n");
        } catch (IOException e) {
            System.err.println("Error saving shops to CSV file: " + e.getMessage());
        }
    }

    private void saveProducts(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCTS_FILE, true))) {
            String line = String.format("%s,%s,%s,%s",
                    product.getProductName(),
                    product.getPrice(),
                    product.getCountry(),
                    product.getProductIdList().stream().map(productId -> productId.replace(",", "\\,"))
                            .collect(Collectors.joining(";")),
                    product.getId());
            writer.append(line).append("\n");
        } catch (IOException e) {
            System.err.println("Error saving products to CSV file: " + e.getMessage());
        }
    }

    public List<Shop> findAllShops() {
        return readShops();
    }


    public List<Product> findAllProducts() {
        return readProducts();
    }

}
