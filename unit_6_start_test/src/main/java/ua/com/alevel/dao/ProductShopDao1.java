package ua.com.alevel.dao;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Shop;
import ua.com.alevel.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductShopDao1 implements ProductShopDao {
    DbStorage dbStorage = DbStorage.getInstance();

    @Override
    public void createShop(Shop shop) {
        dbStorage.addShop(shop);

    }

    @Override
    public void createProduct(Product product) {
        dbStorage.addProduct(product);

    }

    @Override
    public void updateShop(Shop shop) {
        dbStorage.updateShop(shop);
    }

    @Override
    public void updateProduct(Product product) {
        dbStorage.updateProduct(product);

    }

    @Override
    public void deleteShop(String id) {
        dbStorage.deleteShop(id);

    }

    @Override
    public void deleteProduct(String id) {
        dbStorage.deleteProduct(id);
    }

    @Override
    public List<Shop> findAllShop() {
        return dbStorage.findAllShop();
    }

    @Override
    public List<Product> findAllProduct() {
        return dbStorage.findAllProduct();
    }

    @Override
    public Optional<Shop> getShop(String id) {
        return dbStorage.getShop(id);
    }

    @Override
    public Optional<Product> getProduct(String id) {
        return dbStorage.getProduct(id);
    }
}