package good;

public class Goods {
    public static final Good BREAD = new GoodBuilder().setTitle("Хлеб").setPrice(50).setProducer("\"ООО\" Хлебзавод").build();
    public static final Good MILK = new GoodBuilder().setTitle("Молоко").setPrice(90).setProducer("\"ООО\" Молочник").build();
    public static final Good CHEESE = new GoodBuilder().setTitle("Сыр").setPrice(350).setProducer("\"ООО\" Молочник").build();

    private Goods() {
    }
}
