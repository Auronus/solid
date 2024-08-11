package money;

/**
 * L - принцип замены Барбары Лисков
 */
public class Money {
    private int value;

    public void addValue(int value) {
        this.value += value;
    }

    public void reduceValue(int value) {
        this.value -= value;
    }

    public int getValue() {
        return value;
    }
}
