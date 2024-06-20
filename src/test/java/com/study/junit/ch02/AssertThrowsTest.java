package com.study.junit.ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertThrowsTest {
    private SUT systemUnderTest = new SUT("테스트 대상 시스템");

    @Test
    @DisplayName("예외가 발생하는지 검증한다")
    void testExpectedException() {
        //run 메서드 호출시 NoJobException이 발생하는지 검증
        assertThrows(NoJobException.class, systemUnderTest::run);
    }

    @Test
    @DisplayName("예외가 발생하고 예외에 대한 참조가 유지되는지 검증한다")
    void testCatchException() {
        //systemUnderTest.run(1000) 문장이 NoJobException을 던지는지 검증, throwable 예외에 대한 참조가 유지되었는지도 검증
        Throwable throwable =  assertThrows(NoJobException.class,() -> systemUnderTest.run(1000));

        //에러메시지가 다음 문장과 일치하는지 검증
        assertEquals("테스트 대상 시스템은 현재 작업이 없는지 확인",
                throwable.getMessage());
    }
}
