package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Сustomer;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class СustomerServiceTest {

    private static final СustomerService сustomerService = new СustomerService();

    private static final String NAME = "testName";
    private static final String PHONE = "testPhone";


    @Test

    public void testCreateSuccessful() {
        String id = сustomerService.create(makeCustomer(NAME, PHONE));
        Assertions.assertNotNull(id);
    }

    @Test

    public void testValidationName() {
        String name = сustomerService.create(makeCustomer(NAME, "A-Z"));
        Assertions.assertNull(name);
    }

    @Test
    public void testValidationPhone() {
        String phone = сustomerService.create(makeCustomer(PHONE, "0-9"));
        Assertions.assertNull(phone);
    }

    private Сustomer makeCustomer(String name, String phone) {
        Сustomer сustomer = new Сustomer();
        сustomer.setName(name);
        сustomer.setPhone(phone);
        return сustomer;
    }
}
