package good;

public class Good {
    private String title;
    private int price;
    private String producer;
    private Double rating;

    public Good(String title, int price, String producer) {
        this.price = price;
        this.title = title;
        this.producer = producer;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getProducer() {
        return producer;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "good.Good{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                ", rating=" + rating +
                '}';
    }
}
