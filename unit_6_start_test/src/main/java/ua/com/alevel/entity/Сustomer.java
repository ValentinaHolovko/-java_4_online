package ua.com.alevel.entity;

import java.util.HashSet;
import java.util.Set;

public class Сustomer extends BaseEntity {

    private String name;
    private String phone;
    private Set<String> shopIdList = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setShopIdList(Set<String> shopIdList) {
        this.shopIdList = shopIdList;
    }

    public Set<String> getShopIdList() {
        return shopIdList;
    }

    @Override
    public String toString() {
        return "Сustomer{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                "id='" + getId() + '\'' +
                ", shopIdList=" + shopIdList +
                '}';
    }
}
