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

        // �������� ���������� ����������, � �������������� ����������� AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);



        // �������� ������ ���������� ����� ������� �� �������
        // 1. ������������� ����� �������
        assertThatThrownBy(() ->
                Calculator.calculateDiscount(-1000, 50))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("����� ������� �� ����� ���� �������������");

        // 2. ������������� ������
        assertThatThrownBy(() ->
                Calculator.calculateDiscount(1000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("������ ������ ���� � ��������� �� 0 �� 100%");

        // ������ ������ 100
        assertThatThrownBy(() ->
                Calculator.calculateDiscount(1000, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("������ ������ ���� � ��������� �� 0 �� 100%");

        // ����� �� ������������ ����������

        assertThat(Calculator.calculateDiscount(1000, 25)).isEqualTo(750);
        assertThat(Calculator.calculateDiscount(1000, 100)).isEqualTo(0);
        assertThat(Calculator.calculateDiscount(1000, 0)).isEqualTo(1000);
        /** ������������� ������ */
         //assertThat(Calculator.calculateDiscount(1000, -10)).isEqualTo(1000);
        /** ������������� ����� ������� */
       // assertThat(Calculator.calculateDiscount(- 1000, 25)).isEqualTo(1000);
        /** ������ ������ 100 */
       // assertThat(Calculator.calculateDiscount(1000, 101)).isEqualTo(1000);
    }
}
