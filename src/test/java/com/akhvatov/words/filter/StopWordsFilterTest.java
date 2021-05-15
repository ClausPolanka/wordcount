package com.akhvatov.words.filter;

import com.akhvatov.words.State;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

class StopWordsFilterTest {

    static final String STOP_WORD = "abc";

    final State           state  = mock(State.class);
    final StopWordsFilter filter = new StopWordsFilter(Stream.of(STOP_WORD));

    @ParameterizedTest
    @ValueSource(strings = { STOP_WORD, "ABC", "AbC" })
    void shouldFilterOutStopWord(String word) {
        // when
        final boolean filtered = filter.test(word, state);

        // then
        assertThat(filtered).isFalse();
        verifyNoInteractions(state);
    }

    @ParameterizedTest
    @ValueSource(strings = { "test", "TEST", "TeSt" })
    void shouldAllowWord(String word) {
        // when
        final boolean filtered = filter.test(word, state);

        // then
        assertThat(filtered).isTrue();
        verifyNoInteractions(state);
    }
}
