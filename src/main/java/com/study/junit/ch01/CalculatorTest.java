package com.study.junit.ch01;

/**
 * Calculator의 add 메서드 테스트를 위한 테스트프로그램 작성
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double result = calculator.add(10,50);
        if(result != 60) {
            System.out.println("Bad result: " + result);
        }
    }
}
