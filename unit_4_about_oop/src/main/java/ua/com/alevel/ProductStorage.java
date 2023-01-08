package ua.com.alevel;

public class ProductStorage {

    private static int i = 1;
    private static int count = 0;
    private static Product[] productsArray = new Product[i];

    private ProductStorage() {}

    public static Product[] getProduct() {
        return productsArray;
    }

    public static void addProduct(Product product) {
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i] == null) {
                productsArray[i] = product;
                break;
            }
            if (productsArray[productsArray.length - 1] != null) {
                productsArray = new Product[productsArray.length * 2];
                for (int j = 0; j < productsArray.length; j++) {
                    productsArray[j] = productsArray[j];
                }
                productsArray = productsArray;
            }

        }
    }

    public static void deleteProduct(String name) {
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i] != null) {
                if (productsArray[i].getProductName().equals(name)) {
                    productsArray[i] = null;
                    return;
                }
            }
        }
        System.out.println("Wrong Name");
    }

    public static Product getProduct(String name) {
        for (Product product : productsArray) {
            if (product != null) {
                if (product.getProductName().equals(name)) {
                    return product;
                }
            }
        }
        return null;
    }
}
