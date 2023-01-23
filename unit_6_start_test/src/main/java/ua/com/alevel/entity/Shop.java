package ua.com.alevel.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Shop extends BaseEntity {
    private Set<String> shopIdList = new HashSet<>();
    private String shopName;
    private String country;

    public Set<String> getShopIdList() {
        return shopIdList;
    }

    public void setShopIdList(Set<String> shopIdList) {
        this.shopIdList = shopIdList;
    }

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

    @Override
    public String toString() {
        return "Shop{" +
                ", shopIdList=" + shopIdList +
                ", shopName='" + shopName + '\'' +
                ", country='" + country + '\'' +
                ", id='" + getId() + '\'' +
                '}';
    }
}
