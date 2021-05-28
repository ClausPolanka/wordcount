package com.erste.service;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountManagerTest {
    WordCountManager wordCountManager = new WordCountManager();

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"apple|1", "a|1", "pear|1"})
    public void testForSingleValidInput(String singleInput, Integer expectedValue) {
        Integer wordCount = wordCountManager.countWords(singleInput);
        assertEquals(wordCount, expectedValue);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"app2le|0", ",|0", " |0", "5465465|0"})
    public void testForSingleInvalidInput(String singleInvalidInput, Integer expectedValue) {
        Integer wordCount = wordCountManager.countWords(singleInvalidInput);
        assertEquals(wordCount, expectedValue);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"apple apple|2", "app3le pear|1", "apple3     333 222|0", "   apple !apple apple3 pear|2"})
    public void testForMultipleWordInputs(String input, Integer expectedValue) {
        Integer wordCount = wordCountManager.countWords(input);
        assertEquals(wordCount, expectedValue);
    }

}
