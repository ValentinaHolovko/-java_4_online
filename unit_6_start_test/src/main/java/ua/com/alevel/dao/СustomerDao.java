package ua.com.alevel.dao;

import ua.com.alevel.entity.Сustomer;

import java.util.List;
import java.util.Optional;

public interface СustomerDao {

    String create(Сustomer сustomer);

    void update(Сustomer сustomer);

    void delete(String id);

    Optional<Сustomer> findById(String id);

    List<Сustomer> findAll();

    void attach(String customerId, String shopId);
}