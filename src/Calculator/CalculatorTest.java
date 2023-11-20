package Calculator;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {

        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);



        // проверка метода вычисления суммы покупки со скидкой
        // 1. Отрицательная сумма покупки
        assertThatThrownBy(() ->
                Calculator.calculateDiscount(-1000, 50))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");

        // 2. Отрицательная скидка
        assertThatThrownBy(() ->
                Calculator.calculateDiscount(1000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

        // Скидка больше 100
        assertThatThrownBy(() ->
                Calculator.calculateDiscount(1000, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

        // Тесты на корректность результата

        assertThat(Calculator.calculateDiscount(1000, 25)).isEqualTo(750);
        assertThat(Calculator.calculateDiscount(1000, 100)).isEqualTo(0);
        assertThat(Calculator.calculateDiscount(1000, 0)).isEqualTo(1000);
        /** отрицательная скидка */
         //assertThat(Calculator.calculateDiscount(1000, -10)).isEqualTo(1000);
        /** отрицательная сумма покупки */
       // assertThat(Calculator.calculateDiscount(- 1000, 25)).isEqualTo(1000);
        /** скидка больше 100 */
       // assertThat(Calculator.calculateDiscount(1000, 101)).isEqualTo(1000);
    }
}
