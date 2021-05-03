package wordcount.counter.matcher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StopWordsWordMatcherTest {

    @Test
    void isWordMatchStopWordsNotMatchingRegex() {
        //arrange
        List<String> stopWords = Arrays.asList("one", "two", "three3");
        RegexWordMatcher regexWordMatcher = new RegexWordMatcher();

        //act & assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new StopWordsWordMatcher(stopWords, regexWordMatcher));
    }

    @Test
    void isWordMatchWordDoesNotMatch() {
        //arrange
        List<String> stopWords = Arrays.asList("one", "two", "three");
        StopWordsWordMatcher stopWordsWordMatcher = new StopWordsWordMatcher(stopWords,  new RegexWordMatcher());
        String testWord = "two";

        //act
        boolean wordMatch = stopWordsWordMatcher.isWordMatch(testWord);

        //assert
        Assertions.assertFalse(wordMatch);
    }

    @Test
    void isWordMatchWordMatches() {
        //arrange
        List<String> stopWords = Arrays.asList("one", "two", "three");
        StopWordsWordMatcher stopWordsWordMatcher = new StopWordsWordMatcher(stopWords,  new RegexWordMatcher());
        String testWord = "four4";

        //act
        boolean wordMatch = stopWordsWordMatcher.isWordMatch(testWord);

        //assert
        Assertions.assertTrue(wordMatch);
    }

}
