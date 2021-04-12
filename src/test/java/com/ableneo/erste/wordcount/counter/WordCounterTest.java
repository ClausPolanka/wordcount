package com.ableneo.erste.wordcount.counter;

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
        CounterResult result = wordCounter.count(null);
        assertEquals(0, result.getTotal());
    }

    @Test
    void shouldReturnZeroOnBlankInput() {
        CounterResult result = wordCounter.count(stringToInputStream(""));
        assertEquals(0, result.getTotal());
    }

    @Test
    void shouldReturnOneOnSingleWord() {
        CounterResult result = wordCounter.count(stringToInputStream("hello"));
        assertEquals(1, result.getTotal());
    }

    @Test
    void shouldReturnTwoOnTwoWords() {
        CounterResult result = wordCounter.count(stringToInputStream("hello world"));
        assertEquals(2, result.getTotal());
    }

    @Test
    void shouldIgnoreWordsWithSpecialCharacters() {
        CounterResult result = wordCounter.count(stringToInputStream("word, word. word?"));
        assertEquals(1, result.getTotal());
    }

    @Test
    void shouldIgnoreWhitespaces() {
        CounterResult result = wordCounter.count(stringToInputStream("word word            word"));
        assertEquals(3, result.getTotal());
    }

    @Test
    void shouldIgnoreWhitespaceAtTheBeginningAndEnd() {
        CounterResult result = wordCounter.count(stringToInputStream("  word  "));
        assertEquals(1, result.getTotal());
    }

    @Test
    void shouldIgnoreStopWords() {
        CounterResult result = wordCounter.count(stringToInputStream("the word"));
        assertEquals(1, result.getTotal());
    }

    @Test
    void shouldIgnoreRepeatingWords() {
        CounterResult result = wordCounter.count(stringToInputStream("hello hello word"));
        assertEquals(2, result.getUnique());
    }

    @Test
    void hyphenAsOneWord() {
        CounterResult result = wordCounter.count(stringToInputStream("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
        assertEquals(7, result.getTotal());
        assertEquals(6, result.getUnique());
    }

    @Test
    void countAverageWordLength() {
        CounterResult result = wordCounter.count(stringToInputStream("hell world"));
        assertEquals(4.5, result.getAverageWordLength());
    }

    private InputStream stringToInputStream(String string) {
        return new ByteArrayInputStream(string.getBytes());
    }
}
