package com.study.junit.ch02;

import com.study.junit.ch01.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestReporter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedTestsTest {

    private static Set<Integer> integerSet = new HashSet<>();
    private static List<Integer> integerList = new ArrayList<>();

    @RepeatedTest(value = 5, name = "{displayName} - repetition {currentRepetition}/{totalRepetitions}")
    @DisplayName("Test add operation")
    void addNumber() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1,1), "1+1 should equal 2");
    }

    @RepeatedTest(value = 5,
    name = "the list contains {currentRepetition} elements(s), the set contains 1 element")
    void testAddingToCollections(TestReporter reporter, RepetitionInfo repetitionInfo) {
        integerSet.add(1);
        integerList.add(repetitionInfo.getCurrentRepetition());

        reporter.publishEntry("Repetition number", String.valueOf(repetitionInfo.getCurrentRepetition()));

        assertEquals(1, integerSet.size());
        assertEquals(repetitionInfo.getCurrentRepetition(), integerList.size());
    }
}
