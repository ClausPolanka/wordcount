package com.akhvatov.words.filter;

import com.akhvatov.words.State;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WordFilterTest {

    final State      state  = new State();
    final WordFilter filter = new WordFilter();

    @ParameterizedTest
    @ValueSource(strings = { "a", "aBc" })
    void shouldAllowOnlyLetters(String word) {
        // when
        final boolean isLetter = filter.test(word, state);

        // then
        assertThat(isLetter).isTrue();
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "a123", "a!b", "a-b", "", " " })
    void shouldNotAllowWords(String word) {
        // when
        final boolean isLetter = filter.test(word, state);

        // then
        assertThat(isLetter).isFalse();
    }
}
