package com.oscerba.george.processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordProcessorTest {

    @Test
    public void testWordCount() {
        String[] words = {"ahoj"};

        long countActual = new WordProcessor(words, new ArrayList<>()).getCount();

        Assertions.assertEquals(1, countActual);
    }

    @Test
    public void testWordCountWithInvalidCharacters() {
        String[] words = {"ahoj2", "Ahoj?"};

        long countActual = new WordProcessor(words, new ArrayList<>()).getCount();

        Assertions.assertEquals(0, countActual);
    }

    @Test
    public void testWordCountIncludedInStopWords() {
        String[] words = {"on"};
        List<String> stopWords = Collections.singletonList("on");

        long countActual = new WordProcessor(words, stopWords).getCount();

        Assertions.assertEquals(0, countActual);
    }
}
