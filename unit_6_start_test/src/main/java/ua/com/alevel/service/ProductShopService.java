package ua.com.alevel.service;

import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shop;
import ua.com.alevel.dao.ProductShopDao1;
import ua.com.alevel.dao.ProductShopDao;

import java.util.List;
import java.util.Optional;

public class ProductShopService {

    private ProductShopDao productShopDao = new ProductShopDao1();

    public void createShop(Shop shop) {
        productShopDao.createShop(shop);
    }

    public void createProduct(Product product) {
        productShopDao.createProduct(product);
    }

    public List<Shop> findAllShop() {
        return productShopDao.findAllShop();
    }

    public List<Product> findAllProduct() {
        return productShopDao.findAllProduct();
    }

    public Optional<Shop> getShop(String id) {
        return productShopDao.getShop(id);
    }

    public Optional<Product> getProduct(String id) {
        return productShopDao.getProduct(id);
    }

    public void deleteShop(String id) {
        productShopDao.deleteShop(id);
    }

    public void deleteProduct(String id) {
        productShopDao.deleteProduct(id);
    }

    public void updateShop(Shop shop) {
        productShopDao.updateShop(shop);
    }

    public void updateProduct(Product product) {
        productShopDao.updateProduct(product);
    }
}
