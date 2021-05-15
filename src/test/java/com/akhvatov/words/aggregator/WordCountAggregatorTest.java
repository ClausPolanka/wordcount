package com.akhvatov.words.aggregator;

import com.akhvatov.words.State;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class WordCountAggregatorTest {

    final State               state      = mock(State.class);
    final WordCountAggregator aggregator = new WordCountAggregator();

    @Test
    void shouldAggregateWords() {
        // when
        aggregator.aggregate("word", state);

        // then
        verify(state).incrementCounter();
    }
}
