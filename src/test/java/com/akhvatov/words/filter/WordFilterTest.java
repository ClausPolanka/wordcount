package com.akhvatov.words.filter;

import com.akhvatov.words.State;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

class WordFilterTest {

    final State      state  = mock(State.class);
    final WordFilter filter = new WordFilter();

    @ParameterizedTest
    @ValueSource(strings = { "a", "aBc", "a-b" })
    void shouldAllowOnlyLettersAndHyphen(String word) {
        // when
        final boolean isLetter = filter.test(word, state);

        // then
        assertThat(isLetter).isTrue();
        verifyNoInteractions(state);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "a123", "a!b", "", " " })
    void shouldNotAllowWords(String word) {
        // when
        final boolean isLetter = filter.test(word, state);

        // then
        assertThat(isLetter).isFalse();
        verifyNoInteractions(state);
    }
}
