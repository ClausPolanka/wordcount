package wordcount.counter.matcher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.PatternSyntaxException;

class RegexWordMatcherTest {

    @Test
    void isWordMatchNokDefaultPattern() {
        //arrange
        String word = "Hello!";
        RegexWordMatcher regexWordMatcher = new RegexWordMatcher();

        //act
        boolean wordMatched = regexWordMatcher.isWordMatch(word);

        //assert
        Assertions.assertFalse(wordMatched);
    }

    @Test
    void isWordMatchOkDefaultPattern() {
        //arrange
        String word = "Hello";
        RegexWordMatcher regexWordMatcher = new RegexWordMatcher();

        //act
        boolean wordMatched = regexWordMatcher.isWordMatch(word);

        //assert
        Assertions.assertTrue(wordMatched);
    }

    @Test
    void isWordMatchOkCustomPattern() {
        //arrange
        String word = "HELLO";
        String customPattern = "[a-z]+";
        RegexWordMatcher regexWordMatcher = new RegexWordMatcher(customPattern);

        //act
        boolean wordMatched = regexWordMatcher.isWordMatch(word);

        //assert
        Assertions.assertFalse(wordMatched);
    }



    @Test
    void isWordMatchNokNullValue() {
        //arrange
        RegexWordMatcher regexWordMatcher = new RegexWordMatcher();

        //act
        boolean wordMatched = regexWordMatcher.isWordMatch(null);

        //assert
        Assertions.assertFalse(wordMatched);
    }

    @Test
    void regexWordMatcherWithErrorPattern() {
        //arrange
        String errorPattern = "(";

        //act & assert
        Assertions.assertThrows(PatternSyntaxException.class, () -> new RegexWordMatcher(errorPattern));
    }

    @Test
    void regexWordMatcherNullPattern() {
        //arrange
        String errorPattern = null;

        //act & assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new RegexWordMatcher(errorPattern));
    }

}
