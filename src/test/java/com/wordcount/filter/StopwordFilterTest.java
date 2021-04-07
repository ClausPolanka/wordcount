package com.wordcount.filter;

import com.wordcount.reader.StopwordReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StopwordFilterTest {

    StopwordFilter stopwordFilter;

    @BeforeEach
    public void setup() {
        stopwordFilter = new StopwordFilter();
    }

    private static Stream<Arguments> provideWordsForFilterTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("dog", "cat"), Arrays.asList("dog", "cat")),
                Arguments.of(Arrays.asList("dog", "cat", "the", "a", "on", "off"), Arrays.asList("dog", "cat"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideWordsForFilterTest")
    public void test_removeStopwords(List<String> before, List<String> afterExpected) {
        List<String> afterActual = stopwordFilter.removeStopwords(before);
        Assertions.assertEquals(afterExpected, afterActual);
    }

}