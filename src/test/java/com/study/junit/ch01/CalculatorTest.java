package com.study.junit.ch01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10,50);
        assertEquals(60, result, 0);
        //assertEquals(expected : 예상 값, result : 실제 값, delta : 오차 범위)
    }
}