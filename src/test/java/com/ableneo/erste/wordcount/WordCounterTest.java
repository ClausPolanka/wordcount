package com.ableneo.erste.wordcount;

import com.ableneo.erste.wordcount.filter.StopWordsFilter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private final StopWordsFilter stopWordsFilter = new StopWordsFilter("stopwords.txt");
    private final WordCounter wordCounter = new WordCounter(stopWordsFilter);

    @Test
    void shouldReturnZeroOnNullInput() {
        int count = wordCounter.count(null);
        assertEquals(0, count);
    }

    @Test
    void shouldReturnZeroOnBlankInput() {
        int count = wordCounter.count(stringToInputStream(""));
        assertEquals(0, count);
    }

    @Test
    void shouldReturnOneOnSingleWord() {
        int count = wordCounter.count(stringToInputStream("hello"));
        assertEquals(1, count);
    }

    @Test
    void shouldReturnTwoOnTwoWords() {
        int count = wordCounter.count(stringToInputStream("hello world"));
        assertEquals(2, count);
    }

    @Test
    void shouldIgnoreWordsWithSpecialCharacters() {
        int count = wordCounter.count(stringToInputStream("word, word. word?"));
        assertEquals(0, count);
    }

    @Test
    void shouldIgnoreWhitespaces() {
        int count = wordCounter.count(stringToInputStream("word word            word"));
        assertEquals(3, count);
    }

    @Test
    void shouldIgnoreWhitespaceAtTheBeginningAndEnd() {
        int count = wordCounter.count(stringToInputStream("  word  "));
        assertEquals(1, count);
    }

    @Test
    void shouldIgnoreStopWords() {
        int count = wordCounter.count(stringToInputStream("the word"));
        assertEquals(1, count);
    }

    private InputStream stringToInputStream(String string) {
        return new ByteArrayInputStream(string.getBytes());
    }
}
