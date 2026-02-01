package com.muj.ci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void add_returnsSum() {
        Calculator calculator = new Calculator();
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    void subtract_returnsDifference() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    void multiply_returnsProduct() {
        Calculator calculator = new Calculator();
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    void divide_returnsQuotient() {
        Calculator calculator = new Calculator();
        assertEquals(2.5, calculator.divide(5, 2), 0.0001);
    }

    @Test
    void divide_byZeroThrows() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }
}
