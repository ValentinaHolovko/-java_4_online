package ua.com.alevel.dao;

import ua.com.alevel.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopDao {

    void create(Shop shop);

    void update(Shop shop);

    void delete(String id);

    Optional<Shop> findById(String id);

    List<Shop> findAll();

    void attach(String customerId, String shopId);
}