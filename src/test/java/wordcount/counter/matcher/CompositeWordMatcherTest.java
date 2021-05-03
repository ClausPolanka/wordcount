package wordcount.counter.matcher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CompositeWordMatcherTest {

    @Test
    void isWordMatchWordMatches() {
        //arrange
        RegexWordMatcher regexWordMatcher = new RegexWordMatcher();
        StopWordsWordMatcher firstStopWordsWordMatcher = new StopWordsWordMatcher(Arrays.asList("one", "two", "three"), regexWordMatcher);
        StopWordsWordMatcher secondStopWordsWordMatcher =
                new StopWordsWordMatcher(Arrays.asList("five", "six", "seven"), regexWordMatcher);
        CompositeWordMatcher compositeWordMatcher = new CompositeWordMatcher(
                Arrays.asList(regexWordMatcher, firstStopWordsWordMatcher, secondStopWordsWordMatcher));
        String testWord = "four";

        //act
        boolean wordMatch = compositeWordMatcher.isWordMatch(testWord);

        //assert
        Assertions.assertTrue(wordMatch);
    }

    @Test
    void isWordMatchWordDoesNotMatchOneCondition() {
        //arrange
        RegexWordMatcher regexWordMatcher = new RegexWordMatcher();
        StopWordsWordMatcher firstStopWordsWordMatcher = new StopWordsWordMatcher(Arrays.asList("one", "two", "three"), regexWordMatcher);
        StopWordsWordMatcher secondStopWordsWordMatcher =
                new StopWordsWordMatcher(Arrays.asList("five", "six", "seven"), regexWordMatcher);
        CompositeWordMatcher compositeWordMatcher = new CompositeWordMatcher(
                Arrays.asList(regexWordMatcher, firstStopWordsWordMatcher, secondStopWordsWordMatcher));
        String testWord = "five";

        //act
        boolean wordMatch = compositeWordMatcher.isWordMatch(testWord);

        //assert
        Assertions.assertFalse(wordMatch);
    }

    @Test
    void isWordMatchWordDoesNotMatchTwoConditions() {
        //arrange
        RegexWordMatcher firstRegexWordMatcher = new RegexWordMatcher();
        RegexWordMatcher secondRegexWordMatcher = new RegexWordMatcher("[a-z]+");
        StopWordsWordMatcher secondStopWordsWordMatcher =
                new StopWordsWordMatcher(Arrays.asList("five", "six", "seven"), firstRegexWordMatcher);
        CompositeWordMatcher compositeWordMatcher = new CompositeWordMatcher(
                Arrays.asList(firstRegexWordMatcher, secondRegexWordMatcher, secondStopWordsWordMatcher));
        String testWord = "five5";

        //act
        boolean wordMatch = compositeWordMatcher.isWordMatch(testWord);

        //assert
        Assertions.assertFalse(wordMatch);
    }

}
