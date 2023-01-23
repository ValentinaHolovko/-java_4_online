package ua.com.alevel.db;

import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shop;

import java.util.UUID;

import java.util.*;

public class DbStorage {

    private List<Product> products = new ArrayList<>();
    private List<Shop> shops = new ArrayList<>();
    private static DbStorage instance;

    private DbStorage() {
    }

    public static DbStorage getInstance() {
        if (instance == null) {
            instance = new DbStorage();
        }
        return instance;
    }


    public String addShop(Shop shop) {
        String id = generateShopId();
        shop.setId(id);
        shops.add(shop);
        return id;
    }

    public String addProduct(Product product) {
        String id = generateProductId();
        product.setId(id);
        products.add(product);
        return id;
    }

    public List<Shop> findAllShop() {
        return new ArrayList<>(shops);
    }


    public List<Product> findAllProduct() {
        return new ArrayList<>(products);
    }


    public Optional<Shop> getShop(String id) {
        return shops
                .stream()
                .filter(shop -> shop.getId().equals(id))
                .findFirst();
    }


    public Optional<Product> getProduct(String id) {
        return products
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    private String generateProductId() {
        String id = UUID.randomUUID().toString();
        if (products.stream().anyMatch(product -> product.getId().equals(id))) {
            return generateProductId();
        }
        return id;
    }

    private String generateShopId() {
        String id = UUID.randomUUID().toString();
        if (shops.stream().anyMatch(shop -> shop.getId().equals(id))) {
            return generateShopId();
        }
        return id;
    }

    public void deleteShop(String id) {
        shops.stream().map(Shop::getShopIdList).forEach(shop -> shop.remove(id));
        shops.removeIf(shop -> shop.getId().equals(id));
    }


    public void deleteProduct(String id) {
        products.stream().map(Product::getProductIdList).forEach(product -> product.remove(id));
        products.removeIf(product -> product.getId().equals(id));
    }


    public void updateShop(Shop shop) {
        shops.remove(shop);
        shops.add(shop);
    }


    public void updateProduct(Product product) {
        products.remove(product);
        products.add(product);
    }


}

