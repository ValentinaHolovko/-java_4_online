package ua.com.alevel.dao;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Сustomer;

import java.util.List;
import java.util.Optional;

public class СustomerDaoImpl implements СustomerDao {

    DbStorage dbStorage = DbStorage.getInstance();

    @Override
    public String create(Сustomer сustomer) {
        return dbStorage.addСustomer(сustomer);
    }

    @Override
    public void update(Сustomer сustomer) {
        dbStorage.updateCustomer(сustomer);
    }

    @Override
    public void delete(String id) {
        dbStorage.deleteCustomer(id);
        dbStorage.deleteCustomerFromShopList(id);
    }

    @Override
    public Optional<Сustomer> findById(String id) {
        return dbStorage.getCustomer(id);
    }

    @Override
    public List<Сustomer> findAll() {
        return dbStorage.findAllCustomers();
    }

    @Override
    public void attach(String customerId, String shopId) {
        dbStorage.attach(customerId, shopId);
    }
}
