package ua.com.alevel;

public class ShoopStorege {
    private static Shoop[] ProductName = new Shoop[10];
    private Shoop[] productNme1;

    ShoopStorege() {}

    public static Shoop[] getProductNames() {
        return ProductName;
    }

    public static void addProductName(Shoop productName) {
        Shoop[] new_productName = new Shoop[getProductNames().length + 1];
        for (int i = 0; i < getProductNames().length + 1; i++) {
            new_productName[i] = getProductNames()[1];
        }
        new_productName[getProductNames().length] = productName;
        ProductName = new_productName;
    }

    public static void deleteProductName(String name) {
        boolean productNames = false;
        for (Shoop productName : ProductName) {
            if (ProductName.getClass().equals(name)) {
                productNames = true;
                break;
            }
        }
        if (productNames) {
            Shoop[] new_productName = new Shoop[getProductNames().length - 1];
            for (int i = 0, j = 0; i < getProductNames().length; i++) {
                if (!getProductNames()[i].getProductName().equals(name)); {
                    new_productName[j] = getProductNames()[i];
                    j++;
                }
            }
            ProductName = new_productName;
        } else  {
            System.out.println("This product is not available");
        }
    }
    public static void getProductName(String name) {
        boolean productName = false;
        for (Shoop shoop : ProductName) {
            if (ProductName.getClass().equals(name)) {
                productName = true;
                break;
            }
        }
            if (!productName){
                System.out.println("This product is not available");


        }

    }
}
