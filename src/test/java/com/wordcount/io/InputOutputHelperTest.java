package com.wordcount.io;

import com.wordcount.dto.CounterDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class InputOutputHelperTest {

    InputOutputHelper inputOutputHelper;
    PrintStream standardOut;
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        inputOutputHelper = new InputOutputHelper();
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();

    }

    @Test
    void test_read_commandline() {
        String inputText = "Mary had a little lamb";
        ByteArrayInputStream input = new ByteArrayInputStream(inputText.getBytes(StandardCharsets.UTF_8));
        System.setIn(input);

        String result = inputOutputHelper.read(new String[]{});
        Assertions.assertEquals(inputText, result);
    }

    @Test
    void test_read_file() {
        String result = inputOutputHelper.read(new String[]{"testFile.txt"});
        Assertions.assertEquals("Mary had a little lamb", result);
    }


    @Test
    void test_write() {
        long numberOfWords = 9L;
        long numberOfUniqueWords = 7L;

        CounterDto counterDto = new CounterDto(numberOfWords, numberOfUniqueWords);

        System.setOut(new PrintStream(outputStreamCaptor));
        inputOutputHelper.write(counterDto);
        Assertions.assertEquals("Number of words: " + numberOfWords + ", unique: " + numberOfUniqueWords, outputStreamCaptor.toString().trim());
    }

}