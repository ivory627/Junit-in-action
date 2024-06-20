package com.study.junit.ch02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NestedTestsTest { //메인 테스트

    //모든 중첩 테스트에 사용할 고객의 이름과 성을 선언
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Smith";

    @Nested
    class BuilderTest { //중첩 테스트

        private String MIDDLE_NAME = "Michael";

        @Test
        void customerBuilder() throws ParseException { //빌더 패턴을 활용하여 Customer객체를 제대로 생성했는지 검증
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate customerDate = LocalDate.parse( "04-21-2019", dateFormatter);

            Customer customer =  new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME)
                    .withMiddleName(MIDDLE_NAME)
                    .withBecomeCustomer(customerDate)
                    .build();

            assertAll(() -> {
                assertEquals(Gender.MALE, customer.getGender());
                assertEquals(FIRST_NAME, customer.getFirstName());
                assertEquals(LAST_NAME, customer.getLastName());
                assertEquals(MIDDLE_NAME, customer.getMiddleName());
                assertEquals(customerDate, customer.getBecomeCustomer());
            });
        }

    }

}
