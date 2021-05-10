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
    @MethodSource("at.erste.boskovic.implementation.RegexWordCounterTest#provideTestCasesForWordCounter")
    void given_sentence_when_countWords_then_expected_value(String sentence, long expectedCount){

        WordCounter wordCounter = new RegexWordCounter("[A-Za-z]+", "\\s+");

        assertEquals(expectedCount, wordCounter.countWords(sentence));
    }

    private static Stream<Arguments> provideTestCasesForWordCounter() {
        return Stream.of(
                Arguments.of("word", 1),
                Arguments.of("         word         word                          word                ", 3),
                Arguments.of("wor3d", 0),
                Arguments.of("wo$rd", 0),
                Arguments.of("word, word", 1),
                Arguments.of("word? word. word! word", 1),
                Arguments.of("", 0),
                Arguments.of(null, 0),
                Arguments.of("wordü word", 1),
                Arguments.of("wor>d", 0),
                Arguments.of("word \t  word", 2),
                Arguments.of("word\nword", 2),
                Arguments.of("word\rword", 2),
                Arguments.of("123 word", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("at.erste.boskovic.implementation.RegexWordCounterTest#provideTestCasesForWordCounterWithStopWords")
    void given_sentenceandstopwordsfile_when_countWords_then_expected_value(String sentence, long expectedCount) {
        InputStream stopWordsInputStream = getClass().getClassLoader().getResourceAsStream("stopword_test_files/test_stopwords.txt");

        WordCounter wordCounter = new RegexWordCounter("[A-Za-z]+", "\\s+", stopWordsInputStream);

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

        WordCounter wordCounter = new RegexWordCounter("[A-Za-z]+", "\\s+", stopWordsInputStream);

        assertEquals(1, wordCounter.countWords("word the"));
    }

}