package com.akhvatov.words.modifier;

import com.akhvatov.words.State;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordCleanerTest {

    final State       state   = new State();
    final WordCleaner cleaner = new WordCleaner();

    @Test
    void shouldRemoveDots() {
        // when
        final String cleanedWord = cleaner.apply("word.", state);

        // then
        assertThat(cleanedWord).isEqualTo("word");
    }
}
