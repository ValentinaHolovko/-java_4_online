package ua.com.alevel.entity;

public class Мusic {
    private String id;
    private String musicTitle;
    private String singer;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMusicTitle() {
        return musicTitle;
    }

    public void setMusicTitle(String musicTitle) {
        this.musicTitle = musicTitle;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() { //TODO add id
        return "Мusic{" +
                "id='" + id + '\'' +
                ", musicTitle='" + musicTitle + '\'' +
                ", singer='" + singer + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
