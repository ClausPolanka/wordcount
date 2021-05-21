package com.wordcount;

import org.junit.jupiter.api.Test;

import static com.wordcount.WordCounterResult.*;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

class WordCounterResultTest {

    @Test
    public void thatWordCountToStringIsFormattedCorrectly() {
        WordCounterResult result = new WordCounterResult(10, 5, 0.145);
        String expectedOutput = format("%s %d, %s %d; %s %.2f", NUMBER_OF_WORDS, result.getAllWordsCount(), UNIQUE_WORDS, result.getUniqueWordsCount(), AVERAGE_WORD, 0.15);
        assertEquals(expectedOutput, result.toString());
    }
}