package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Shop;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShopServiceTest {

    private static final ShopService service = new ShopService();
    private static final int SIZE = 30;
    private static final String SHOOP_NAME = "test shoop name";
    private static final String COUNTRY = "test country";
    @BeforeAll
    public static void setUp() {

        for (int i = 0; i < SIZE; i++)
            service.create(newShop(i));
    }
    @Test
    @Order(1)
    public void checkShopSizesAfterUpgrading() {
        Assertions.assertEquals(service.findAllShop().size(), SIZE);
    }
    @Test
    @Order(2)
    public void checkShopSizesAfterDeleting() {
        Assertions.assertEquals(service.findAllShop().size(),SIZE - 0);
    }
    @Test
    @Order(3)
    public void checkFindAllShop() {
        Assertions.assertTrue(service.findAllShop().size() != 0);
    }
    @Test
    @Order(4)
    public void checkUpdateShop() {
        Shop shop = service.findAllShop().get(0);
        shop.setShopName("PIKACHU");
        service.update(shop);
        Assertions.assertEquals(service.findAllShop().get(0).getShopName(), "PIKACHU");
    }

    private static Shop newShop(int i) {
        Shop shop = new Shop();
        shop.setShopName(SHOOP_NAME + " " + i);
        shop.setCountry(COUNTRY  + " " + i);
        return shop;
    }
}

