package basket;

import good.Good;
import inter.GoodPrinter;

import java.util.ArrayList;
import java.util.List;

public class Basket implements GoodPrinter {
    private static Basket instance;
    private List<Good> goods = new ArrayList<>();

    private Basket() {
    }

    public boolean addGood(Good good) {
        goods.add(good);
        return true;
    }

    public boolean removeGood(Good good) {
        if (goods.contains(good)) {
            goods.remove(good);
            return true;
        } else {
            System.out.println("Корзина не содержит товара " + good);
            return false;
        }
    }

    public static Basket getInstance() {
        if (instance == null) return instance = new Basket();
        return instance;
    }

    public Order placeAnOrder() {
        Order order = new Order(this.goods);
        clearBasket();
        return order;
    }

    private void clearBasket() {
        this.goods = new ArrayList<>();
    }

    @Override
    public void printGoods() {
        System.out.println("Содержимое корзины : " + goods.toString());
    }
}
