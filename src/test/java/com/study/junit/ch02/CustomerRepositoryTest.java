package com.study.junit.ch02;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Tag("repository")
public class CustomerRepositoryTest {
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
