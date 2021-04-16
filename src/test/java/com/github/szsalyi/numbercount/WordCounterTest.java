package com.github.szsalyi.numbercount;

import com.github.szsalyi.wordcount.numbercount.WordCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private WordCounter wordCounter;

    @BeforeEach
    private void init() {
        this.wordCounter = new WordCounter();
    }

    @Test
    public void givenSingleWord_whenWordCount_thenReturnOne() {
        List<String> singleWordList = Collections.singletonList("word");

        long count = wordCounter.count(singleWordList);

        assertEquals(count, 1L);
    }

    @Test
    public void givenMultipleValidWord_whenWordCount_thenReturnProperCount() {
        List<String> multiWordList = Arrays.asList("word", "otherWord", "word");

        long count = wordCounter.count(multiWordList);

        assertEquals(count, 3L);
    }

    @Test
    public void givenEmptyList_whenWordCount_thenReturnZero() {
        List<String> emptyWordList = Collections.emptyList();

        long count = wordCounter.count(emptyWordList);

        assertEquals(count, 0L);
    }

    @Test
    public void givenNull_whenWordCount_thenReturn() {
        long count = wordCounter.count(null);

        assertEquals(count, 0L);
    }

    @Test
    public void givenMultipleWordsContainingInvalidWord_whenWordCount_thenReturnProperCount() {
        List<String> multiWordList = Arrays.asList("word", "otherWord,", "word");

        long count = wordCounter.count(multiWordList);

        assertEquals(count, 2L);
    }
}
