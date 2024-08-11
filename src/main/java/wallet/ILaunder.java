package wallet;

/**
 * SOLID
 * I - принцип сегрегации (разделения) интерфейса
 */
public interface ILaunder {
    /**
     * Метод отмывания денег
     * @return
     */
    public boolean launder(int value);
}
