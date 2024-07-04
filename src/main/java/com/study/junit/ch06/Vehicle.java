package com.study.junit.ch06;

public class Vehicle {
    Driver d;
    boolean hasDriver = true;

    Vehicle(Driver d) {
        this.d = d;
    }

    private void setHasDriver(boolean hasDriver) {
        this.hasDriver = hasDriver;
    }
}
