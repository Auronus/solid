package filter;

import good.Good;

import java.util.List;
import java.util.stream.Collectors;

/**
 * SOLID - S Класс должен выполнять только те функции, для которых он логически предназначен.
 * <p>
 * Данный класс предназначен для фильтрации списка товаров по входным условиям
 */
public class GoodFilter {

    public static List<Good> filter(List<Good> goods, Object searchString) {
        if (searchString instanceof Integer) {
            return filterGoodsByPrice(goods, Double.valueOf((Integer) searchString));
        } else if (searchString instanceof String) {
            return filterGoodsByTitleOrProducer(goods, (String) searchString);
        } else {
            throw new IllegalArgumentException("Некорректный тип строки поиска");
        }
    }

    private static List<Good> filterGoodsByPrice(List<Good> goods, Double price) {
        return goods.stream()
                .filter(good -> good.getPrice() == price)
                .collect(Collectors.toList());
    }

    private static List<Good> filterGoodsByTitleOrProducer(List<Good> goods, String searchString) {
        return goods.stream()
                .filter(good -> (searchString.equals(good.getProducer()) || searchString.equals(good.getTitle()))
                        || (good.getProducer().contains(searchString) || good.getTitle().contains(searchString)))
                .collect(Collectors.toList());
    }
}
