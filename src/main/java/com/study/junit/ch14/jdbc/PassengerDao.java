package com.study.junit.ch14.jdbc;

import com.study.junit.ch14.Passenger;

public interface PassengerDao {
    public void insert(Passenger passenger) throws PassengerExistsException;
    public void update(String id, String name);
    public void delete(Passenger passenger);
    public Passenger getById(String id);
}