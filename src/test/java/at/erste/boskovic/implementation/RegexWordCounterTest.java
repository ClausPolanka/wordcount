package at.erste.boskovic.implementation;

import at.erste.boskovic.WordCounter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.InputStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RegexWordCounterTest {

    @ParameterizedTest
    @MethodSource("at.erste.boskovic.implementation.RegexWordCounterTest#provideTestCasesForWordCorrectWordsCounter")
    void shouldCountWordsForOnlyCorrectWords(String sentence, long expectedCount){
        WordCounter wordCounter = new RegexWordCounter();
        assertEquals(expectedCount, wordCounter.countWords(sentence));
    }

    private static Stream<Arguments> provideTestCasesForWordCorrectWordsCounter() {
        return Stream.of(
                Arguments.of("word", 1),
                Arguments.of("word word word", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("at.erste.boskovic.implementation.RegexWordCounterTest#provideTestCasesForWordsWithWhitespaces")
    void shouldCountCorrectForSeveralWhitespaces(String sentence, long expectedCount){
        test(sentence, expectedCount);
    }

    private static Stream<Arguments> provideTestCasesForWordsWithWhitespaces() {
        return Stream.of(
                Arguments.of("word\nword", 2),
                Arguments.of("word\rword", 2),
                Arguments.of("word\tword", 2)
        );
    }

    @Test
    void shouldCountWhenSeveralWhitespacesAreConcatenated(){
        test("word word \n\r word", 3);
    }

    @Test
    void shouldCountZeroForEmptyStringAndNull(){
        test("", 0);
        test(null, 0);
    }

    @Test
    void shouldNotCountWhenUmlaut(){
        test("wordü", 0);
    }

    @Test
    void shouldNotCountWithSpecialCharacters(){
        test("word? word. word! word wo$rd", 1);
    }

    @Test
    void shouldNotCountWithNumbers(){
        test("word word9 123", 1);
    }


    private void test(String sentence, long expectedCount){
        WordCounter wordCounter = new RegexWordCounter();
        assertEquals(expectedCount, wordCounter.countWords(sentence));
    }
    @ParameterizedTest
    @MethodSource("at.erste.boskovic.implementation.RegexWordCounterTest#provideTestCasesForWordCounterWithStopWords")
    void given_sentenceandstopwordsfile_when_countWords_then_expected_value(String sentence, long expectedCount) {
        InputStream stopWordsInputStream = getClass().getClassLoader().getResourceAsStream("stopword_test_files/test_stopwords.txt");

        WordCounter wordCounter = new RegexWordCounter(stopWordsInputStream);

        assertEquals(expectedCount, wordCounter.countWords(sentence));

    }

    private static Stream<Arguments> provideTestCasesForWordCounterWithStopWords() {
        return Stream.of(
                Arguments.of("word the", 1),
                Arguments.of("word a", 1),
                Arguments.of("wor3d on", 0),
                Arguments.of("wo$rd off", 0)
        );
    }

    @Test
    void plain_simple_test_case(){
        InputStream stopWordsInputStream = getClass().getClassLoader().getResourceAsStream("stopword_test_files/test_stopwords.txt");

        WordCounter wordCounter = new RegexWordCounter(stopWordsInputStream);

        assertEquals(1, wordCounter.countWords("word the"));
    }

}