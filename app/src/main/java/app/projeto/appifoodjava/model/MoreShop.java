package app.projeto.appifoodjava.model;

public class MoreShop {

    private int bannerImage;
    private String text;
    private Double rate;
    private String category;
    private Double distance;
    private String time;
    private Double price;

    public MoreShop(){}

    public MoreShop(int bannerImage, String text, Double rate, String category, Double distance, String time, Double price) {
        this.bannerImage = bannerImage;
        this.text = text;
        this.rate = rate;
        this.category = category;
        this.distance = distance;
        this.time = time;
        this.price = price;
    }

    public int getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(int bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
