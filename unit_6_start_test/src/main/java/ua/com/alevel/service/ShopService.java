package ua.com.alevel.service;

import ua.com.alevel.dao.ShopDaoImpl;
import ua.com.alevel.entity.Shop;

import java.util.List;
import java.util.Optional;

public class ShopService {

    private ShopDaoImpl shopDao = new ShopDaoImpl();

    public void create(Shop shop) {
        shopDao.create(shop);
    }

    public void update(Shop shop) {
        shopDao.update(shop);
    }

    public void delete(String id) {
        shopDao.delete(id);
    }

    public Shop findShopById(String id) {
        Optional<Shop> shop = shopDao.findById(id);
        return shop.orElse(null);
    }

    public List<Shop> findAllShop() {
        return shopDao.findAll();
    }

}