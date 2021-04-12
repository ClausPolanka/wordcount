package com.ableneo.erste.wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private WordCounter wordCounter = new WordCounter();

    @Test
    void shouldReturnZeroOnNullInput() {
        int count = wordCounter.count(null);
        assertEquals(0, count);
    }

    @Test
    void shouldReturnZeroOnBlankInput() {
        int count = wordCounter.count("");
        assertEquals(0, count);
    }

//    @Test
//    void shouldReturnZeroOnEmptyInput() {
//        int count = wordCounter.count(null);
//        assertEquals(0, count);
//    }
//
//    @Test
//    void shouldReturnZeroOnEmptyInput() {
//        int count = wordCounter.count(null);
//        assertEquals(0, count);
//    }
}
