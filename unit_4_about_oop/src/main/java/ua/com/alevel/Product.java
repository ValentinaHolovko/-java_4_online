package ua.com.alevel;

public class Product {

    private String id;
    private String productName;
    private String price;
    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}


