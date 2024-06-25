package com.study.junit.ch02;

public class WordCounter {
    public int countWords(String sentence) {
        return sentence.split(" ").length;
    }
}