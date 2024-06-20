package com.study.junit.ch02;

import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssumptionTest {
    private static String EXPECTED_JAVA_VERSION = "1.8";
    private TestsEnvironment environment = new TestsEnvironment(
            new JavaSpecification(
                    System.getProperty("java.vm.specification.version")
            ),
            new OperationSystem(
                    System.getProperty("os.name"),
                    System.getProperty("os.arch")
            )
    );

    private  SUT systemUnderTest = new SUT();

    @BeforeEach //각 테스트가 실행 되기 전 실행되는 메서드로 OS가 window인지 확인한다.
    void setUp() {
        assumeTrue(environment.isWindows());
    }

    @Test
    void testNoJobToRun() {
        assumingThat(
                //자바 버전이 1.8인지 검증한다.
                () -> environment.getJavaVersion().equals(EXPECTED_JAVA_VERSION),
                //자바 버전이 1.8일때만 현재 실행중인 작업이 없음을 검증한다.
                () -> assertFalse(systemUnderTest.hasJobToRun())
        );
    }

    @Test
    void testJobToRun() {
        //현재 아키텍처가 사전에 가정한 환경인지 검증한다.
        assumeTrue(environment.isAmd64Architecture());
        //아키텍처가 AMD64인 경우에만 시스템에서 새로운 작업을 수행한다.
        systemUnderTest.run(new Job("Job 1"));
        //그리고 시스템에 실행할 작업이 있는지 검증한다.
        assertTrue(systemUnderTest.hasJobToRun());
    }
}
