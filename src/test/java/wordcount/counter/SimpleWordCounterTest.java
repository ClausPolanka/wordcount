package wordcount.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wordcount.counter.delimiter.RegexSentenceSplitter;
import wordcount.counter.delimiter.SentenceSplitter;
import wordcount.counter.matcher.RegexWordMatcher;
import wordcount.counter.matcher.WordMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SimpleWordCounterTest {

    @Test
    void countWordsDefaultPatternNullList() {
        testWordCountCalculation(null, 0);
    }

    @Test
    void countWordsDefaultPatternEmptyList() {
        testWordCountCalculation(new ArrayList<>(), 0);
    }

    @Test
    void countWordsDefaultPatternEmptyString() {
        testWordCountCalculation(Collections.singletonList("        "), 0);
    }

    @Test
    void countWordsDefaultPatternNotEmptyString() {
        testWordCountCalculation(Collections.singletonList("Today  it's a     nice weather!"), 3);
    }

    @Test
    void countWordsCustomPatternNotEmptyString() {
        //arrange
        WordMatcher wordMatcher = new RegexWordMatcher("[a-z]+");
        SentenceSplitter sentenceSplitter = new RegexSentenceSplitter("\\.+");
        SimpleWordCounter simpleWordCounter = new SimpleWordCounter(sentenceSplitter, wordMatcher);
        String inputString = "Today.it's.a.nice.weather!";

        //act
        int actualCount = simpleWordCounter.countWords(Collections.singletonList(inputString));

        //assert
        Assertions.assertEquals(2, actualCount);
    }


    private void testWordCountCalculation(List<String> inputSentences, int expectedCount) {
        //arrange
        SimpleWordCounter simpleWordCounter = new SimpleWordCounter();

        //act
        int actualCount = simpleWordCounter.countWords(inputSentences);

        //assert
        Assertions.assertEquals(expectedCount, actualCount);
    }


}
