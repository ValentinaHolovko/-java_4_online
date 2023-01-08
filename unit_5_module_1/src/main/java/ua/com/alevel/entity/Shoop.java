package ua.com.alevel.entity;

public class Shoop extends BaseEntity {

    private static Shoop[] shoopsArray = new Shoop[10];
    private String[] shoopIdList = new String[10];
    private String shoopName;
    private String country;

    public String[] getShoopIdList() {
        return shoopIdList;
    }

    public void setShoopIdList(String[] shoopIdList) {
        this.shoopIdList = shoopIdList;
    }

    public String getShoopName() {
        return shoopName;
    }

    public void setShoopName(String shoopName) {
        if (shoopName.matches(".*\\d.*")) {
            System.out.println("Incorrect introduction of the name");
        } else {
            this.shoopName = shoopName;
        }

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country.matches(".*\\d.*")) {
            System.out.println("Incorrect introduction of the name");
        } else {
            this.country = country;
        }
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
