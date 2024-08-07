package good;

public class GoodBuilder {
    private int price;
    private String title;
    private String producer;
    private Double rating;

    public GoodBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public GoodBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public GoodBuilder setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public GoodBuilder setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public Good build() {
        Good good;
        if (title == null || price == 0 || producer == null) {
            throw new IllegalStateException("Не заполнены обязательные поля");
        }
        good = new Good(title, price, producer);
        good.setRating(rating);
        return good;
    }
}