package com.oscerba.george.processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordProcessorTest {

    @Test
    public void testWordCount() {
        String[] words = {"ahoj"};

        long countActual = new WordProcessor(words).getCount();

        Assertions.assertEquals(1, countActual);
    }

    @Test
    public void testWordCountWithInvalidCharacters() {
        String[] words = {"ahoj2", "Ahoj?"};

        long countActual = new WordProcessor(words).getCount();

        Assertions.assertEquals(0, countActual);
    }
}
