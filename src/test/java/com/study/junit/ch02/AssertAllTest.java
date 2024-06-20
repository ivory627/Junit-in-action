package com.study.junit.ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertAllTest {
    @Test
    @DisplayName("기본적으로 테스트 대상 시스템은 검증하지 않는다.")
    void testSystemNotVerified() {
        SUT systemUnderTest = new SUT("테스트 대상 시스템");

        assertAll("테스트 대상 시스템을 검증하지 않았는지 확인", //아래 단언문중 예외 발생시 메시지
                () -> assertEquals("테스트 대상 시스템",systemUnderTest.getSystemName()),
                () -> assertFalse(systemUnderTest.isVerified()));
    }

    @Test
    @DisplayName("테스트 대상 시스템을 검증한다")
    void testSystemUnderVerification() {
        SUT systemUnderTest = new SUT("테스트 대상 시스템");

        systemUnderTest.verify();

        /*
        assertAll("테스트 대상 시스템을 검증했는지 확인", //아래 단언문중 예외 발생시 메시지
                () -> assertEquals("테스트 대상 시스템", systemUnderTest.getSystemName()),
                () -> assertTrue(systemUnderTest.isVerified()));

         */

        assertTrue(systemUnderTest.isVerified(),
                () -> "테스트 대상 시스템을 검증했는지 확인");

    }

    @Test
    @DisplayName("테스트 대상 시스템을 검증하지 않았다")
    void testSystemNotUnderVerification() {
        SUT systemUnderTest = new SUT("테스트 대상 시스템");
        assertFalse(systemUnderTest.isVerified(),
                () -> "테스트 대상 시스템을 검증하지 않았는지 확인");
    }

    @Test
    @DisplayName("현재 테스트 대상 시스템은 작업이 없다")
    void testNoJob() {
        SUT systemUnderTest = new SUT("테스트 대상 시스템");
        assertNull(systemUnderTest.getCurrentJob(),
                () -> "테스트 대상 시스템은 현재 작업이 없는지 확인");
    }
}
