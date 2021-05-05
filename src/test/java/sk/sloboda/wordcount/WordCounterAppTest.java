package sk.sloboda.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.sloboda.wordcount.common.ArgumentHelper;
import sk.sloboda.wordcount.common.WordCounter;
import sk.sloboda.wordcount.common.WordCounterImpl;
import sk.sloboda.wordcount.validator.WordValidator;
import sk.sloboda.wordcount.validator.WordValidatorImpl;

public class WordCounterAppTest {

    private static WordValidator validator;
    private static WordCounter counter;
    private static ArgumentHelper argumentHelper;

    @BeforeAll
    public static void init() {
        validator = new WordValidatorImpl();
        counter = new WordCounterImpl(validator);
        argumentHelper = new ArgumentHelper();
    }

    @Test
    public void testCorrectInput() {
        String testSentence = "Mary had a little lamb";
        Assertions.assertEquals( 4, counter.countWords(testSentence));
    }

    @Test
    public void testCorrectInputWithDotAtTheEnd() {
        String testSentence = "Mary had a little lamb.";
        Assertions.assertEquals( 4, counter.countWords(testSentence));
    }

    @Test
    public void testInputWithNumbers() {
        String testSentence = "This is the sentence    for test with the     number 123 which should not be counted as     word java18 also should not count";
        Assertions.assertEquals( 18, counter.countWords(testSentence));
    }

    @Test
    public void testNullInput() {
        Assertions.assertEquals( 0, counter.countWords(null));
    }

    @Test
    public void testSentenceWithOnlyStopWords() {
        String testSentence = "The off a A ON";
        Assertions.assertEquals( 0, counter.countWords(testSentence));
    }

    @Test
    public void testCountWordsFromFile() {
        Assertions.assertTrue(argumentHelper.isFileNameEntered("mytext.txt"));
        Assertions.assertEquals(4, counter.countWords(argumentHelper.loadTextFromFile()));
    }
}
