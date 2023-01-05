package ua.com.alevel.db;

import ua.com.alevel.entity.Product;
import ua.com.alevel.entity.Shoop;

import java.util.Arrays;
import java.util.UUID;
public class DbStorage {


    private static Product[] products = new Product[10];
    private static Shoop[] shoops = new Shoop[6];
    private static Product[] productsArray;
    private static Shoop[] shoopsArray;

    private DbStorage() {
    }

    public static void addProduct(Product product) {
        product.setId(generateProductId());

       for (int i = 0; i< products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
            break;

            }
            if (products[products.length - 1] != null  ) {
                productsArray = new Product[products.length * 2];
                for (int j = 0; j < products.length; j++) {
                    productsArray[j] = products[j];
                }
                products = productsArray;
                }
            }
        }

     public static void addShoop(Shoop shoop) {
        shoop.setId(generateShoopId());

         for (int i = 0; i< shoops.length; i++) {
             if (shoops[i] == null) {
                 shoops[i] = shoop;
                 break;

             }
             if (shoops[shoops.length - 1] != null  ) {
                 shoopsArray = new Shoop[shoops.length * 2];
                 for (int j = 0; j < shoops.length; j++) {
                     shoopsArray[j] = shoops[j];
                 }
                 shoops = shoopsArray;
             }
         }
     }
    private static String generateProductId() {
        String id = UUID.randomUUID().toString();

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {

                if (products[i].getId().equals(id)) {
                    return generateProductId();
        }
            }
        }
        return id;
    }

    public static String generateShoopId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < shoops.length; i++) {
            if (shoops[i] != null) {
            if (shoops[i].getId().equals(id)) {
                return generateShoopId();
            }
            }
        }
        return id;
    }

    public static void deleteProduct(String id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                if (products[i].getId().equals(id)) {
                    products[i] = null;
                    return;
}

            }
        }
        System.out.println("Wrong id");
    }
    public static void deleteShoop(String id) {
        for (int i = 0; i < shoops.length; i++) {
            if (shoops[i] != null) {
                if (shoops[i].getId().equals(id)) {
                    shoops[i] = null;
                    return;
}

            }
        }
        System.out.println("Wrong id");
    }
public static Product getProduct(String id) {
    for (int i = 0; i < products.length; i++) {
        if (products[i] != null) {
            if (products[i].getId().equals(id)) {
                return products[i];
            }
        }
    }
    return null;
}

    public static void attach(String productId, String shoopId) {

        attachProductToShoop(productId, shoopId);
        attachProductToShoop(productId, shoopId);
    }

    private static void attachProductToShoop(String productId, String shoopId) {
        Shoop shoop = getShoop(shoopId);
        String products = shoop.getId();
        products = addProductToShoop(new String[]{products}, productId);
        shoop.setId(Arrays.toString(products.toCharArray()));
        Product product = getProduct(productId);
        String shoops = product.getId();
        shoops = addProductToShoop(new String[]{shoops}, shoopId);
        product.setId(Arrays.toString(shoops.toCharArray()));
    }

    private static String addProductToShoop(String[] array, String element) {
        int emptyIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].equals(element)) {
                    return Arrays.toString(array);
                }
            } else if(emptyIndex == -1){
                emptyIndex = i;
            }
        }

        if(emptyIndex == -1) {
            String[] temp = Arrays.copyOf(array, array.length + 5);
            array = temp;
        }
        array[emptyIndex] = element;
        return Arrays.toString(array);
    }
public static Shoop getShoop(String id) {
                    for (int i = 0; i < shoops.length; i++) {
                        if (shoops[i] != null) {
                            if (shoops[i].getId().equals(id)) {
                                return shoops[i];
                                  }
                        }
                    }
                    return null;
    }

    public static Product[] getProduct() {

        return products;
    }
    public static Shoop[] getShoop() {

        return shoops;
    }

    public static void deleteProductToShoop(String productId, String shoopId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                if (products[i].getId().equals(productId)) {
                    products[i] = null;
                    for (i = 0; i < shoops.length; i++) {
                        if (shoops[i] != null) {
                            if (shoops[i].getId().equals(shoopId)) {
                                shoops[i] = null;
                                return;
                            }

                        }
                    }
                    System.out.println("Wrong id");
                }
            }}}
    public static void addProductToShoop(String shoopId, String productId) {
    }
}