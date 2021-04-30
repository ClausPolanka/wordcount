package wordcount.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wordcount.counter.SimpleWordCounter;
import wordcount.counter.delimiter.RegexSentenceSplitter;
import wordcount.counter.delimiter.SentenceSplitter;
import wordcount.counter.matcher.RegexWordMatcher;
import wordcount.counter.matcher.WordMatcher;

class SimpleWordCounterTest {

    @Test
    void countWordsDefaultPatternNullString() {
        testWordCountCalculation(null, 0);
    }

    @Test
    void countWordsDefaultPatternEmptyString() {
        testWordCountCalculation("        ", 0);
    }

    @Test
    void countWordsDefaultPatternNotEmptyString() {
        testWordCountCalculation("Today  it's a     nice weather!", 3);
    }

    @Test
    void countWordsCustomPatternNotEmptyString() {
        //arrange
        WordMatcher wordMatcher = new RegexWordMatcher("[a-z]+");
        SentenceSplitter sentenceSplitter = new RegexSentenceSplitter("\\.+");
        SimpleWordCounter simpleWordCounter = new SimpleWordCounter(sentenceSplitter, wordMatcher);
        String inputString = "Today.it's.a.nice.weather!";

        //act
        int actualCount = simpleWordCounter.countWords(inputString);

        //assert
        Assertions.assertEquals(2, actualCount);
    }


    private void testWordCountCalculation(String inputString, int expectedCount) {
        //arrange
        SimpleWordCounter simpleWordCounter = new SimpleWordCounter();

        //act
        int actualCount = simpleWordCounter.countWords(inputString);

        //assert
        Assertions.assertEquals(expectedCount, actualCount);
    }


}
