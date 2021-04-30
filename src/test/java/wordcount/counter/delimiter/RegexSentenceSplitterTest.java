package wordcount.counter.delimiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;

class RegexSentenceSplitterTest {

    @Test
    void splitSentenceWithErrorPattern() {
        //arrange
        String errorPattern = "(";

        //act & assert
        Assertions.assertThrows(PatternSyntaxException.class, () -> new RegexSentenceSplitter(errorPattern));
    }

    @Test
    void splitSentenceWithNullPattern() {
        //arrange
        String errorPattern = null;

        //act & assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new RegexSentenceSplitter(errorPattern));
    }

    @Test
    void splitSentenceDefaultPatternWithNullSentence() {
        //arrange
        RegexSentenceSplitter regexSentenceSplitter = new RegexSentenceSplitter();

        //act & assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> regexSentenceSplitter.splitSentence(null));
    }

    @Test
    void splitSentenceOkDefaultPattern() {
        //arrange
        RegexSentenceSplitter regexSentenceSplitter = new RegexSentenceSplitter();
        String sentence = "Hello   today it 's     nice weather!";
        List<String> expectedSplittedSentence = Arrays.asList("Hello", "today", "it", "'s", "nice", "weather!");

        //act
        String[] actualSplittedSentence = regexSentenceSplitter.splitSentence(sentence);

        //assert
        Assertions.assertEquals(expectedSplittedSentence.size(), actualSplittedSentence.length);
        Arrays.stream(actualSplittedSentence)
                .forEach(element -> Assertions.assertTrue(expectedSplittedSentence.contains(element)));
    }

    @Test
    void splitSentenceOkCustomPattern() {
        //arrange
        RegexSentenceSplitter regexSentenceSplitter = new RegexSentenceSplitter("\\.+");
        String sentence = "Hello.today.it....'s.nice.weather!";
        List<String> expectedSplittedSentence = Arrays.asList("Hello", "today", "it", "'s", "nice", "weather!");

        //act
        String[] actualSplittedSentence = regexSentenceSplitter.splitSentence(sentence);

        //assert
        Assertions.assertEquals(expectedSplittedSentence.size(), actualSplittedSentence.length);
        Arrays.stream(actualSplittedSentence)
                .forEach(element -> Assertions.assertTrue(expectedSplittedSentence.contains(element)));

    }

}
