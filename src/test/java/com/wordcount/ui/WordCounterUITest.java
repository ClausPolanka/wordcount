package com.wordcount.ui;

import com.wordcount.StopWordsReader;
import com.wordcount.WordCounter;
import com.wordcount.WordCounterResult;
import org.junit.jupiter.api.Test;

import static com.wordcount.ui.UserInputFileTestFixtures.EXAMPLE_FILE_CONTENT;
import static com.wordcount.ui.UserInputFileTestFixtures.exampleFileUniqueWords;
import static com.wordcount.ui.WordCounterUI.INTRO_TEXT;
import static java.lang.String.format;
import static java.util.Collections.singleton;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterUITest {

    @Test
    public void thatUICanShowExpectedOutputForManualInput() {
        String userInput = "abc abc";
        TestIOInterface testIOManualInterface = new TestIOInterface(userInput, InputType.MANUAL);
        WordCounterUI wordCounterUI = new WordCounterUI(new WordCounter(new StopWordsReader()), testIOManualInterface, testIOManualInterface);
        wordCounterUI.countWords();

        String expectedOutput = expectedUIManualOutput(userInput, WordCounterResult.of(2, singleton("abc"), 3d));
        String actualOutput = testIOManualInterface.getOutput();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void thatUICanShowExpectedOutputForFileInput() {
        TestIOInterface testIOFileInterface = new TestIOInterface(EXAMPLE_FILE_CONTENT, InputType.FILE);
        WordCounterUI wordCounterUI = new WordCounterUI(new WordCounter(new StopWordsReader()), testIOFileInterface, testIOFileInterface);
        wordCounterUI.countWords();

        String expectedOutput = expectedUIFileOutput(EXAMPLE_FILE_CONTENT, WordCounterResult.of(4, exampleFileUniqueWords(), 4.25d));
        String actualOutput = testIOFileInterface.getOutput();
        assertEquals(expectedOutput, actualOutput);
    }

    @SuppressWarnings("SameParameterValue")
    private String expectedUIManualOutput(String userInput, WordCounterResult result) {
        return format("%s%s\n%s\n", INTRO_TEXT, userInput, result.printStats());
    }

    @SuppressWarnings("SameParameterValue")
    private String expectedUIFileOutput(String userInput, WordCounterResult result) {
        return format("%s\n%s\n", userInput, result.printStats());
    }
}