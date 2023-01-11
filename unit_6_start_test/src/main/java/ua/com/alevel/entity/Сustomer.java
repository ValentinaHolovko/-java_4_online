package ua.com.alevel.entity;

import java.util.HashSet;
import java.util.Set;

public class Сustomer extends BaseEntity {

    private String Name;
    private String phone;
    private Set<String> shopIdList = new HashSet<>();

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
                "Name='" + Name + '\'' +
                ", phone='" + phone + '\'' +
                "id='" + getId() + '\'' +
                ", shopIdList=" + shopIdList +
                '}';
    }
}
