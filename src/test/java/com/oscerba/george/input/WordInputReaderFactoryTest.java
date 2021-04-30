package com.oscerba.george.input;

import com.oscerba.george.parser.WordParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordInputReaderFactoryTest {

    @Test
    public void testFileInputReaderIsReturnedCorrectly() {
        WordInputReader wordInputReader = new WordInputReaderFactory().getWordInputReader(Paths.get(""));

        Assertions.assertTrue(wordInputReader instanceof WordFileInputReader);
    }

    @Test
    public void testConsoleInputReaderIsReturnedCorrectly() {
        WordInputReader wordInputReader = new WordInputReaderFactory().getWordInputReader(null);

        Assertions.assertTrue(wordInputReader instanceof WordConsoleInputReader);
    }
}
