package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Сustomer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class СustomerServiceTest {

    private static final СustomerService сustomerService = new СustomerService();

    private static final String NAME = "test Name";
    private static final String PHONE = "test Phone";

    @Test

    public void testValidationName() {
        String id = сustomerService.createName(Customer(NAME, "[A-Za-z]+"));
        Assertions.assertNull(id);
    }

    @Test
    public void testValidationPhone() {
        String id = сustomerService.createPhone(Customer(PHONE, "^(\\+3)([0-9]{10})$"));
        Assertions.assertNull(id);
    }

    private Сustomer Customer(String phone, String name) {
        Сustomer сustomer = new Сustomer();
        сustomer.setName(name);
        сustomer.setPhone(phone);
        return сustomer;
    }
}