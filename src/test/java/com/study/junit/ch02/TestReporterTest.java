package com.study.junit.ch02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;
import java.util.Map;

public class TestReporterTest {

    @Test
    void testReportSingleValue(TestReporter reporter) {
        reporter.publishEntry("Single value");
    }

    @Test
    void testReportKeyValuePair(TestReporter reporter) {
        reporter.publishEntry("Key", "Value");
    }

    @Test
    void testReportMultipleKeyValuePairs(TestReporter reporter) {
        Map<String, String> values = new HashMap<>();
        values.put("user", "John");
        values.put("password", "secret");
        reporter.publishEntry(values);
    }


}
