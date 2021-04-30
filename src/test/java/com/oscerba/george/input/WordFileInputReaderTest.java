package com.oscerba.george.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class WordFileInputReaderTest {

    @Test
    public void testFileInputReaderReadsDataCorrectly() throws IOException {
        String wordsActual = new WordFileInputReader(Paths.get("src/test/resources/wordsTest.txt")).getWords();

        Assertions.assertEquals("Mary had a little lamb",wordsActual);
    }
}
