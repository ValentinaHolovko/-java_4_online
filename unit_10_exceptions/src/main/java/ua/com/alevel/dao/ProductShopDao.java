package ua.com.alevel.dao;

import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface ProductShopDao {

    void addShop(Shop shop);
    void addProduct(Product product);
    void deleteShop(String shopId);
    void deleteProduct(String productId);
    List<Shop> findAllShops();
    List<Product> findAllProducts();
    Optional<Shop> getShop(String shopId);
    Optional<Product> getProduct(String productId);
    void updateShop(String shopId, String shopName);
    void updateProduct(String productId, String productName);
    void findShopById(String shopId);
    void findProductById(String productId);
}
