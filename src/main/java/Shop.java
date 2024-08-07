import basket.Order;
import filter.GoodFilter;
import good.Good;
import good.Goods;
import inter.GoodPrinter;

import java.util.ArrayList;
import java.util.List;

public class Shop implements GoodPrinter {
    private static Shop shop;
    private List<Good> availableGoods = List.of(Goods.BREAD, Goods.MILK, Goods.CHEESE);
    private List<Order> orders = new ArrayList<>();

    private Shop() {

    }

    public static Shop getInstance() {
        if (shop == null) return shop = new Shop();
        return shop;
    }

    public void filterGoods(Object searchString) {
        List<Good> goods = GoodFilter.filter(availableGoods, searchString);
        if (goods.isEmpty()) {
            System.out.println("Не найдено товаров удовлетворяющих условиям поиска");
        } else {
            System.out.println(goods);
        }
    }

    public Good getGoodByName(String title) {
        return availableGoods.stream()
                .filter(good -> title.equals(good.getTitle()))
                .findFirst()
                .orElse(null);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void printGoods() {
        System.out.println(availableGoods.toString());
    }
}
