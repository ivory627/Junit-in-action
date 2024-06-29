package com.study.junit.ch04;

import com.study.junit.ch02.ResourceForAllTests;
import com.study.junit.ch02.SUT;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JUnit5SUTTest {

    private static ResourceForAllTests resourceForAllTests;
    private SUT systemUnderTest;

    @BeforeAll
    static void setUpClass() {
        resourceForAllTests = new ResourceForAllTests("테스트를 위한 리소스");
    }

    @AfterAll
    static void tearDownClass() {
        resourceForAllTests.close();
    }

    @BeforeEach
    void setUp() {
        systemUnderTest = new SUT("테스트 대상 시스템");
    }

    @AfterEach
    void tearDown() {
        systemUnderTest.close();
    }

    @Test
    void testRegularWork() {
        boolean canReceiveRegularWork = systemUnderTest.canReceiveAdditionalWork();
        assertFalse(canReceiveRegularWork);
    }

    @Test
    @Disabled
    void myThirdTest() {
        assertEquals(2,1, "2 is not equal to 1");
    }
}
