package ua.com.alevel.dao;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Shop;

import java.util.List;
import java.util.Optional;

public class ShopDaoImpl implements ShopDao {

    DbStorage dbStorage = DbStorage.getInstance();

    @Override
    public void create(Shop shop) {
        dbStorage.addShop(shop);
    }

    @Override
    public void update(Shop shop) {
        dbStorage.updateShop(shop);
    }

    @Override
    public void delete(String id) {
        dbStorage.deleteShop(id);
        dbStorage.deleteShopFromCustomerList(id);
    }

    @Override
    public Optional<Shop> findById(String id) {
        return dbStorage.getShop(id);
    }

    @Override
    public List<Shop> findAll() {
        return dbStorage.findAllShops();
    }

    @Override
    public void attachCustomer(String customerId, String shopId) {
        dbStorage.attach(customerId, shopId);
    }

    @Override
    public void attachShop(String customerId, String shopId) {
        dbStorage.attach(customerId, shopId);
    }
}