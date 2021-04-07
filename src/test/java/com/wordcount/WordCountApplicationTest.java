package com.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class WordCountApplicationTest {

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setup() {
        byteArrayOutputStream = new ByteArrayOutputStream();
    }

    @Test
    public void main_smokeTest() {
        System.setOut(new PrintStream(byteArrayOutputStream));
        ByteArrayInputStream input = new ByteArrayInputStream("Mary had a little lamb".getBytes(StandardCharsets.UTF_8));
        System.setIn(input);
        WordCountApplication.main(new String[]{});

        String result = byteArrayOutputStream.toString();
        String expected = "Enter text: " + System.lineSeparator() + "Number of words: " + 4 + ", unique: " + 4 + System.lineSeparator();
        Assertions.assertEquals(expected, result);
    }

}