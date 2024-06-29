package com.study.junit.ch04;

import com.study.junit.ch02.Customer;
import com.study.junit.ch02.CustomerRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("repository")
public class JUnit5CustomerRepositoryTest {
    private String CUSTOMER_NAME = "John Smith";
    private CustomerRepository repository = new CustomerRepository();

    @Test
    void testNonExistence() {
        boolean exists = repository.contains("John Smith");
        assertFalse(exists);
    }

    @Test
    void testCustomerPersistence() {
        repository.persist(new Customer(CUSTOMER_NAME));
        assertTrue(repository.contains("John Smith"));
    }
}
