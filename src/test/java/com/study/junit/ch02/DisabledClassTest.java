package com.study.junit.ch02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("기능 개발 중")
public class DisabledClassTest {
    private SUT systemUnderTest = new SUT("테스트 대상 시스템");

    @Test
    void testRegularWork() {
        boolean canReceiveRegularWork =
                systemUnderTest.canReceiveRegularWork();
        assertTrue(canReceiveRegularWork);
    }

    @Test
    void testAdditionalWork() {
        boolean canReceiveAdditionalWork =
                systemUnderTest.canReceiveAdditionalWork();
        assertFalse(canReceiveAdditionalWork);
    }
}
