import basket.Basket;
import command.UserCommand;
import good.Good;
import inter.GoodPrinter;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = Shop.getInstance();

        System.out.println("Добро пожаловать в магазин Семёрочка");
        System.out.println("В нашем магазине представлен следующий каталог товаров : ");
        printGoods(shop);

        do {
            System.out.println("Выберите дальнейшее действие :\n" +
                    Arrays.toString(UserCommand.values()));
            UserCommand command = UserCommand.getCommandById(readValueFromUser(scanner));
            assert command != null;
            executeCommand(command, scanner);
        }
        while (true);
    }

    /**
     * А Метод чтения значения от юзера как пример использования паттерна DRY
     *
     * @param scanner
     * @return
     */
    private static int readValueFromUser(Scanner scanner) {
        String value = scanner.next();
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            System.out.println("Введенное значение не является числом поддерживаемого формата (челочисленное значение); Повторите ввод");
            return readValueFromUser(scanner);
        }
    }

    private static void executeCommand(UserCommand command, Scanner scanner) {
        Shop shop = Shop.getInstance();
        switch (command) {
            case FILTER_GOODS:
                filterGoods(scanner);
                break;
            case ADD_GOOD_TO_BASKET:
                addGoodToBasket(scanner);
                break;
            case REMOVE_GOOD_FROM_BASKET:
                removeGoodFromBasket(scanner);
                break;
            case PLACE_AN_ORDER:
                Basket basket = Basket.getInstance();
                shop.addOrder(basket.placeAnOrder());
                break;
            case SHOW_ORDERS:
                shop.getOrders().forEach(Main::printGoods);
                break;
            case TRACK_ORDER:
                break;
            case CLOSE_APP:
                System.exit(1);
            default:
                System.out.println("Введенный код комманды не является корректным, возвращение в главное меню");
        }
    }

    private static void filterGoods(Scanner scanner) {
        Shop shop = Shop.getInstance();
        System.out.println("Введенное Значение для фильтрации (число или строку)");
        Object value = scanner.next();
        shop.filterGoods(value);
    }

    private static void addGoodToBasket(Scanner scanner) {
        Basket basket = Basket.getInstance();
        Shop shop = Shop.getInstance();
        System.out.println("Введите название товара для добавления в корзину");
        String value = scanner.next();
        Good good = shop.getGoodByName(value);
        if (good != null) {
            basket.addGood(good);
            System.out.println("Товар " + good + " добавлен в корзину");
        } else {
            System.out.println("Товар с именем " + value + " не найден");
        }
        printGoods(basket);
    }

    private static void removeGoodFromBasket(Scanner scanner) {
        Basket basket = Basket.getInstance();
        Shop shop = Shop.getInstance();
        System.out.println("Введите название товара для удаления из корзины");
        String value = scanner.next();
        Good good = shop.getGoodByName(value);
        if (good != null) {
            if (basket.removeGood(good)) {
                System.out.println("Товар " + good + " удален из корзины");
            }
        } else {
            System.out.println("Товар с именем " + value + " не найден");
        }
        printGoods(basket);
    }


    /**
     * SOLID - O
     * SOLID - D
     * <p>
     * Данный метод принимает интерфейс, который реализовывают различные классы для вывода товаров
     */
    private static void printGoods(GoodPrinter goodPrinter) {
        goodPrinter.printGoods();
    }

}