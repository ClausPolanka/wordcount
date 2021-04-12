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

    @Test
    void shouldReturnOneOnSingleWord() {
        int count = wordCounter.count("hello");
        assertEquals(1, count);
    }

    @Test
    void shouldReturnTwoOnTwoWords() {
        int count = wordCounter.count("hello world");
        assertEquals(2, count);
    }

    @Test
    void shouldIgnoreWordsWithSpecialCharacters() {
        int count = wordCounter.count("word, word. word?");
        assertEquals(0, count);
    }

    @Test
    void shouldIgnoreWhitespaces() {
        int count = wordCounter.count("word word            word");
        assertEquals(3, count);
    }

    @Test
    void shouldIgnoreWhitespaceAtTheBeginningAndEnd() {
        int count = wordCounter.count("  word  ");
        assertEquals(1, count);
    }
}
