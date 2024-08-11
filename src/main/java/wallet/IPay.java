package wallet;

/**
 * SOLID
 * I - принцип сегрегации (разделения) интерфейса
 */
public interface IPay {

    public boolean pay(int orderPrice);
}
