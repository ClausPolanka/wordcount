package com.wordcount.ui;

import com.wordcount.StopWordsReader;
import com.wordcount.WordCounter;
import org.junit.jupiter.api.Test;

import static com.wordcount.ui.WordCounterUI.INTRO_TEXT;
import static com.wordcount.ui.WordCounterUI.RESULT_TEXT;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

class WordCounterUITest {

    @Test
    public void thatUICanShowExpectedOutput() {
        String userInput = "abc abc";
        TestIOInterface testIOInterface = new TestIOInterface(userInput);
        WordCounterUI wordCounterUI = new WordCounterUI(new WordCounter(new StopWordsReader()), testIOInterface, testIOInterface);
        wordCounterUI.countWords();

        String expectedOutput = expectedUIOutput(userInput, 2);
        String actualOutput = testIOInterface.getOutput();
        assertEquals(expectedOutput, actualOutput);
    }

    @SuppressWarnings("SameParameterValue")
    private String expectedUIOutput(String userInput, int expectedCount) {
        return format("%s%s\n%s%d\n", INTRO_TEXT, userInput, RESULT_TEXT, expectedCount);
    }
}