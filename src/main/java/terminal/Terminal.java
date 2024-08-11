package terminal;

/**
 * Касса
 */
public class Terminal {
    public boolean pay(int expectedPayment, int actualPayment) {
        return actualPayment >= expectedPayment;
    }
}
