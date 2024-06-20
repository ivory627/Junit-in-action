package com.study.junit.ch02;

public class NoJobException extends RuntimeException {
    NoJobException(String message) {
        super(message);
    }
}
