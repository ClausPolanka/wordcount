package com.ableneo.erste.wordcount.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopWordsFilterTest {

    private StopWordsFilter stopWordsFilter = new StopWordsFilter("stopwords.txt");

    @Test
    void returnTrueIfStopWord() {
        assertEquals(true, stopWordsFilter.isStopWord("the"));
    }

    @Test
    void returnFalseIfStopWord() {
        assertEquals(false, stopWordsFilter.isStopWord("hello"));
    }
}
