package com.study.junit.ch02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParameterizedWithCsvSourceTest {
    private WordCounter wordCounter = new WordCounter();

    @ParameterizedTest
    @CsvSource({"2, Unit testing", "3, JUnit int Action", "4, Write solid Java code"})
    void testWordsInSentence(int expected, String sentence) {
        Assertions.assertEquals(expected, wordCounter.countWords(sentence));
    }
}
