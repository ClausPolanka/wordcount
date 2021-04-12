package com.ableneo.erste.wordcount.cli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CliParserTest {

    private final CliParser cliParser = new CliParser();

    @Test
    void noArguments() {
        CliParameters parameters = cliParser.parse(new String[] {});
        assertFalse(parameters.isPrintIndex());
        assertFalse(parameters.isFileBasedInput());
    }

    @Test
    void containsFile() {
        CliParameters parameters = cliParser.parse(new String[] {"file.txt"});
        assertFalse(parameters.isPrintIndex());
        assertTrue(parameters.isFileBasedInput());
        assertEquals("file.txt", parameters.getFileName());
    }

    @Test
    void containsIndex() {
        CliParameters parameters = cliParser.parse(new String[] {"-index"});
        assertTrue(parameters.isPrintIndex());
        assertFalse(parameters.isFileBasedInput());
    }

    @Test
    void containsFileAndIndex() {
        CliParameters parameters = cliParser.parse(new String[] {"-index", "file.txt"});
        assertTrue(parameters.isPrintIndex());
        assertTrue(parameters.isFileBasedInput());
        assertEquals("file.txt", parameters.getFileName());
    }
}
