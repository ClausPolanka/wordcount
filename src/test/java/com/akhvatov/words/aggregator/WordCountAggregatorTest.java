package com.akhvatov.words.aggregator;

import com.akhvatov.words.State;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordCountAggregatorTest {

    final State               state      = new State();
    final WordCountAggregator aggregator = new WordCountAggregator();

    @Test
    void shouldAggregateWords() {
        // when
        aggregator.aggregate("word", state);

        // then
        assertThat(state.getCount()).isEqualTo(1);
    }
}
