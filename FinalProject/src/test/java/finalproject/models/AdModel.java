package finalproject.models;

public class AdModel {

    private String category;
    private String title;
    private String description;
    private String price;
    private String currency;
    private String region;
    private String city;
    private String cityArea;
    private String address;

    public AdModel(String category, String title, String description,
                   String price, String currency, String region,
                   String city, String cityArea, String address) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.region = region;
        this.city = city;
        this.cityArea = cityArea;
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityArea() {
        return cityArea;
    }

    public void setCityArea(String cityArea) {
        this.cityArea = cityArea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
