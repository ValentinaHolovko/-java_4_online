package ua.com.alevel.entity;

import java.util.HashSet;
import java.util.Set;

public class Shop extends BaseEntity {

    private String shopName;
    private String country;
    private Set<String> customerIdList = new HashSet<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<String> getCustomerIdList() {
        return customerIdList;
    }

    public void setCustomerIdList(Set<String> customerIdList) {
        this.customerIdList = customerIdList;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopName='" + shopName + '\'' +
                ", country='" + country + '\'' +
                ", id='" + getId() + '\'' +
                ", customerIdList=" + customerIdList +
                '}';
    }
}
