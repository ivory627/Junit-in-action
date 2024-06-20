package com.study.junit.ch02;

import lombok.Data;


@Data
public class Job {
    private String name;

    public Job(String name) {
        this.name = name;
    }
}
