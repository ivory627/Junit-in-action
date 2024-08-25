package com.study.junit.ch08;

public class DefaultConfiguration implements Configuration {
    public DefaultConfiguration(String configurationName) {
    }

    @Override
    public String getSQL(String sqlString) {
        return null;
    }
}
