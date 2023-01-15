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
        String name = сustomerService.create(Customer(NAME, "[A-Za-z]+"));
        Assertions.assertNull(name);
    }

    @Test
    public void testValidationPhone() {
        String phone = сustomerService.create(Customer(PHONE, "^(\\+3)([0-9]{10})$"));
        Assertions.assertNull(phone);
    }
    private Сustomer Customer(String name, String phone) {
        Сustomer сustomer = new Сustomer();
        сustomer.setName(name);
        сustomer.setPhone(phone);
        return сustomer;
    }
}
