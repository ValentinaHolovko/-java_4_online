package ua.com.alevel.dao;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Shop;
import ua.com.alevel.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductShopDao {
    void createShop(Shop shop);

    void createProduct(Product product);

    void updateShop(Shop shop);

    void updateProduct(Product product);

    void deleteShop(String id);

    void deleteProduct(String id);

    List<Shop> findAllShop();

    List<Product> findAllProduct();

    Optional<Shop> getShop(String id);

    Optional<Product> getProduct(String id);

}
