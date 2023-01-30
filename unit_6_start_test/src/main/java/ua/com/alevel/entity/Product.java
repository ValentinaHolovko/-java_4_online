package ua.com.alevel.entity;

import java.util.HashSet;
import java.util.Set;

public class Product extends BaseEntity {

    private Set<String> productIdList = new HashSet<>();
    private String productName;
    private String price;
    private String country;

    public Set<String> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(Set<String> productIdList) {
        this.productIdList = productIdList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
                "productIdList=" + productIdList +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", country='" + country + '\'' +
                ", id='" + getId() + '\'' +
                '}';
    }
}
