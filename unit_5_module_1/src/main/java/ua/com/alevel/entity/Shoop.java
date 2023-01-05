package ua.com.alevel.entity;

public class Shoop extends BaseEntity {
    private static Shoop[] shoopsArray = new Shoop[10];
    private String[] shoopIdList = new String[10];
    private String shoopName;
    private String country;



    public String getShoopName() {
        return shoopName;
    }

    public void setShoopName(String shoopName) {
        this.shoopName = shoopName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Shoop{" +
                "id=" + getId() +
                ", shoopName='" + shoopName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
