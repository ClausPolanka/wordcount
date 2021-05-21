package com.wordcount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private final WordCounter counter = new WordCounter(new StopWordsReader());

    @ParameterizedTest
    @CsvSource(value = {
            "word word;2",
            "              word              word                        word                           ;3",
            "wo3d;0",
            "wo$d;0",
            "word, word? word. word;1",
            "NIL;0"
    }, nullValues = "NIL", delimiter = ';')
    public void thatWordsWithNonAlphabeticalCharactersAndNullsAreNotCounted(String text, int expectedCount) {
        assertEquals(counter.countWords(text), expectedCount);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "word the;1",
            "word the a on off an;2",
            "word;1"
    }, nullValues = "NIL", delimiter = ';')
    public void thatStopWordsAreNotCounted(String text, int expectedCount) {
        assertEquals(counter.countWords(text), expectedCount);
    }
}