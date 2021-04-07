package com.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class WordCountApplicationTest {

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setup() {
        byteArrayOutputStream = new ByteArrayOutputStream();
    }

    @Test
    public void main_smokeTest() {
        System.setOut(new PrintStream(byteArrayOutputStream));
        ByteArrayInputStream input = new ByteArrayInputStream("test".getBytes(StandardCharsets.UTF_8));
        System.setIn(input);
        WordCountApplication.main(new String[]{});

        String result = byteArrayOutputStream.toString();
        String expected = "Enter text: " + System.lineSeparator() + "Number of words: " + 1 + System.lineSeparator();
        Assertions.assertEquals(expected, result);
    }

}