package ua.com.alevel.dao;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shop;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class ProductShopDao1 implements ProductShopDao {

    private static final File SHOPS_FILE = new File("files/shops.csv");
    private static final File PRODUCTS_FILE = new File("files/products.csv");

    DbStorage dbStorage = DbStorage.getInstance();

    public ProductShopDao1() {
        load();
    }

    @Override
    public void addShop(Shop shop) {
        dbStorage.addShop(shop);
        save();
    }

    @Override
    public void addProduct(Product product) {
        dbStorage.addProduct(product);
        save();
    }

    @Override
    public void deleteShop(String shopId) {
        dbStorage.deleteShop(shopId);
        save();
    }

    @Override
    public void deleteProduct(String productId) {
        dbStorage.deleteProduct(productId);
        save();
    }

    @Override
    public List<Shop> findAllShops() {
        return dbStorage.findAllShops();
    }

    @Override
    public List<Product> findAllProducts() {
        return dbStorage.findAllProducts();
    }

    @Override
    public Optional<Shop> getShop(String shopId) {
        return dbStorage.getShop(shopId);
    }

    @Override
    public Optional<Product> getProduct(String shopId) {
        return dbStorage.getProduct(shopId);
    }

    @Override
    public void updateShop(String shopId, String shopName) {
        dbStorage.updateShop(shopId, shopName);
        save();
    }

    @Override
    public void updateProduct(String productId, String productName) {
        dbStorage.updateProduct(productId, productName);
        save();
    }

    @Override
    public void findShopById(String shopId) {

    }

    @Override
    public void findProductById(String productId) {

    }

    private void save() {
        //...
    }

    private void load() {
        //...
    }
}
