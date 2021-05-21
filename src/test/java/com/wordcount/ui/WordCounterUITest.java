package com.wordcount.ui;

import com.wordcount.StopWordsReader;
import com.wordcount.WordCounter;
import org.junit.jupiter.api.Test;

import static com.wordcount.WordCounterResult.NUMBER_OF_WORDS;
import static com.wordcount.WordCounterResult.UNIQUE_WORDS;
import static com.wordcount.ui.UserInputFileTestFixtures.EXAMPLE_FILE_CONTENT;
import static com.wordcount.ui.WordCounterUI.INTRO_TEXT;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

class WordCounterUITest {

    @Test
    public void thatUICanShowExpectedOutputForManualInput() {
        String userInput = "abc abc";
        TestIOInterface testIOManualInterface = new TestIOInterface(userInput, InputType.MANUAL);
        WordCounterUI wordCounterUI = new WordCounterUI(new WordCounter(new StopWordsReader()), testIOManualInterface, testIOManualInterface);
        wordCounterUI.countWords();

        String expectedOutput = expectedUIManualOutput(userInput, 2, 1);
        String actualOutput = testIOManualInterface.getOutput();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void thatUICanShowExpectedOutputForFileInput() {
        TestIOInterface testIOFileInterface = new TestIOInterface(EXAMPLE_FILE_CONTENT, InputType.FILE);
        WordCounterUI wordCounterUI = new WordCounterUI(new WordCounter(new StopWordsReader()), testIOFileInterface, testIOFileInterface);
        wordCounterUI.countWords();

        String expectedOutput = expectedUIFileOutput(EXAMPLE_FILE_CONTENT, 4, 4);
        String actualOutput = testIOFileInterface.getOutput();
        assertEquals(expectedOutput, actualOutput);
    }

    @SuppressWarnings("SameParameterValue")
    private String expectedUIManualOutput(String userInput, int expectedAllCount, int expectedUniqueCount) {
        return format("%s%s\n%s %d%s %d\n", INTRO_TEXT, userInput, NUMBER_OF_WORDS, expectedAllCount, UNIQUE_WORDS, expectedUniqueCount);
    }

    @SuppressWarnings("SameParameterValue")
    private String expectedUIFileOutput(String userInput, int expectedAllCount, int expectedUniqueCount) {
        return format("%s\n%s %d%s %d\n", userInput, NUMBER_OF_WORDS, expectedAllCount, UNIQUE_WORDS, expectedUniqueCount);
    }
}