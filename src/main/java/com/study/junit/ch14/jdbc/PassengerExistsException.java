package com.study.junit.ch14.jdbc;

import com.study.junit.ch14.Passenger;

public class PassengerExistsException extends Exception{

    private Passenger passenger;

    public PassengerExistsException(Passenger passenger, String message) {
        super(message);
        this.passenger = passenger;
    }
}
