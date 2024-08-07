package command;

/**
 * Enum как пример избавления от магических чисел в методе main
 */
public enum UserCommand {
    FILTER_GOODS(UserCommandIds.FILTER_GOODS_ID, "Отфильтровать продукты по выбранным критериям"),
    ADD_GOOD_TO_BASKET(UserCommandIds.ADD_GOOD_TO_BASKET_ID, "Добавить товар в корзину"),
    REMOVE_GOOD_FROM_BASKET(UserCommandIds.REMOVE_GOOD_FROM_BASKET_ID, "Удалить товар из корзины"),
    PLACE_AN_ORDER(UserCommandIds.PLACE_AN_ORDER_ID, "Оформить заказ"),
    SHOW_ORDERS(UserCommandIds.SHOW_ORDERS_ID, "Показать оформленные заказы"),
    TRACK_ORDER(UserCommandIds.TRACK_ORDER_ID, "Отследить уже оформленный заказ"),
    CLOSE_APP(UserCommandIds.CLOSE_APP_ID, "Завершить работу");

    private final int id;
    private final String description;

    UserCommand(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static UserCommand getCommandById(int id) {
        return switch (id) {
            case UserCommandIds.FILTER_GOODS_ID -> FILTER_GOODS;
            case UserCommandIds.ADD_GOOD_TO_BASKET_ID -> ADD_GOOD_TO_BASKET;
            case UserCommandIds.REMOVE_GOOD_FROM_BASKET_ID -> REMOVE_GOOD_FROM_BASKET;
            case UserCommandIds.PLACE_AN_ORDER_ID -> PLACE_AN_ORDER;
            case UserCommandIds.SHOW_ORDERS_ID -> SHOW_ORDERS;
            case UserCommandIds.TRACK_ORDER_ID -> TRACK_ORDER;
            case UserCommandIds.CLOSE_APP_ID -> CLOSE_APP;
            default -> {
                System.out.println("Для данного id нет подходящей комманды");
                yield null;
            }
        };
    }

    @Override
    public String toString() {
        return id + "-'" + description + "'";
    }
}
