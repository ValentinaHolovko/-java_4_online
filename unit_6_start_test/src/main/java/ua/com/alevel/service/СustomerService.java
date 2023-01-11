package ua.com.alevel.service;

import ua.com.alevel.dao.СustomerDaoImpl;
import ua.com.alevel.entity.Сustomer;

import java.util.List;
import java.util.Optional;

public class СustomerService {

    private СustomerDaoImpl customerDao = new СustomerDaoImpl();

    public String create(Сustomer сustomer) {
        if(!validateName(сustomer.getName()) || !validateName(сustomer.getPhone())) {
            System.out.println("Incorrect information. Name can't contain numbers.");
            return null;
        }
        return customerDao.create(сustomer);
    }

    public void update(Сustomer сustomer) {
        if(!validatePhone(сustomer.getName()) || !validatePhone(сustomer.getPhone())) {
            System.out.println("Incorrect information. Phone can't contain numbers.");
            return;
        }
        customerDao.update(сustomer);
    }

    public void delete(String id) {
        customerDao.delete(id);
    }

    public Сustomer findById(String id) {
        Optional<Сustomer> customer = customerDao.findById(id);
        return customer.orElse(null);
    }

    public List<Сustomer> findAll() {
        return customerDao.findAll();
    }

    public void attach(String сustomerId, String shopId) {
        if (сustomerId == null || shopId == null) {
            System.out.println("This ID does not exist.");
        } else {
            customerDao.attach(сustomerId, shopId);
            System.out.println("Attachment is successful.");
        }
    }

    private boolean validateName(String name) {
        return name.matches("[A-Za-z]+");
    }

    private boolean validatePhone(String phone){
        return phone.matches("[0-9]+");
    }
}
