package sk.sloboda.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.sloboda.wordcount.common.ArgumentHelper;
import sk.sloboda.wordcount.common.WordCounter;
import sk.sloboda.wordcount.common.WordCounterImpl;
import sk.sloboda.wordcount.model.WordCount;
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
        WordCount result = counter.countWords(testSentence);
        Assertions.assertEquals( 4, result.getCount());
        Assertions.assertEquals( 4, result.getUniqueCount());
        Assertions.assertEquals( 4.25, result.getAverageLength());
    }

    @Test
    public void testCorrectInputWithDotAtTheEnd() {
        String testSentence = "Mary had a little lamb.";
        WordCount result = counter.countWords(testSentence);
        Assertions.assertEquals( 4, result.getCount());
        Assertions.assertEquals( 4, result.getUniqueCount());
        Assertions.assertEquals( 4.25, result.getAverageLength());
    }

    @Test
    public void testInputWithNumbers() {
        String testSentence = "This is the sentence    for test with the     number 123 which should not be counted as     word java18 also should not count";
        WordCount result = counter.countWords(testSentence);
        Assertions.assertEquals( 18, result.getCount());
        Assertions.assertEquals( 16, result.getUniqueCount());
        Assertions.assertEquals( 4.33, result.getAverageLength());
    }

    @Test
    public void testNullInput() {
        WordCount result = counter.countWords(null);
        Assertions.assertEquals( 0, result.getCount());
        Assertions.assertEquals( 0, result.getUniqueCount());
        Assertions.assertEquals( 0.0, result.getAverageLength());
    }

    @Test
    public void testSentenceWithOnlyStopWords() {
        String testSentence = "The off a A ON";
        WordCount result = counter.countWords(testSentence);
        Assertions.assertEquals( 0, result.getCount());
        Assertions.assertEquals( 0, result.getUniqueCount());
        Assertions.assertEquals( 0.0, result.getAverageLength());
    }

    @Test
    public void testCountWordsFromFile() {
        Assertions.assertTrue(argumentHelper.isFileNameEntered("mytext.txt"));
        WordCount result =  counter.countWords(argumentHelper.loadTextFromFile());
        Assertions.assertEquals(4, result.getCount());
        Assertions.assertEquals(4, result.getUniqueCount());
    }

    @Test
    public void testUniqueWords() {
        String testSentence = "Lorem ipsum dolor sit amet consectetur adipiscing elit ipsum sit amet";
        WordCount result =  counter.countWords(testSentence);
        Assertions.assertEquals(11, result.getCount());
        Assertions.assertEquals(8, result.getUniqueCount());
        Assertions.assertEquals( 5.36, result.getAverageLength());
    }

    @Test
    public void testWordWithDash() {
        String testSentence = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        WordCount result = counter.countWords(testSentence);
        Assertions.assertEquals(7, result.getCount());
        Assertions.assertEquals(6, result.getUniqueCount());
        Assertions.assertEquals( 6.43, result.getAverageLength());
    }
}
