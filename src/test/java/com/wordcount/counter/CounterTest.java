package com.wordcount.counter;

import com.wordcount.filter.StopwordFilterMockImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class CounterTest {

    Counter counter;

    @BeforeEach
    public void setup() {
        counter = new CounterImpl(new StopwordFilterMockImpl());
    }


    private static Stream<Arguments> provideWordsForNumberOfWords() {
        return Stream.of(
                Arguments.of("word", 1),
                Arguments.of("1dog 1cat", 0),
                Arguments.of("", 0),
                Arguments.of("  ", 0),
                Arguments.of("word dog", 2),
                Arguments.of(" word  tree 1banana ", 2),
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 10),
                Arguments.of(".", 0),
                Arguments.of("-", 0),
                Arguments.of("a-", 0),
                Arguments.of("-.", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWordsForNumberOfWords")
    public void test_numberOfWords(String word, long numberOfWords) {
        Assertions.assertEquals(numberOfWords, counter.countWords(word).getNumberOfWords());
    }

    private static Stream<Arguments> provideWordsForNumberOfUniqueWords() {
        return Stream.of(
                Arguments.of("word", 1),
                Arguments.of("word word", 1),
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 8),
                Arguments.of("one two three", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWordsForNumberOfUniqueWords")
    public void test_numberOfUniqueWords(String word, long numberOfWords) {
        Assertions.assertEquals(numberOfWords, counter.countWords(word).getNumberOfUniqueWords());
    }

    private static Stream<Arguments> provideWordsForAverageWordLength() {
        return Stream.of(
                Arguments.of("word", new BigDecimal("4.00")),
                Arguments.of("word bicycle", new BigDecimal("5.50")),
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", new BigDecimal("5.10"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideWordsForAverageWordLength")
    public void test_averageWordLength(String word, BigDecimal average) {
        Assertions.assertEquals(average, counter.countWords(word).getAverageWorldLength());
    }



}
