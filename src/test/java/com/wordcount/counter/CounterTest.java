package com.wordcount.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.util.stream.Stream;

public class CounterTest {

    Counter counter;

    @BeforeEach
    public void setup() {
        counter = new Counter();
    }

    @ParameterizedTest
    @MethodSource("provideWordsForCounterTest")
    public void test_countWords(String word, long count) {
        Assertions.assertEquals(count, counter.countWords(word));
    }

    private static Stream<Arguments> provideWordsForCounterTest() {
        return Stream.of(
                Arguments.of("word", 1),
                Arguments.of("1dog 1cat", 0),
                Arguments.of("", 0),
                Arguments.of("  ", 0),
                Arguments.of("word dog", 2),
                Arguments.of(" word  tree 1banana ", 2)
        );
    }

}
