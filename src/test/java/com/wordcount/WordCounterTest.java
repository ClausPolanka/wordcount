package com.wordcount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private final WordCounter counter = new WordCounter();

    @ParameterizedTest
    @CsvSource(value = {
            "word word;2",
            "              word              word                        word                           ;3",
            "wo3d;0",
            "wo$d;0",
            "word, word? word. word;1",
            "NIL;0"
    }, nullValues = "NIL", delimiter = ';')
    public void thatWorkCounterCanCountCorrectly(String text, int expectedCount) {
        assertEquals(counter.countWords(text), expectedCount);
    }
}