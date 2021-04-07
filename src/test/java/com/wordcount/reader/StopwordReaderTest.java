package com.wordcount.reader;

import com.wordcount.counter.Counter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StopwordReaderTest {

    StopwordReader stopwordReader;

    @BeforeEach
    public void setup() {
        stopwordReader = new StopwordReader();
    }

    @Test
    void test_readStopwords() {
        List<String> stopwords = stopwordReader.readStopwords();
        Assertions.assertEquals(4, stopwords.size());
    }

}