package ua.com.alevel.singer;

public class Singer {
    private String executor;
    private String country;

    public String getExecutor() {
        return executor;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "executor='" + executor + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public void setExecutor(String executor) {
        if (executor.matches("\\W+")) {
            System.out.println("This name is incorrect");
            this.executor = defaultValue;
        } else if (executor.length() > 12) {
            System.out.println("This name is too long");
            this.executor = defaultValue;
        } else if (executor.trim().equals("")) {
            this.executor = defaultValue;
        } else {
            this.executor = executor;
        this.executor = executor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country.matches("[^\\w ]+")) {
            System.out.println("This country name is incorrect");
            this.country = defaultValue;
        } else if (country.length() > 20) {
            System.out.println("This country name is too long");
            this.country = defaultValue;
        } else if (country.trim().equals("")) {
            this.country = defaultValue;
        } else {
            this.country = country;
        }
    }


    }
}
