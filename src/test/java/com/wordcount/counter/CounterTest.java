package com.wordcount.counter;

import com.wordcount.dto.CounterDto;
import com.wordcount.filter.StopwordFilterMockImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CounterTest {

    Counter counter;

    @BeforeEach
    public void setup() {
        counter = new CounterImpl(new StopwordFilterMockImpl());
    }

    private static Stream<Arguments> provideWordsForCounterTest() {
        return Stream.of(
                Arguments.of("word", new CounterDto(1, 1)),
                Arguments.of("1dog 1cat", new CounterDto(0, 0)),
                Arguments.of("", new CounterDto(0, 0)),
                Arguments.of("  ", new CounterDto(0, 0)),
                Arguments.of("word dog", new CounterDto(2, 2)),
                Arguments.of(" word  tree 1banana ", new CounterDto(2, 2)),
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", new CounterDto(6, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("provideWordsForCounterTest")
    public void test_countWords(String word, CounterDto counterDto) {
        Assertions.assertEquals(counterDto, counter.countWords(word));
    }

}
