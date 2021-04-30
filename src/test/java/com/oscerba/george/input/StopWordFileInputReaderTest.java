package com.oscerba.george.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StopWordFileInputReaderTest {

    @Test
    public void testFileInputReaderReadsDataCorrectly() throws IOException {
        List<String> wordsActual = new StopWordFileInputReader(Paths.get("src/test/resources/stopWordsTest.txt")).getStopWords();
        List<String> words = new ArrayList<>();
        words.add("no");
        words.add("a");
        words.add("and");

        Assertions.assertEquals(words, wordsActual);
    }
}
