package basket;

import good.Good;
import inter.GoodPrinter;

import java.util.ArrayList;
import java.util.List;

public class Order implements GoodPrinter {
    private List<Good> goods = new ArrayList<>();

    public Order(List<Good> goods) {
        this.goods = goods;
    }

    @Override
    public void printGoods() {
        System.out.println(goods.toString());
    }
}
