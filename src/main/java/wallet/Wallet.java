package wallet;

import money.Cash;

/**
 * SOLID
 * I - принцип сегрегации (разделения) интерфейса
 */
public class Wallet implements IPay{
    private static Wallet instance;

    private Cash money;
    private String material;

    public static Wallet getInstance() {
        return (instance == null ? instance = new Wallet() : instance);
    }

    public boolean insertMoney(int value) {
        money.addValue(value);
        return true;
    }

    @Override
    public boolean pay(int orderPrice) {
        if (money.getValue() - orderPrice >= 0) {
            money.reduceValue(orderPrice);
            return true;
        } else {
            return false;
        }
    }
}
