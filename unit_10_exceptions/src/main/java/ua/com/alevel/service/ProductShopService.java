package ua.com.alevel.service;

import ua.com.alevel.dao.ProductShopDao;
import ua.com.alevel.dao.ProductShopDao1;
import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shop;

import java.util.List;
import java.util.Optional;

public class ProductShopService {

    private final ProductShopDao productShopDao = new ProductShopDao1();

    public void updateShop(String shopId, String shopName) {
        productShopDao.updateShop(shopId, shopName); // а что этот метод делает?, если ты его не используешь?
    }

    public void updateProduct(String productId, String productName) {
        productShopDao.updateProduct(productId, productName); // а что этот метод делает?, если ты его не используешь?
    }

    public void addShop(Shop shop) {
        productShopDao.addShop(shop);
    }

    public void addProduct(Product product) {
        productShopDao.addProduct(product);
    }

    public List<Shop> findAllShops() {
        return productShopDao.findAllShops();
    }

    public List<Product> findAllProducts() {
        return productShopDao.findAllProducts();
    }

    public Optional<Shop> getShop(String id) {
        return productShopDao.getShop(id);
    }

    public Optional<Product> getProduct(String id) {
        return productShopDao.getProduct(id);
    }

    public void deleteShop(String shopId) {
        productShopDao.deleteShop(shopId);
    }

    public void deleteProduct(String productId) {
        productShopDao.deleteProduct(productId);
    }

    public void updateProduct(Product product) { // а что этот метод делает?
    }

    public void updateShop(Shop shop) { // а что этот метод делает?
    }

    public Shop findShopById(String shopId) {
        productShopDao.findShopById(shopId);
        return null; // return null ???)))
    }

    public Product findProductById(String productId) {
        productShopDao.findProductById(productId);
        return null; // return null ???)))
    }
}