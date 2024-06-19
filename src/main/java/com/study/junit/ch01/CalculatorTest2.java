package com.study.junit.ch01;

/**
 * 예외처리와 Calculator 클래스의 확장을 고려한 테스트 프로그램 작성
 * but 테스트가 추가되고 복잡해지면 테스트 프로그램을 작성하고 유지보수 하는것이 점차 어려워지는 문제가 있음.
 * ==> 단위테스트 프레임워크의 필요성
 */
public class CalculatorTest2 {

    private int nbErrors = 0;

    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        if (result != 60) {
            throw new IllegalStateException("Bad result: " + result);
        }
    }

    public static void main(String[] args) {
        CalculatorTest2 test = new CalculatorTest2();
        try {
            test.testAdd();
        } catch (Throwable e) {
            test.nbErrors++;
            e.printStackTrace();
        }
        if (test.nbErrors > 0) {
            throw new IllegalStateException("There were " + test.nbErrors
                    + " error(s)");
        }
    }
}
