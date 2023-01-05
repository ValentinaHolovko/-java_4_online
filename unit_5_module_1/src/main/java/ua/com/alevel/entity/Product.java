package ua.com.alevel.entity;

public class Product extends BaseEntity{
    private static Product[] productsArray = new Product[10];
    private String[] productIdList = new String[10];
    private String productName;
    private String price;
    private String country;

    public String[] getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(String[] carIdList) {
        this.productIdList = carIdList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName.matches(".*\\d.*")) {
            System.out.println("Incorrect introduction of the name");
        } else {
            this.productName = productName;
        }

    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}



