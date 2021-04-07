package com.wordcount.io;

import com.wordcount.filter.StopwordFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class InputOutputHelperTest {

    InputOutputHelper inputOutputHelper;

    @BeforeEach
    public void setup() {
        inputOutputHelper = new InputOutputHelper();
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
    void test_readFromFile() {
        String filename = "noExistingFile.txt";
        String result = inputOutputHelper.readFromFile("noExistingFile.txt");
        Assertions.assertEquals("File not found: " + filename, result);
    }

}