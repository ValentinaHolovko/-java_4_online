package ua.com.alevel.db;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Shop;
import ua.com.alevel.entity.Сustomer;

import java.util.Optional;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DbStorageTest {
    private static final int SIZE = 10;
    private static final DbStorage dbStorage = new DbStorage();

    private static final String SHOP_NAME = "test shop name";
    private static final String COUNTRY = "test country";
    private static final String NAME = "test Name";
    private static final String PHONE = "test Phone";

    private String defaultСustomerId;
    private String defaultShopId;
    @BeforeAll
    private static void setUpСustomer() {
        for (int i = 0; i < SIZE; i++) {
            Сustomer customer = generateСustomerId(i);
            dbStorage.createСustomer(customer);
        }
    }

    @BeforeAll
    public static void setUpShop() {
        for (int i = 0; i < SIZE; i++) {
            Shop shop = generateShopId(i);
            dbStorage.createShop(shop);
        }
    }

    private static Shop generateShopId(int i) {
        Shop shop = new Shop();
        shop.setShopName(SHOP_NAME);
        shop.setCountry(COUNTRY);
        return shop;
    }

    private static Сustomer generateСustomerId(int i) {
        Сustomer customer = new Сustomer();
        customer.setName(NAME);
        customer.setPhone(PHONE);
        return customer;
    }

    @Test
    @Order(1)
    public void checkSizeShop() {
        Assertions.assertNotEquals(dbStorage.findAllShops().size(), SIZE);
    }

    @Test
    @Order(2)
    public void checkSizeСustomer() {
        Assertions.assertNotEquals(dbStorage.findAllCustomers().size(), SIZE);
    }

    @Test
    @Order(3)
    public void createShop() {
        Shop shop = generateShopId(SIZE + 1);
        dbStorage.createShop(shop);
        Assertions.assertNotEquals(dbStorage.findAllShops().size(), SIZE + 1);
    }

    @Test
    @Order(4)
    public void createСustomer() {
        Сustomer customer = generateСustomerId(SIZE + 1);
        dbStorage.createСustomer(customer);
        Assertions.assertNotEquals(dbStorage.findAllCustomers().size(), SIZE + 1);
    }
    @Test
    @Order(5)
    public void testDeleteShop() {
        dbStorage.deleteShop(defaultShopId);
        dbStorage.deleteShopFromCustomerList(defaultShopId);

        Optional<Shop> shop = dbStorage.getShop(defaultShopId);
        Assertions.assertFalse(shop.isPresent());

        Optional<Сustomer> customer = dbStorage.getCustomer(defaultСustomerId);
    }
    @Test
    @Order(6)
    public void testDeleteClient() {
        dbStorage.deleteCustomer(defaultСustomerId);
        dbStorage.deleteCustomerFromShopList(defaultСustomerId);

        Optional<Сustomer> customer = dbStorage.getCustomer(defaultСustomerId);
        Assertions.assertFalse(customer.isPresent());

        Optional<Shop> shop = dbStorage.getShop(defaultShopId);
        

    }
}