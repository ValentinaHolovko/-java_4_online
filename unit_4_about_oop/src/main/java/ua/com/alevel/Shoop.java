package ua.com.alevel;
public class Shoop {

    private String productName;
    private String productID;
    private String unitPrice;
    private String idealStock  ;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName.matches(".*\\d.*")) {
            System.out.println("Название продукта не должно иметь цифры!!!");
        } else {
            this.productName = productName;
        }
    }
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        if (productName.matches("([+\\-\\d ]+)")) {
            System.out.println("");
        } else {
            this.productID = productID;
        }
   }
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        if (productName.matches("^\\d+")) {
            System.out.println("Только буквы");
        } else {
        this.unitPrice = unitPrice;
    }
    }

    public String getIdealStock() {
        return idealStock;
    }

    public void setIdealStock(String idealStock) {
        if (productName.matches("^\\d+")) {
            System.out.println("Только буквы");
        } else {
            this.idealStock = idealStock;
        }
    }
    @Override
    public String toString() {
        return "Shoop{" +
                "productName='" + productName + '\'' +
                ", productID='" + productID + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", idealStock='" + idealStock + '\'' +
                '}';
    }

}

