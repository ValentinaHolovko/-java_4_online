package ua.com.alevel.servise;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shop;
import ua.com.alevel.service.ProductShopService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductShopServiceTest {
    private static final ProductShopService productShopService = new ProductShopService();

    private static int SHOP = 5;
    private static int PRODUCT = 10;
    private static final String SHOPNAME = "testName";
    private static final String PRODUCTNAME = "testName";
    private static final String PRICE = "testPrice";
    private static final String COUNTRY = "testCountry";

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < SHOP; i++) {
            Shop shop = generateShop(i);
            productShopService.createShop(shop);
        }
        for (int j = 0; j < PRODUCT; j++) {
            Product product = generateProduct(j);
            productShopService.createProduct(product);
        }
    }

    @Test
    @Order(1)
    public void checkSizeShop() {
        Assertions.assertEquals(productShopService.findAllShop().size(), SHOP);
    }

    @Test
    @Order(2)
    public void checkSizeProduct() {
        Assertions.assertEquals(productShopService.findAllProduct().size(), PRODUCT);
    }

    @Test
    @Order(3)
    public void createShop() {
        Shop shop = generateShop(SHOP + 1);
        productShopService.createShop(shop);
        Assertions.assertEquals(productShopService.findAllShop().size(), SHOP + 1);

    }

    @Test
    @Order(4)
    public void createProduct() {
        Product product = generateProduct(PRODUCT + 1);
        productShopService.createProduct(product);
        Assertions.assertEquals(productShopService.findAllProduct().size(), PRODUCT + 1);

    }

    @Test
    @Order(5)
    public void deleteShop() {
        Shop shop = productShopService.findAllShop().get(0);
        productShopService.deleteShop(shop.getId());
        Assertions.assertEquals(productShopService.findAllShop().size(), SHOP);
    }

    @Test
    @Order(6)
    public void deleteProduct() {
        Product product = productShopService.findAllProduct().get(0);
        productShopService.deleteProduct(product.getId());
        Assertions.assertEquals(productShopService.findAllProduct().size(), PRODUCT);
    }

    @Test
    @Order(7)
    public void updateShopTest() {
        Shop shop = productShopService.findAllShop().get(0);
        shop.setCountry("Kharkov");
        productShopService.updateShop(shop);
        Assertions.assertNotEquals(productShopService.findAllShop().get(0).getCountry(), COUNTRY);
    }

    @Test
    @Order(8)
    public void updateProductTest() {
        Product product = productShopService.findAllProduct().get(0);
        product.setPrice("1000");
        productShopService.updateProduct(product);
        Assertions.assertNotEquals(productShopService.findAllProduct().get(0).getPrice(), PRODUCT);
    }

    @Test
    @Order(9)
    public void findAllShop() {
        Shop shop = productShopService.findAllShop().get(0);
        Assertions.assertEquals(productShopService.findAllShop().size(), SHOP);

    }

    @Test
    @Order(10)
    public void findAllProduct() {
        Product product = productShopService.findAllProduct().get(0);
        Assertions.assertEquals(productShopService.findAllProduct().size(), PRODUCT);

    }

    private static Product generateProduct(int j) {
        Product product = new Product();
        product.setProductName(PRODUCTNAME + j);
        product.setPrice(PRICE + j);
        product.setCountry(COUNTRY + j);
        return product;
    }

    private static Shop generateShop(int i) {
        Shop shop = new Shop();
        shop.setShopName(SHOPNAME + i);
        shop.setCountry(COUNTRY + i);
        return shop;
    }
}

