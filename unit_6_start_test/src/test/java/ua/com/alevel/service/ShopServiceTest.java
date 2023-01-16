package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Shop;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShopServiceTest {

    private static final ShopService service = new ShopService();
    private static final int SHOP = 10;

    private static final String SHOP_NAME = "test shoop name";
    private static final String COUNTRY = "test country";

    @BeforeAll
    public static void setUp() {

        for (int i = 0; i < SHOP; i++)
            service.create(newShop(i));

    }

    @Test
    @Order(1)
    public void checkShopAfterUpgrading() {
        Assertions.assertEquals(service.findAllShop().size(), SHOP);
    }

    @Test
    @Order(2)
    public void checkShopAfterDeleting() {
        Assertions.assertEquals(service.findAllShop().size(), SHOP - 0);

    }

    @Test
    @Order(3)
    public void checkFindAllShop() {
        Assertions.assertTrue(service.findAllShop().size() != 0);
    }



    private static Shop newShop(int i) {
        Shop shop = new Shop();
        shop.setShopName(SHOP_NAME + " " + i);
        shop.setCountry(COUNTRY + " " + i);
        return shop;
    }
}