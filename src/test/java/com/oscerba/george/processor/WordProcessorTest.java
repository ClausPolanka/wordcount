package com.oscerba.george.processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordProcessorTest {

    @Test
    public void testWordCount() {
        long countActual = new WordProcessor(Collections.singletonList("ahoj"), new ArrayList<>()).getStatistics().getCount();

        Assertions.assertEquals(1, countActual);
    }

    @Test
    public void testWordCountWithInvalidCharacters() {
        List<String> words = new ArrayList<>();
        words.add("ahoj2");
        words.add("Ahoj?");

        long countActual = new WordProcessor(words, new ArrayList<>()).getStatistics().getCount();

        Assertions.assertEquals(0, countActual);
    }

    @Test
    public void testWordCountUnique() {
        List<String> words = new ArrayList<>();
        words.add("ahoj");
        words.add("ahoj");

        long countActual = new WordProcessor(words, new ArrayList<>()).getStatistics().getUniqueCount();

        Assertions.assertEquals(1, countActual);
    }

    @Test
    public void testWordCountIncludedInStopWords() {
        List<String> words = Collections.singletonList("on");
        List<String> stopWords = Collections.singletonList("on");

        long countActual = new WordProcessor(words, stopWords).getStatistics().getCount();

        Assertions.assertEquals(0, countActual);
    }
}
