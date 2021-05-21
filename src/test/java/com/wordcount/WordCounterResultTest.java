package com.wordcount;

import org.junit.jupiter.api.Test;

import static com.wordcount.WordCounterResult.*;
import static com.wordcount.ui.UserInputFileTestFixtures.exampleFileUniqueWords;
import static java.lang.String.format;
import static java.util.Collections.singleton;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterResultTest {

    @Test
    public void thatWordCountResultIsPrintedCorrectly() {
        WordCounterResult result = new WordCounterResult(10, singleton("abc"), 0.145);
        String expectedOutput = format("%s %d, %s %d; %s %.2f", NUMBER_OF_WORDS, 10, UNIQUE_WORDS, 1, AVERAGE_WORD, 0.15);
        assertEquals(expectedOutput, result.printStats());
    }

    @Test
    public void thatWordCountResultCanPrintIndex() {
        WordCounterResult result = new WordCounterResult(10, exampleFileUniqueWords(), 0.145);
        String expectedOutput = format("%s\n%s\n%s\n%s\n%s", INDEX, "had", "lamb", "little", "Mary");
        assertEquals(expectedOutput, result.printIndex());
    }
}