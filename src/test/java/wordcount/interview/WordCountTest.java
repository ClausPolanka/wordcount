package wordcount.interview;

import org.junit.jupiter.api.Test;
import wordcount.interview.mock.InputMock;
import wordcount.interview.mock.OutputMock;
import wordcount.interview.mock.WordCounterMock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WordCountTest {
    private static final String EMPTY = "";
    private static final String EXPECTED_ENTER_TEXT = "Enter text:";
    private static final String INPUT_TEXT = "inputText";
    private static final long EXPECTED_COUNT = 10l;
    private static final String EXPECTED_NUMBER_OF_WORDS = "Number of words: ";
    private InputMock input;
    private OutputMock output;
    private WordCounterMock wordCounter;
    private WordCount sut;

    @Test
    void shouldWriteCorrectEnterTextLineToOutput() {
        createSut(EMPTY, EXPECTED_COUNT);

        sut.run();

        List<String> outputText = output.getOutputTexts();
        assertEquals(EXPECTED_ENTER_TEXT, outputText.get(0));
    }

    @Test
    void shouldCallWordCounterCountOnInputText() {
        createSut(INPUT_TEXT, EXPECTED_COUNT);

        sut.run();

        String textToCount = wordCounter.getTextToCount();
        assertEquals(INPUT_TEXT, textToCount);
    }

    @Test
    void shouldWriteCountedWordsToOutput() {
        createSut(EMPTY, EXPECTED_COUNT);

        sut.run();

        List<String> outputText = output.getOutputTexts();
        assertEquals(EXPECTED_NUMBER_OF_WORDS + EXPECTED_COUNT, outputText.get(1));
    }

    private void createSut(String inputText, long expectedCount) {
        input = new InputMock(inputText);
        output = new OutputMock();
        wordCounter = new WordCounterMock(expectedCount);
        sut = new WordCount(input, output, wordCounter);
    }
}