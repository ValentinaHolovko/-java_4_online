package ua.com.alevel.servise;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shop;
import ua.com.alevel.service.ProductShopService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceTest {
    private static final ProductShopService productShopService;
    private static final String SHOPNAME = "testName";
    private static final String PRODUCTNAME = "testName";
    private static final String PRICE = "testPrice";
    private static final String COUNTRY = "testCountry";
    private static final int SHOP = 0;
    private static final int PRODUCT = 0;

    static {
        productShopService = new ProductShopService();
    }

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < SHOP; i++) {
            Shop shop = generateShop(i);
            productShopService.addShop(shop);
        }
        for (int i = 0; i < PRODUCT; i++) {
            Product product = generateProduct(i);
            productShopService.addProduct(product);
        }
    }

    private static Product generateProduct(int i) {
        Product product = new Product();
        product.setProductName(PRODUCTNAME + i);
        product.setPrice(PRICE + i);
        product.setCountry(COUNTRY + i);
        return product;
    }

    private static Shop generateShop(int i) {
        Shop shop = new Shop();
        shop.setShopName(SHOPNAME + i);
        shop.setCountry(COUNTRY + i);
        return shop;
    }

    @Test
    @Order(1)
    public void checkSizeShop() {
        Shop shop = generateShop(SHOP + 1);
        productShopService.addShop(shop);
        Assertions.assertEquals(productShopService.findAllShops().size(), SHOP);
    }

    @Test
    @Order(2)

    public void checkSizeProduct() {
        Assertions.assertEquals(productShopService.findAllProducts().size(), PRODUCT);
    }

    @Test
    @Order(3)
    public void createShop() {
        Shop shop = generateShop(SHOP);
        productShopService.addShop(shop);
        Assertions.assertEquals(productShopService.findAllShops().size(), SHOP);

    }

    @Test
    @Order(4)
    public void createProduct() {
        Product product = generateProduct(PRODUCT);
        productShopService.addProduct(product);
        Assertions.assertEquals(productShopService.findAllProducts().size(), PRODUCT);

    }

    @Test
    @Order(5)
    public void deleteShop() {

        for (int i = 0; i < SHOP; i++) {
            Shop deleteShop = productShopService.findAllShops().stream().toList().get(i);

            productShopService.deleteShop(deleteShop.getId());
        }
        Assertions.assertEquals(productShopService.findAllShops().size(), SHOP);

    }

    @Test
    @Order(6)
    public void deleteProduct() {

        for (int i = 0; i < PRODUCT; i++) {
            Product deleteProduct = productShopService.findAllProducts().stream().toList().get(i);

            productShopService.deleteProduct(deleteProduct.getId());
        }
        Assertions.assertEquals(productShopService.findAllProducts().size(), PRODUCT);

    }

    @Test
    @Order(7)
    public void updateShop() {
        List<Shop> shops = productShopService.findAllShops();
        if (!shops.isEmpty()) {
            Shop shop = shops.get(0);
            shop.setCountry("Kharkov");
            productShopService.updateShop(shop);
            Assertions.assertNotEquals(productShopService.findAllProducts().get(0).getCountry(), COUNTRY);
        }
    }

    @Test
    @Order(8)
    public void updateProductTest() {
        List<Product> products = productShopService.findAllProducts();
        if (!products.isEmpty()) {
            Product product = products.get(0);
            product.setPrice("1000");
            productShopService.updateProduct(product);
            Assertions.assertNotEquals(productShopService.findAllProducts().get(0).getPrice(), PRICE);
        }
    }

    @Test
    @Order(9)
    public void findAllShops() {
        List<Shop> shops = productShopService.findAllShops();
        assertNotEquals(SHOPNAME, shops.size());
    }

    @Test
    @Order(10)
    public void findAllProducts() {
        List<Product> products = productShopService.findAllProducts();
        assertNotEquals(PRODUCTNAME, products.size());
    }
}


