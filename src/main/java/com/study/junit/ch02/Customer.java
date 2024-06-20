package com.study.junit.ch02;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Customer {
    private Gender gender;
    private String firstName;
    private String lastName;

    private String middleName;
    private LocalDate becomeCustomer;

    private String name;

    Customer(String name) {
        this.name = name;
    }

    public static class Builder {
        private Gender gender;
        private String lastName;
        private String firstName;

        private String middleName;
        private LocalDate becomeCustomer;

        public Builder(Gender gender, String firstName, String lastName) {
            this.gender = gender;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }


        public Builder withBecomeCustomer(LocalDate becomeCustomer) {
            this.becomeCustomer = becomeCustomer;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    private Customer(Builder builder) {
        this.gender = builder.gender;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.becomeCustomer = builder.becomeCustomer;
    }

}