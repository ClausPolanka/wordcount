package com.oscerba.george.parser;

import com.oscerba.george.processor.WordProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WordPaserTest {

    @Test
    public void testParser() {
        List<String> words = new ArrayList<>();
        words.add("ahoj");
        words.add("cau");

        List<String> wordsActual = new WordParser().getWords("ahoj cau");

        Assertions.assertEquals(words, wordsActual);
    }
}
