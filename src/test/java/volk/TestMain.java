package src.test.java.volk;

import org.junit.jupiter.api.Test;
import src.main.java.volk.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    Main main = new Main();

    @Test
    public void shouldGiveNoDiscountForValue999() {
        // Подготовка
        int buySum = 999;
        int expectedSum = 999;

        // Исполнение
        int result = main.sumAfterDiscount(buySum);

        // Проверка
        assertEquals(expectedSum, result);
    }
}
