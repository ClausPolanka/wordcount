package com.wordcount.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class StopwordReaderTest {

    StopwordReaderImpl stopwordReaderImpl;

    @BeforeEach
    public void setup() {
        stopwordReaderImpl = new StopwordReaderImpl();
    }

    @Test
    void test_readStopwords() {
        List<String> stopwords = stopwordReaderImpl.readStopwords();
        Assertions.assertEquals(4, stopwords.size());
    }

}