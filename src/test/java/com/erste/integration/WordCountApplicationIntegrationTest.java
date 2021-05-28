package com.erste.integration;

import com.erste.WordCounterApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordCountApplicationIntegrationTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testWordCounterApplicationWithStopWords() {
        String input = "Mary had a little lamb";
        String expectedMessage = "Number of words: 4";
        provideInput(input);
        WordCounterApplication.main(new String[0]);
        assertTrue(getOutput().contains(expectedMessage));
    }

    @Test
    public void testWordCounterApplicationWithoutStopWords() {
        String input = "Mary has many little lambs";
        String expectedMessage = "Number of words: 5";
        provideInput(input);
        WordCounterApplication.main(new String[0]);
        assertTrue(getOutput().contains(expectedMessage));
    }

}
